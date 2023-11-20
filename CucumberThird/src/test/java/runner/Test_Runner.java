package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"CucumberThird/src/test/resources/Julogin/julogin.feature"}, glue = {"definition"}, plugin = {"html:report/myreport.html"}, tags = "@PositiveTesting")
public class Test_Runner {

}
