import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/search.feature", glue="Steps")
public class RunTest extends AbstractTestNGCucumberTests{

}
