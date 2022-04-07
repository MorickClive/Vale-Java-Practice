package com.mc.main;

import org.junit.jupiter.api.Test;

public class RunnerUnitTEST {
	// Typically app Runners don't contribute a meaningful unit test
	// in advanced testing you might mock this behaviour or simply test
	// that the application runs to completion; although this isn't always possible.
	
	//TODO: Mock associated class calls.
	// Additionally, mocking would be required in order to isolate code run by association
	// as we are only concerned with code that occurs in Runner.main, nothing it calls.
	
	@Test
	public void startTest() {
		Runner.main(new String[]{"-a"});
	}

}
	