import org.testng.annotations.Test;
import org.testng.Assert;

public class ControlExtensionTests extends foundation.TestBase {
	  /*
	   * Use abstract classes where needed (TestBase, PageObjectBase, ControlExtensionBase)
	DRY (Do not Repeat Yourself)
	SOLID (SOLID Principles)
	YAGNI (You Ain't Gonna Need It)
	Include synchronization. Test should pass when Running or Debugging. 
	  */
  @Test
  public void canSelectYes() {
	  var label = "Yes";
	  
	  var radioGroup = new RadioPage(this.driver)
	  	.getRadioGroup();
	  var yesButton = radioGroup.getButton(label);
	  yesButton.select();
	  var selected = radioGroup.getSelected();
	  
	  Assert.assertNotNull(selected, "The selected button should exist");
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
	  
	  Assert.assertNotNull(selected, "The selected button should exist");
	  Assert.assertEquals(selected.getText(), label, "The selected button should be the Impressive button");
  }
  
  @Test
  public void cannotSelectNo() {
	  var label = "No";
	  
	  var radioGroup = new RadioPage(this.driver)
	  	.getRadioGroup();
	  var noButton = radioGroup.getButton(label);
	  noButton.select();
	  var selected = radioGroup.getSelected();

	  Assert.assertNotNull(noButton, "The no button should exist");
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

	  Assert.assertEquals(results, expectedResultMessage, "The api link click should return a success message");
  }

  /*

3. https://demoqa.com/slider 
Four testcases total, one for each value (80,17,0,100)
a. Set the value then get the value in each test case.

Create the Slider control extension. Include synchronization. 
Should contain the following methods:
void setValue(String value)
String getValue()

Example usage:
Slider slider = new Slider(element);
slider.setValue(80);
slider.setValue(17);
slider.setValue(0);
slider.setValue(100);

Assert each value set.
  */
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
