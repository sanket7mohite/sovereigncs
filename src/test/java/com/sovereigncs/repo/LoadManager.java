package com.sovereigncs.repo;

public class LoadManager implements Cloneable {

	private double TestCaseId;
	
	public Object clone() throws
    CloneNotSupportedException
		{
		return super.clone();
	}
	
	public void setTestCaseId(double testCaseId) {
		TestCaseId = testCaseId;
	}
	public String getTestCaseId() {
		return String.valueOf(Math.round(TestCaseId));
	}
}
