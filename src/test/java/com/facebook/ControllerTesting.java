package com.facebook;



import java.util.List;

import org.junit.Test;

import com.facebook.Controller.FBController;
import com.facebook.Controller.FbControllerInterface;
import com.facebook.Entiry.FbTimeline;

import junit.framework.TestCase;

public class ControllerTesting extends TestCase {
	private FbControllerInterface fc;
	protected void setUp() throws Exception {
		super.setUp();
		fc=new FBController();
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		fc=null;
}

	public void testCreateProfileController() {
		int i=fc.createProfileController();
		assert i>0:"Profile creation filed";
	}

	public void testLogInController() {
		int i=fc.logInController();
		assert i>0:"Login filed";
	}

	public void testViewAllProfileController() {
		int i=fc.viewAllProfileController();
		assert i>0:"ViewAllProfile filed";
	}

	public void testSearchProfileController() {
		int i=fc.searchProfileController();
		assert i>0:"SearchProfile filed";
	}

	public void testDeleteProfileController() {
		int i=fc.deleteProfileController();
		assert i>0:"Profile deletion filed";
	}

	public void testUpdateProfileController() {
		int i=fc.UpdateProfileController();
		assert i>0:"UpdateProfile filed";
	}

	public void testDetailProfileController() {
		int i=fc.detailProfileController();
		assert i>0:"DetailProfile filed";
	}

	public void testCreatePostController() {
		int i=fc.createPostController();
		assert i>0:"CreatePost filed";
	}

	public void testTimelineController() {
		int i=fc.TimelineController();
		assert i>0:"Timeline filed";
	}
	@Test
	public void testseePostController() {
		int i=fc.seePostController();
		assert i>0:"seePost filed";
	}

}
