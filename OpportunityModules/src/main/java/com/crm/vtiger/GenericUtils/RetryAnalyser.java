package com.crm.vtiger.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int count =0;
	int retryCount = 3;
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
