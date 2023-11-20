package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Login/orangelogin.feature"}, glue = {"definition"}, plugin = {"html:report/myreport.html"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
