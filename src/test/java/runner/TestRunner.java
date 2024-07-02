package runner;


import hooks.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.awt.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue= {"stepDef", "hooks"},
        plugin = "html:target/cucumber-reports/index.html",
        monochrome = true
)

public class TestRunner {
}
