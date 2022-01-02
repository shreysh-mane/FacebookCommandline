package com.facebook.Queries;

public class Queries {
	
	public static final String fb_Insert="insert into FBUser values(?,?,?,?)";
	public static final String fb_getPassword="select password from FBUser where email=?";
	public static final String fb_getAllProfiles="select fname,lname from FBUser";
	public static final String fb_searchProfile="select fname,lname,email from FBUser where email=?";
	public static final String fb_deleteProfile="{call deleteuser(?,?)}";
	public static final String fb_updateProfile="UPDATE fBUser SET FNAME=?,LNAME=? WHERE EMAIL=?";
	public static final String fb_detailProfile="select fname,lname from FBUser where email=?";
	public static final String fb_insertTimeline="insert into timeline values(?,?,?)";
	public static final String fb_getTimeline="select post,posttime from timeline where email=?";
	public static final String fb_getPostTimeline="select POST, FNAME FROM FBUSER,TIMELINE WHERE FBUSER.EMAIL=TIMELINE.EMAIL AND TIMELINE.EMAIL!=?";
}
