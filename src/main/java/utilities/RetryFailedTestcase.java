package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestcase implements IRetryAnalyzer
{
	int maxRetry=3;
	int retryCount=0;
	public boolean retry(ITestResult result) 
	{
		if(!result.isSuccess()&&retryCount<maxRetry)
		{
			retryCount++;
			return true;
		}
		return false;
	}

}
