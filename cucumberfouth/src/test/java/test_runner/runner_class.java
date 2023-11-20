package test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/lg/lg.feature"}, glue = {"lgcucumber"}, plugin = {"html:report/myreport.html"})
public class runner_class {

}
