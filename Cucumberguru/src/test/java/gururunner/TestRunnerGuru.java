package gururunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Gurutesting/gurutest.feature"}, glue = {"definitionguru"}, plugin = {"html:report/myreport.html"}, tags = "@PositiveTesting")
public class TestRunnerGuru extends AbstractTestNGCucumberTests {

}
