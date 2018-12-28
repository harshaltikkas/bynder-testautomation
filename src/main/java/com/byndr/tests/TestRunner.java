package com.byndr.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "classpath:features",
glue= {"com.byndr.steps"},
plugin = { "pretty", 
		   "html:target/cucumber-reports",
		   //"com.byndr.pool.ExtentCucumberFormatter:target/cucumber-reports/extent_report/report.html",
		   "json:target/cucumber-reports/json_report/Cucumber.json",
		   "junit:target/cucumber-reports/junit_xml_report/Cucumber.xml"
		   },
tags = {"@Feature"},
monochrome = true
)
public class TestRunner {

}
