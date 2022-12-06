import org.testng.annotations.Test;
import page.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class ControlExtensionTests extends foundation.TestBase {

  @Test
  public void canSelectYes() {
	  var label = "Yes";
	  
	  var radioGroup = new RadioPage(this.driver)
	  	.getRadioGroup();
	  var yesButton = radioGroup.getButton(label);
	  yesButton.select();
	  var selected = radioGroup.getSelected();
	  
	  assertNotNull(selected, "The selected button should exist.");
	  assertEquals(selected.getText(), label, "The selected button should be the Yes button.");
  }
  
  @Test
  public void canSelectImpressive() {
	  var label = "Impressive";
	  
	  var radioGroup = new RadioPage(this.driver)
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
	  
	  var radioGroup = new RadioPage(this.driver)
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
	  
	  var page = new LinksPage(this.driver);
	  var link = page
	  	.getLink(label);
	  link.click();
	  var results = page.getResults();

	  assertEquals(results, expectedResultMessage, "The api link click should return a success message.");
  }
  
  @Test
  public void cannotSetSlider80() {
	  var number = 80;
	  var expected = Integer.toString(number);
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  assertEquals(value, expected, "The slider should be set to 80.");
  }
  
  @Test
  public void cannotSetSlider17() {
	  var number = "17";
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  assertEquals(value, number, "The slider should be set to 17.");
  }
  
  @Test
  public void cannotSetSlider0() {
	  var number = 0;
	  var expected = Integer.toString(number);
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  assertEquals(value, expected, "The slider should be set to 0.");
  }
  
  @Test
  public void cannotSetSlider100() {
	  var number = 100;
	  var expected = Integer.toString(number);
	  
	  var slider = new SliderPage(this.driver).getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  assertEquals(value, expected, "The slider should be set to 100.");
  }
  
  @Test
  public void canSelect() {
	  var color = "Purple";

	  var dropdown = new SelectPage(this.driver).getSelectDropdown();
	  dropdown.setValue(color);
	  var value = dropdown.getValue();

	  assertEquals(value, color, "The dropdown should be selected from.");
  }
  
  @Test
  public void canGetSelectOptions() {
	  String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua"};
	  
	  var dropdown = new SelectPage(this.driver).getSelectDropdown();
	  var options = dropdown.getOptions();

	  assertEquals(options, colors, "The dropdown should be selected from.");
  }
  
  @Test
  public void canSelectEach() {
	  String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua"};
	  
	  var dropdown = new SelectPage(this.driver).getSelectDropdown();
	  for(var color: colors) {
		  dropdown.setValue(color);
		  var value = dropdown.getValue();
	
		  assertEquals(value, color, "The dropdown should be selected from.");
	  }
  }
  
  @Test
  public void canMultiSelect() {
	  String[] choices = {"Saab", "Opel"};

	  var multi = new SelectPage(this.driver).getMultiselect();
	  for(var choice: choices) {
		  multi.select(choice);
	  }
	  
	  var values = multi.getSelected();

	  assertEquals(values, choices, "The dropdown should be selected from.");
  }
}
