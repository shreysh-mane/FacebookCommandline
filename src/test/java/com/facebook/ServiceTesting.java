package com.facebook;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;
import com.facebook.Service.FbService;
import com.facebook.Service.FbServiceInterface;

public class ServiceTesting {
	private FbServiceInterface fs;
	
	@Before
	public void setUp() throws Exception {
		fs=new FbService();
	
	}

	@After
	public void tearDown() throws Exception {
		fs=null;
	}

//	@Test
//	public void testCreateProfileService() {
//		FbUser fbu=new FbUser();
//		fbu.setfName("cc");
//		fbu.setlName("cc");
//		fbu.setEmail("cc@");
//		fbu.setPassword("cc");
//		int i=fs.createProfileService(fbu);
//		
//		assert i>0:"Profile creation faild";
//	}
//
//	@Test
//	public void testLogInService() {
//		FbUser fbu=new FbUser();
//		fbu.setEmail("bb@");
//		fbu.setPassword("bb");
//		
//		int i=fs.logInService(fbu);
//		assert i>0:"Log in faild";
//	}
//
//	@Test
//	public void testViewAllProfileService() {
//		List<FbUser> fbuList=fs.viewAllProfileService();
//		assert fbuList!=null:"view Profile test failed";
//	}
//
//	@Test
//	public void testSearchProfileService() {
//		FbUser fbu=new FbUser();
//		fbu.setEmail("bb@");
//				
//		FbUser fbutest=fs.searchProfileService(fbu);
//		assert fbutest!=null:"view Profile test failed";
//	}
//
//
//	@Test
//	public void testUpdateProfileService() {
//		FbUser fbu=new FbUser();
//		fbu.setfName("ca");
//		fbu.setlName("ca");
//		fbu.setEmail("cc@");
//		
//		int i=fs.UpdateProfileService(fbu);
//		assert i>0:"Update faild";
//	}
//
//	@Test
//	public void testDetailProfileService() {
//		FbUser fbu=new FbUser();
//		fbu.setEmail("bb@");
//		FbUser fbuTest=fs.detailProfileService(fbu);
//		assert fbuTest!=null:"Detail Profile test failed";
//	}
//
//	@Test
//	public void testCreatePostService() {
//		FbTimeline fbt=new FbTimeline();
//		fbt.setEmail("cc@");
//		fbt.setMessage("I am cc");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//	    Date date = new Date();  
//	    fbt.setTime(formatter.format(date));  
//	    
//	    int i=fs.createPostService(fbt);
//		assert i>0:"createPostDAO faild";
//	}
//
//	@Test
//	public void testTimelineService() {
//		FbTimeline fbt=new FbTimeline();
//		fbt.setEmail("cc@");
//		
//		List<FbTimeline>fbtList =fs.TimelineService(fbt);
//		assert fbtList!=null:"testTimelineDAO failed";
//	}
//	
//	@Test
//	public void testDeleteProfileService() {
//		FbUser fbu=new FbUser();
//		fbu.setEmail("cc@");
//		fbu.setPassword("cc");
//		int i=fs.deleteProfileService(fbu);
//		
//		assert i>0:"Profile creation faild";
//	}
	@Test
	public void testseePostService() {
		FbTimeline fbt=new FbTimeline();
		fbt.setEmail("abhinav@gmail.com");
		
		List<FbTimeline>fbtList =fs.seePostService(fbt);
		assert fbtList!=null:"seePost failed";
	}

}
