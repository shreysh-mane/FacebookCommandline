package com.facebook;



import com.facebook.Controller.FBController;
import com.facebook.Controller.FbControllerInterface;

import junit.framework.TestCase;

public class ControllerTesting extends TestCase {
	private FbControllerInterface fd;
	protected void setUp() throws Exception {
		super.setUp();
		fd=new FBController();
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		fd=null;
}

	public void testCreateProfileController() {
		fail("Not yet implemented");
	}

	public void testLogInController() {
		fail("Not yet implemented");
	}

	public void testViewAllProfileController() {
		fail("Not yet implemented");
	}

	public void testSearchProfileController() {
		fail("Not yet implemented");
	}

	public void testDeleteProfileController() {
		fail("Not yet implemented");
	}

	public void testUpdateProfileController() {
		fail("Not yet implemented");
	}

	public void testDetailProfileController() {
		fail("Not yet implemented");
	}

	public void testCreatePostController() {
		fail("Not yet implemented");
	}

	public void testTimelineController() {
		fail("Not yet implemented");
	}

}
