package example.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int maxCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            count++;
            if (count > maxCount) {
                count = 0;
                iTestResult.setStatus(ITestResult.FAILURE);
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
