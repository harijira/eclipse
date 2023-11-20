package guruRunnerPosNeg;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/GuruPosNeg/gurupostivenegative.feature"}, glue = {"guruPosNegDefinition"}, plugin = {"html:report/myreportGuruPosNeg.html"}, tags = "@NegativeTesting")
public class GuruPosNegTestRunner extends AbstractTestNGCucumberTests {

}
