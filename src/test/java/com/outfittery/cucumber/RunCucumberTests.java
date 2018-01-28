package com.outfittery.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features="src/test/resources/features",
        glue = { "com.outfittery.tests" },
        format = {"pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/rerun.txt",
                "json:target/cucumber1.json"})
public class RunCucumberTests extends AbstractTestNGCucumberTests
{

}

