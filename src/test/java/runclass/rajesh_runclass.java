package runclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:features"},										//Location of the feature file folder
		glue = {"stepdefinition"}, 												//Where my definition is written
		tags= {"@tag2"},													//Which tag needs to be executed
		plugin= {"pretty","html:target/DrillDay2/SignUpSignIn"}, 									//Reports generations
		dryRun = false,																//creates body of the undefined functions
		monochrome= true															//to know the pass and fail statics
		)

public class rajesh_runclass {

}
