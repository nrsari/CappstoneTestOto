package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:Reports/htmlReport.html",
                "json:Reports/jsonReport.json"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        dryRun = false,
        publish = true
)

public class Runner {
}
