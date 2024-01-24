package Driver;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags= "@tag1",features = "src/test/resources/Features/login.feature",glue={"StepDefinations"},
plugin = {"json:target/cucumber.json", "html:target/cucumber.html"})
public class CucumberRunner extends AbstractTestNGCucumberTests{
}

