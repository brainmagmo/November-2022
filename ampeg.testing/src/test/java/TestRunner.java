import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features"})

public class TestRunner extends AbstractTestNGCucumberTests {
    /*
     * Right click here and select Run as -> TestNG Test
     * or do Alt+Shift+X then press N
     */
}