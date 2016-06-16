package com.tt.tm;

public class TimeBreak implements TimeEasy {

	@Override
	public void test() throws Exception {
		
		Thread.sleep(3*1000);
		
	}

	@Override
	public String test(String rowKey, String data) throws Exception {
		
		return "hello world!";
		
	}

	
}
