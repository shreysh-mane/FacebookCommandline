package com.facebook;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.facebook.DAO.FbDAO;
import com.facebook.DAO.FbDAOInterface;
import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;

import junit.framework.TestCase;

public class DAOTesting extends TestCase {
	private FbDAOInterface fd;
	
	protected void setUp() throws Exception {
		super.setUp();
		fd=new FbDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		fd=null;
	}

	public void testCreateProfileDAO() {
		FbUser fbu=new FbUser();
		fbu.setfName("cc");
		fbu.setlName("cc");
		fbu.setEmail("cc@");
		fbu.setPassword("cc");
		int i=fd.createProfileDAO(fbu);
		
		assert i>0:"Profile creation faild";
		
	
	}

	public void testLogInDAO() {
		FbUser fbu=new FbUser();
		fbu.setEmail("bb@");
		fbu.setPassword("bb");
		
		int i=fd.LogInDAO(fbu);
		assert i>0:"Log in faild";
		
	}

	public void testViewAllProfileDAO() {
		List<FbUser> fbuList=fd.viewAllProfileDAO();
		assert fbuList!=null:"view Profile test failed";
	}

	public void testSearchProfileDAO() {
		FbUser fbu=new FbUser();
		fbu.setEmail("bb@");
				
		FbUser fbutest=fd.searchProfileDAO(fbu);
		assert fbutest!=null:"view Profile test failed";
	}

	

	public void testUpdateProfileDAO() {
		FbUser fbu=new FbUser();
		fbu.setfName("cc");
		fbu.setlName("cc");
		fbu.setEmail("cc@");
		
		int i=fd.UpdateProfileDAO(fbu);
		assert i>0:"Update faild";
		
	}

	public void testDetailProfileDAO() {
		FbUser fbu=new FbUser();
		fbu.setEmail("bb@");
		FbUser fbuTest=fd.detailProfileDAO(fbu);
		assert fbuTest!=null:"Detail Profile test failed";
	}
	
	
	
	
	public void testCreatePostDAO() {
		FbTimeline fbt=new FbTimeline();
		fbt.setEmail("cc@");
		fbt.setMessage("I am cc");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    fbt.setTime(formatter.format(date));  
	    
	    int i=fd.createPostDAO(fbt);
		assert i>0:"createPostDAO faild";
	}

	public void testTimelineDAO() {
		
		FbTimeline fbt=new FbTimeline();
		fbt.setEmail("cc@");
		
		List<FbTimeline>fbtList =fd.TimelineDAO(fbt);
		assert fbtList!=null:"testTimelineDAO failed";
	}
	
	public void testDeleteProfileDAO() {
		FbUser fbu=new FbUser();
		fbu.setEmail("cc@");
		fbu.setPassword("cc");
		
		int i=fd.deleteProfileDAO(fbu);
		assert i>0:"Deletion faild";
	}
	@Test
	public void testseePostDAO() {
		FbTimeline fbt=new FbTimeline();
		fbt.setEmail("abhinav@gmail.com");
		
		List<FbTimeline>fbtList =fd.seePostDAO(fbt);
		assert fbtList!=null:"seePost failed";
	}

}
