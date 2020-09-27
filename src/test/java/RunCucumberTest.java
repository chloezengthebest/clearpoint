import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Junit Test Class
@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/test/resources/features"
//        ,tags = "@countdown or @headless"
//        ,tags = "@twitter"
//        ,tags = "@api"
        , plugin = {"pretty", "json:target/cucumber.json", "html:target/site/testReport.html"}
)

public class RunCucumberTest {

}
