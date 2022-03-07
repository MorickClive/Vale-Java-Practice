package com.mc.main.advanced.designpatterns.behavioural.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdminPostCheckerUnitTest {
	
	private static AdminPostChecker testObserver;
	private static GroupPage testPage;
	
	@BeforeAll
	public static void setup() {
		testObserver = new AdminPostChecker();
		testPage = new GroupPage("Funny Cats");
	}
	
	@Test
	public void defaultConstructor() {
		testObserver = new AdminPostChecker();
		
		assertTrue(testObserver instanceof AdminPostChecker);
	}
	
	@Test
	public void update_filter_Success() {
		testObserver.update("Message", testPage);				
	}
	
	@Test
	public void update_filter_Failure() {
		testObserver.update("dog", testPage);				
	}
	
	@Test
	public void retrieveBanList_Success() {
		testObserver.update("dog", testPage);

		assertTrue(AdminPostChecker.retrieveBanList() instanceof ArrayList<?>);
		assertEquals(1, AdminPostChecker.retrieveBanList().size());
	}

}
