package runner2;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Login/login1.feature"}, glue = {"definition"}, plugin = {"html:report/myreport.html"}, tags="@PositiveTesting")
public class TestRunner2 {
	
}
