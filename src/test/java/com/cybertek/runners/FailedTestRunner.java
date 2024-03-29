package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin="json:target/cucumber.json",
        features = "@target/rerun.txt",
        glue = "com/cybertek/step_definitions"
)
public class FailedTestRunner {
}
