package com.facebook.DAO;

import java.util.List;

import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;

public interface FbDAOInterface {

	int createProfileDAO(FbUser fbu);

	int LogInDAO(FbUser fbu);

	List<FbUser> viewAllProfileDAO();

	FbUser searchProfileDAO(FbUser fbUser);

	int deleteProfileDAO(FbUser fbUser);

	int UpdateProfileDAO(FbUser fbUser);

	FbUser detailProfileDAO(FbUser fbUser);

	int createPostDAO(FbTimeline fbt);

	List<FbTimeline> TimelineDAO(FbTimeline fbt);

	

}
