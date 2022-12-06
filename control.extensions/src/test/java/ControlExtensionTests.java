import org.testng.annotations.Test;
import org.testng.Assert;

public class ControlExtensionTests extends foundation.TestBase {

  @Test
  public void canSelectYes() {
	  var label = "Yes";
	  
	  var radioGroup = new RadioPage(this.driver)
	  	.getRadioGroup();
	  var yesButton = radioGroup.getButton(label);
	  yesButton.select();
	  var selected = radioGroup.getSelected();
	  
	  Assert.assertNotNull(selected, "The selected button should exist.");
	  Assert.assertEquals(selected.getText(), label, "The selected button should be the Yes button.");
  }
  
  @Test
  public void canSelectImpressive() {
	  var label = "Impressive";
	  
	  var radioGroup = new RadioPage(this.driver)
	  	.getRadioGroup();
	  var impressiveButton = radioGroup.getButton(label);
	  impressiveButton.select();
	  var selected = radioGroup.getSelected();
	  
	  Assert.assertNotNull(selected, "The selected button should exist.");
	  Assert.assertEquals(selected.getText(), label, "The selected button should be the Impressive button.");
  }
  
  @Test
  public void cannotSelectNo() {
	  var label = "No";
	  
	  var radioGroup = new RadioPage(this.driver)
	  	.getRadioGroup();
	  var noButton = radioGroup.getButton(label);
	  noButton.select();
	  var selected = radioGroup.getSelected();

	  Assert.assertNotNull(noButton, "The no button should exist.");
	  Assert.assertNull(selected, "The no button should not be able to be selected.");
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

	  Assert.assertEquals(results, expectedResultMessage, "The api link click should return a success message.");
  }
  
  @Test
  public void cannotSetSlider80() {
	  var number = 80;
	  var expected = Integer.toString(number);
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  Assert.assertEquals(value, expected, "The slider should be set to 80.");
  }
  
  @Test
  public void cannotSetSlider17() {
	  var number = "17";
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  Assert.assertEquals(value, number, "The slider should be set to 17.");
  }
  
  @Test
  public void cannotSetSlider0() {
	  var number = 0;
	  var expected = Integer.toString(number);
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  Assert.assertEquals(value, expected, "The slider should be set to 0.");
  }
  
  @Test
  public void cannotSetSlider100() {
	  var number = 100;
	  var expected = Integer.toString(number);
	  
	  var page = new SliderPage(this.driver);
	  var slider = page.getSlider();
	  slider.setValue(number);
	  var value = slider.getValue();

	  Assert.assertEquals(value, expected, "The slider should be set to 100.");
  }

  /*

4. https://demoqa.com/select-menu
Use Selenium 'Select' control extension to wrap the "Old Style Select Menu" dropdown/select list.
Two test cases total. 
a. Set a value (not the first or last in the list) then get the value
b. Get all options as String[] (Because arrays are non-mutable)

Assert each value set.
  */
  /*

4. https://demoqa.com/select-menu
Create a MultiSelect Control Extension.
One Test case total.
a. Select 2 options from the list (not the first or last option).
b. Get the selected values as String[].
   */
}
