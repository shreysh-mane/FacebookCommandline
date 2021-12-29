package com.facebook.Service;

import java.util.List;

import com.facebook.DAO.FbDAOInterface;
import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;
import com.facebook.Utility.DAOFactory;

public class FbService implements FbServiceInterface {

	public int createProfileService(FbUser fbu) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		
		return fbDAO.createProfileDAO(fbu);
	}

	@Override
	public int logInService(FbUser fbu) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		
		return fbDAO.LogInDAO(fbu);
	}

	@Override
	public List<FbUser> viewAllProfileService() {
		// TODO Auto-generated method stub
		FbDAOInterface fbDAO=DAOFactory.createObj();
		
		return fbDAO.viewAllProfileDAO();
	}

	@Override
	public FbUser searchProfileService(FbUser fbUser) {
		// TODO Auto-generated method stub
		FbDAOInterface fbDAO=DAOFactory.createObj();
		
		return fbDAO.searchProfileDAO(fbUser);
	}

	@Override
	public int deleteProfileService(FbUser fbUser) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		return fbDAO.deleteProfileDAO(fbUser);
	}

	@Override
	public int UpdateProfileService(FbUser fbUser) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		return fbDAO.UpdateProfileDAO(fbUser);
	}

	@Override
	public FbUser detailProfileService(FbUser fbUser) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		return fbDAO.detailProfileDAO(fbUser);
	}

	@Override
	public int createPostService(FbTimeline fbt) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		return fbDAO.createPostDAO(fbt);
	}

	@Override
	public List<FbTimeline> TimelineService(FbTimeline fbt) {
		FbDAOInterface fbDAO=DAOFactory.createObj();
		return fbDAO.TimelineDAO(fbt);
	}

	

}
