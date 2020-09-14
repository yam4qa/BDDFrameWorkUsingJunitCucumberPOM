package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features/navigation.feature", glue = {
		"steps" }, dryRun = false, monochrome = true, plugin = { "pretty", "html:test-output" })
//If dryRun is true it runs without launching the browser. 
// better run with dryrun true to get the definitions of feature steps to put into Steps file 
public class NavigationRunner {

}
