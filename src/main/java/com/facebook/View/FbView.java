package com.facebook.View;

import java.util.Scanner;

import com.facebook.Constants.MessageConstant;
import com.facebook.Controller.FbControllerInterface;
import com.facebook.Utility.ControllerFactory;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class FbView {
	
	
	public static void main(String[] args) {
		
		Scanner scn= new Scanner(System.in);
		FbControllerInterface fbC=ControllerFactory.createObj();
		String loopControl="y";
		String message="";
		
		while(loopControl.equals("y")) {
		System.out.println(MessageConstant.welcomeMsg);
		System.out.println(MessageConstant.logInCoice);
		System.out.print(MessageConstant.enterChoice);
		
		
		
		switch(scn.nextInt()) {
		case 1:int result=fbC.createProfileController();
				message= result>=0 ?MessageConstant.profileCreated:MessageConstant.error;
				System.out.println(message);
			break;
		case 2:int loginCheck=fbC.logInController();
				if(loginCheck==1) {
					message=MessageConstant.logInSuccessfull;
					System.out.println(message);
					FbView.loggedIn();
				}else if(loginCheck==2) {
					message=MessageConstant.incorrectPassword;
					System.out.println(message);
				}else {
					message=MessageConstant.incorrectEmail;
					System.out.println(message);
				}
				
			break;
		default:
			System.out.println(MessageConstant.choseCorrect);
		}
		System.out.println(MessageConstant.exitChoice);
		loopControl=scn.next().equalsIgnoreCase("y")?"y":"n";
		
		}
		scn.close();
	}

	private static void loggedIn() {
		
		Scanner scn= new Scanner(System.in);
		FbControllerInterface fbC=ControllerFactory.createObj();
		String message="";
		String loopControl="y";
		
		while(loopControl.equals("y")) {
		System.out.println(MessageConstant.profileOperation);
		System.out.print(MessageConstant.enterChoice);
		String choice=scn.next();
		
		switch(choice) {
		case "1":int totalProfiles=fbC.viewAllProfileController();
				System.out.println(MessageConstant.profilesShown+totalProfiles);
		break;
		case "2":int ProfileStat=fbC.searchProfileController();
				message=ProfileStat>0?MessageConstant.profileFound:MessageConstant.profileNotFound;
				System.out.println(message);
				break;
		
		case "3":int DeleteStat=fbC.deleteProfileController();
				message=DeleteStat>0?MessageConstant.ProfileDeleted:MessageConstant.ProfileNotDeleted;
				System.out.println(message);
				break;
		case "4":int EditStat=fbC.UpdateProfileController();
				message=EditStat>0?MessageConstant.ProfileUpdated:MessageConstant.ProfileUpdateError;
				System.out.println(message);
				break;
		case "5":int DetailStat=fbC.detailProfileController();
				 message=DetailStat>0?MessageConstant.ProfileDetail:MessageConstant.error;
				 System.out.println(message);
				 break;
		case "6":int SendStat=fbC.createPostController();
		 	     message=SendStat>0?MessageConstant.MessagePosted:MessageConstant.error;
		 	     System.out.println(message);
		 	     break;
		case "7":int TimelineStat=fbC.TimelineController();
		 		 message=TimelineStat>0?MessageConstant.TimelineShow:MessageConstant.error;
		 		 System.out.println(message);
		 		 break;
		default :
			if(choice.equalsIgnoreCase("q")) {
				loopControl="n";
			}
			break;
		}
		}
	}

}
