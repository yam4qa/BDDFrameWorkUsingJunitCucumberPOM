package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; // this one especially copy and paste

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features/login.feature", glue = {
		"steps" }, dryRun = false, monochrome = true, plugin = { "pretty", "html:test-output" })

public class LoginRunner {
}
