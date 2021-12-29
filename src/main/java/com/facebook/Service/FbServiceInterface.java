package com.facebook.Service;

import java.util.List;

import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;

public interface FbServiceInterface {

	int createProfileService(FbUser fbu);



	int logInService(FbUser fbu);



	List<FbUser> viewAllProfileService();



	FbUser searchProfileService(FbUser fbUser);



	int deleteProfileService(FbUser fbUser);



	int UpdateProfileService(FbUser fbUser);



	FbUser detailProfileService(FbUser fbUser);



	int createPostService(FbTimeline fbt);



	List<FbTimeline> TimelineService(FbTimeline fbt);





}
