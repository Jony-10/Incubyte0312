import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = {"src/test/java/features/ComposeMailOutlook.feature"},
        glue = "stepDef",
        plugin = {"pretty",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
}
)



public class TestRunner extends AbstractTestNGCucumberTests {
}
