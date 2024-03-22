package com.buildListeners;

import com.buildSettings.TestEnvironment;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class TestNGRetry extends TestEnvironment implements IRetryAnalyzer {

    private int retryStatus = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            int retryLimit = 2;
            if (retryStatus < retryLimit) {
                retryStatus++;
                iTestResult.setStatus(ITestResult.FAILURE);
                logger.info(String.format(ANSI_RED + "TEST RETRY (%d/" + retryLimit + "): %S" + ANSI_RESET, retryStatus,
                        iTestResult.getMethod().getDescription()));
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}