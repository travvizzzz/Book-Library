package com.example.demo.acceptance;

import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
@SelectClasspathResource("features")
public class CucumberTest 
{

}
