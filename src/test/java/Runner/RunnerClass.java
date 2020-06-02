package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"classpath:feature/Addrecipient_varun.feature"},
glue = {"classpath:StepDefiniation"},
tags= "@Varun1",
plugin= {"pretty","html:classpath:Results"},
dryRun = false,
monochrome= true)

public class RunnerClass {
	
	

}
