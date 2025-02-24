package actions;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber-report.json,pretty,timeline:build/test-results/timeline")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "actions")
/*@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "actions"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "baseapirequests"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "specs")
})*/
//@ExtendWith(SerenityJUnit5Extension.class)  // Ensures Serenity lifecycle is triggered
public class TestRunner {
}
