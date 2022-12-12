import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class ControlExtensionTests extends foundation.TestBase {

	@Test
	public void canSelectValue() {
		var buttonValue = "Yes";

		var selectedValue = fromPages()
				.getRadioButtonPage()
				.selectRadioButtonValue(buttonValue)
				.getSelectedValue();

		assertEquals(selectedValue, buttonValue, "The selected button should be the Yes button.");
	}

	@Test
	public void canSelectImpressive() {
		var label = "Impressive";

		var radioGroup = fromPages()
				.getRadioButtonPage()
				.getRadioGroup();
		var impressiveButton = radioGroup.getButton(label);
		impressiveButton.select();
		var selected = radioGroup.getSelected();

		assertNotNull(selected, "The selected button should exist.");
		assertEquals(selected.getText(), label, "The selected button should be the Impressive button.");
	}

	@Test
	public void cannotSelectNo() {
		var label = "No";

		var radioGroup = fromPages()
				.getRadioButtonPage()
				.getRadioGroup();
		var noButton = radioGroup.getButton(label);
		noButton.select();
		var selected = radioGroup.getSelected();

		assertNotNull(noButton, "The no button should exist.");
		assertNull(selected, "The no button should not be able to be selected.");
	}

	@Test
	public void cannotMakeAPICall() {
		var label = "Created";
		var expectedResultMessage = "Link has responded with staus 201 and status text Created";

		var results = fromPages()
				.getLinksPage()
				.getLinkClickResults(label);

		assertEquals(results, expectedResultMessage, "The api link click should return a success message.");
	}

	@Test
	public void cannotSetSlider80() {
		var number = 80;
		var expected = Integer.toString(number);

		var value = fromPages().getSliderPage()
				.setSliderValue(number)
				.getSliderValue();

		assertEquals(value, expected, "The slider should be set to 80.");
	}

	@Test
	public void cannotSetSlider17() {
		var number = "17";

		var value = fromPages().getSliderPage()
				.setSliderValue(number)
				.getSliderValue();

		assertEquals(value, number, "The slider should be set to 17.");
	}

	@Test
	public void cannotSetSlider0() {
		var number = 0;
		var expected = Integer.toString(number);

		var value = fromPages().getSliderPage()
				.setSliderValue(number)
				.getSliderValue();

		assertEquals(value, expected, "The slider should be set to 0.");
	}

	@Test
	public void cannotSetSlider100() {
		var expected = "100";
		var number = Integer.parseInt(expected);

		var value = fromPages().getSliderPage()
				.setSliderValue(number)
				.getSliderValue();

		assertEquals(value, expected, "The slider should be set to 100.");
	}

	@Test
	public void canSelect() {
		var color = "Purple";
		
		var value = fromPages()
				.getSelectPage()
				.setSingleSelectValue(color)
				.getSingleSelectValue();


		assertEquals(value, color, "The dropdown should be selected from.");
	}

	@Test
	public void canGetSelectOptions() {
		String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua"};

		var options = fromPages()
				.getSelectPage()
				.getSelectDropdown()
				.getOptions();

		assertEquals(options, colors, "The dropdown should be selected from.");
	}

	@Test
	public void canSelectEach() {
		String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua"};

		var dropdown = fromPages()
				.getSelectPage()
				.getSelectDropdown();
		for(var color: colors) {
			dropdown.setValue(color);
			var value = dropdown.getValue();

			assertEquals(value, color, "The dropdown should be selected from.");
		}
	}

	@Test
	public void canMultiSelect() {
		String[] choices = {"Saab", "Opel"};

		var multi = fromPages()
				.getSelectPage()
				.getMultiselect();
		for(var choice: choices) {
			multi.select(choice);
		}

		var values = multi.getSelected();

		assertEquals(values, choices, "The dropdown should be selected from.");
	}
}
