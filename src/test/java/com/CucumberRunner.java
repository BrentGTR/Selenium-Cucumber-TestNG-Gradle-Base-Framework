package com;

import com.buildSettings.TestEnvironment;
import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "not @ignore",
        features = "src/test/resources/features",
        glue = "com.steps",
        plugin = {"pretty", "html:target/cucumber-report/single", "json:target/reports/cucumber.json"},
        publish = true
)
//This is experimental file and doesn't work well when using current settings.
//If you would like to use CucumberRunner for running feature files, you have to edit build.gradle file.
public class CucumberRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    private final TestEnvironment testEnvironment = new TestEnvironment();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        try {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        } catch (Exception e) {
            // Handle exception
        }
    }

    @Test(groups = "Cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

//    @DataProvider
//    public Object[][] scenarios() {
//        if (testNGCucumberRunner == null) {
//            return new Object[0][0];
//        }
//        return testNGCucumberRunner.provideScenarios();
//    }

//    @DataProvider
//    public Object[][] scenarios() {
//        return (testNGCucumberRunner != null) ? testNGCucumberRunner.provideScenarios() : new Object[0][0];
//    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        try {
            if (testNGCucumberRunner != null) {
                testNGCucumberRunner.finish();
                testEnvironment.allureWriteProperties();
                testEnvironment.allureWriteExecutors();
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
}