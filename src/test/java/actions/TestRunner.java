package actions;

import org.junit.platform.suite.api.*;

/*@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")  // Ensure this matches your feature file directory
@ConfigurationParameter(key = "cucumber.glue", value = "actions") // Step definition package
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@smoke") // Runs specific tags*/

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestRunner {
}
