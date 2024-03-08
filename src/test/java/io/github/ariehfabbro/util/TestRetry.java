package io.github.ariehfabbro.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        int maxRetryCount = 2;

        if (retryCount <= maxRetryCount) {
            retryCount++;

            return true;
        }

        return false;
    }
}
