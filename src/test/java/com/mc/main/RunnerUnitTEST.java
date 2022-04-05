package com.mc.main;

import org.junit.jupiter.api.Test;

public class RunnerUnitTEST {
	// Typically app Runners don't contribute a meaningful unit test
	// in advanced testing you might mock this behaviour or simply test
	// that the application runs to completion; although this isn't always possible.
	
	@Test
	public void startTest() {
		Runner.main(null);
	}

}
	