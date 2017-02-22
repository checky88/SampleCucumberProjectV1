import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
tags = "@version1" ,
features = "src/test/resources"
)

public class cukesRunnerTest {

}