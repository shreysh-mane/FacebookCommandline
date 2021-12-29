package com.facebook.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.facebook.Constants.MessageConstant;
import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;
import com.facebook.Service.FbServiceInterface;
import com.facebook.Utility.ServiceFactory;

public class FBController implements FbControllerInterface {
	private static String UserEmail;
	
	public int createProfileController() {
		Scanner scn=new Scanner(System.in);
		FbServiceInterface fbS=ServiceFactory.createObj();
		FbUser fbu=new FbUser();
		
		System.out.println(MessageConstant.enterFName);
		fbu.setfName(scn.next());
		System.out.println(MessageConstant.enterLName);
		fbu.setlName(scn.next());
		System.out.println(MessageConstant.enterEmail);
		fbu.setEmail(scn.next());
		System.out.println(MessageConstant.enterPassword);
		fbu.setPassword(scn.next());
		
		return fbS.createProfileService(fbu);
	}

	@Override
	public int logInController() {
		Scanner scn=new Scanner(System.in);
		FbServiceInterface fbS=ServiceFactory.createObj();
		FbUser fbu=new FbUser();
		
		System.out.println(MessageConstant.enterEmail);
		fbu.setEmail(scn.next());
		System.out.println(MessageConstant.enterPassword);
		fbu.setPassword(scn.next());
		
		int result=fbS.logInService(fbu);
		if(result==1) {
			UserEmail=fbu.getEmail();
		}
		
		return result;
	}

	@Override
	public int viewAllProfileController() {
		int i=0;
		Scanner scn=new Scanner(System.in);
		FbServiceInterface fbS=ServiceFactory.createObj();
		List<FbUser> FbUserList=fbS.viewAllProfileService();
		
		for(FbUser user:FbUserList) {
			i++;
			System.out.println(i+"."+user.getfName()+" "+user.getlName());	
		}
		return i;
	}

	@Override
	public int searchProfileController() {
		int profileCheck=0; 
		Scanner scn=new Scanner(System.in);
		FbServiceInterface fbS=ServiceFactory.createObj();
		
		System.out.println(MessageConstant.enterEmail);
		FbUser fbUser=new FbUser();
		fbUser.setEmail(scn.next());
		
		FbUser fbUserFound=fbS.searchProfileService(fbUser);
		Optional<FbUser>UserCheck =Optional.ofNullable(fbUserFound);
		if(UserCheck.isPresent()) {
			System.out.println(MessageConstant.UserDetails);
			System.out.println(MessageConstant.FName+fbUserFound.getfName());
			System.out.println(MessageConstant.LName+fbUserFound.getlName());
			System.out.println(MessageConstant.Email+fbUserFound.getEmail());
			profileCheck=1;
		}

		return profileCheck;
		
	}

	@Override
	public int deleteProfileController() {
		Scanner scn=new Scanner(System.in);
		FbServiceInterface fbS=ServiceFactory.createObj();
		FbUser fbUser=new FbUser();

		System.out.println(MessageConstant.enterPassword);
		fbUser.setPassword(scn.next());
		fbUser.setEmail(UserEmail);
		return fbS.deleteProfileService(fbUser);
	}

	@Override
	public int UpdateProfileController() {
		Scanner scn=new Scanner(System.in);
		FbServiceInterface fbS=ServiceFactory.createObj();
		FbUser fbUser=new FbUser();
		
		System.out.println(MessageConstant.enterFName);
		fbUser.setfName(scn.next());
		System.out.println(MessageConstant.enterLName);
		fbUser.setlName(scn.next());
		fbUser.setEmail(UserEmail);
		
		return fbS.UpdateProfileService(fbUser);
	}

	@Override
	public int detailProfileController() {
		int profileCheck=0;
		FbServiceInterface fbS=ServiceFactory.createObj();
		FbUser fbUser=new FbUser();
		fbUser.setEmail(UserEmail);
		
		FbUser fbUserFound=fbS.searchProfileService(fbUser);
		Optional<FbUser>UserCheck =Optional.ofNullable(fbUserFound);
		if(UserCheck.isPresent()) {
			System.out.println(MessageConstant.UserDetails);
			System.out.println(MessageConstant.FName+fbUserFound.getfName());
			System.out.println(MessageConstant.LName+fbUserFound.getlName());
			profileCheck=1;
		}

		return profileCheck;
	}

	@Override
	public int createPostController() {
		FbTimeline fbt=new FbTimeline();
		Scanner scn=new Scanner(System.in);
		System.out.println(MessageConstant.UserGetPost);
		fbt.setMessage(scn.next());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    fbt.setTime(formatter.format(date));  
	    fbt.setEmail(UserEmail);
		
	    FbServiceInterface fbS=ServiceFactory.createObj();
		return fbS.createPostService(fbt);
	}

	@Override
	public int TimelineController() {
		int i=0; 
		FbServiceInterface fbS=ServiceFactory.createObj();
		 FbTimeline fbt=new FbTimeline();
		 fbt.setEmail(UserEmail);
		 List <FbTimeline> timelinearray=fbS.TimelineService(fbt);
		 
		 for(FbTimeline timeline:timelinearray) {
			 System.out.print(MessageConstant.Post);
			 System.out.println(timeline.getMessage());
			 System.out.print(MessageConstant.Time);
			 System.out.println(timeline.getTime());
			 i++;
		 }
		 
		return i;
		
	}

}
