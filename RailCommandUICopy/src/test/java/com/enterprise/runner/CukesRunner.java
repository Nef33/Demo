package com.enterprise.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"
             //   "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features" ,
        glue = "com/enterprise/steps",
        dryRun = false,
        tags = ""
)
public class CukesRunner {

}
