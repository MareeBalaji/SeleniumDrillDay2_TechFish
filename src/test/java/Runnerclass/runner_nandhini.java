package Runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:Feature/Appoinment_nandhini.Feature"}, glue = { "classpath:StepDefenition/Appoinment_nandhini" },  dryRun = false, monochrome = true)
public class runner_nandhini {

}
