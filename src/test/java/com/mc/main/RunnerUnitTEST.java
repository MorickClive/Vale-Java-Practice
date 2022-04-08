package com.mc.main;

import org.junit.jupiter.api.Test;

public class RunnerUnitTEST {
	// Typically app Runners don't contribute a meaningful unit test
	// in advanced testing you might mock this behaviour or simply test
	// that the application runs to completion; although this isn't always possible.

	//TODO: Implement written code test.
	// mocking static methods from an enum won't do, code refactor will need review.
	
	@Test
	public void startTest() {
		Runner.setTestMode();
		Runner.main(new String[]{"-a"});
	}
	
}
	