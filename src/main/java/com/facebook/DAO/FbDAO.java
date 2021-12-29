package com.facebook.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.facebook.Database.Database;
import com.facebook.Entiry.FbTimeline;
import com.facebook.Entiry.FbUser;
import com.facebook.Queries.Queries;

public class FbDAO implements FbDAOInterface {
	Connection con= null;
	ResultSet resultSet=null;
	PreparedStatement ps = null;

	public int createProfileDAO(FbUser fbu) {
		int result=0;
		try {	
			con=Database.getConnection();
			ps=con.prepareStatement(Queries.fb_Insert);
			ps.setString(1, fbu.getfName());
			ps.setString(2, fbu.getlName());
			ps.setString(3, fbu.getEmail());
			ps.setString(4, fbu.getPassword());
			result=ps.executeUpdate();
			con.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return result;
	}
	
	@Override
	public int LogInDAO(FbUser fbu) {
		int i=0;
		try {
			con=Database.getConnection();
			ps=con.prepareStatement(Queries.fb_getPassword);
			ps.setString(1, fbu.getEmail());
			resultSet = ps.executeQuery();

			while(resultSet.next()) {
				i=fbu.getPassword().equals(resultSet.getString(1))?1:2;
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return i;
	}
	
	@Override
	public List<FbUser> viewAllProfileDAO() {
		List<FbUser> fbuList=new ArrayList<FbUser>();
		try {
			con=Database.getConnection();
			PreparedStatement ps = con.prepareStatement(Queries.fb_getAllProfiles);

			resultSet = ps.executeQuery();
			if(resultSet.next()==false) {
				fbuList=null;
			}
			else {
				do{
					FbUser fbu=new FbUser();
					fbu.setfName(resultSet.getString(1));
					fbu.setlName(resultSet.getString(2));
					fbuList.add(fbu);
				}while (resultSet.next());
		
			}	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return fbuList;
	}


	@Override
	public FbUser searchProfileDAO(FbUser fbUser) {
		FbUser fbUserOb=new FbUser();
		try {
			con=Database.getConnection();
			ps=con.prepareStatement(Queries.fb_searchProfile);
			ps.setString(1,fbUser.getEmail());
			resultSet=ps.executeQuery();
			if(resultSet.next()) {
				fbUserOb.setfName(resultSet.getString(1));
				fbUserOb.setlName(resultSet.getString(2));
				fbUserOb.setEmail(resultSet.getString(3));
			}else {
				fbUserOb=null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return fbUserOb;
	}


	@Override
	public int deleteProfileDAO(FbUser fbUser) {
		int result=0;
		try{
			con=Database.getConnection();
			CallableStatement ps=con.prepareCall(Queries.fb_deleteProfile);
			ps.setString(1, fbUser.getEmail());
			result=ps.executeUpdate();
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		ps=null;
		return result;
	}

	@Override
	public int UpdateProfileDAO(FbUser fbUser) {
		int result=0;
		try{
			con=Database.getConnection();
			ps=con.prepareStatement(Queries.fb_updateProfile);
			ps.setString(1, fbUser.getfName());
			ps.setString(2, fbUser.getlName());
			ps.setString(3, fbUser.getEmail());
			result=ps.executeUpdate();
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		ps=null;
		return result;
	}

	@Override
	public FbUser detailProfileDAO(FbUser fbUser) {
		FbUser fbUserOb=new FbUser();
		try {
			con=Database.getConnection();
			ps=con.prepareStatement(Queries.fb_searchProfile);
			ps.setString(1,fbUser.getEmail());
			resultSet=ps.executeQuery();
			if(resultSet.next()) {
				fbUserOb.setfName(resultSet.getString(1));
				fbUserOb.setlName(resultSet.getString(2));	
			}else {
				fbUserOb=null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return fbUserOb;
	}

	@Override
	public int createPostDAO(FbTimeline fbt) {
		int result=0;
		try{
			con=Database.getConnection();
			ps=con.prepareStatement(Queries.fb_insertTimeline);
			ps.setString(1, fbt.getEmail());
			ps.setString(2, fbt.getMessage());
			ps.setString(3, fbt.getTime());
			result=ps.executeUpdate();
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		ps=null;
		return result;
	}

	@Override
	public List<FbTimeline> TimelineDAO(FbTimeline fbt) {
		List<FbTimeline> fbtList=new ArrayList<FbTimeline>();
		try {
			con=Database.getConnection();
			PreparedStatement ps = con.prepareStatement(Queries.fb_getTimeline);
			ps.setString(1, fbt.getEmail());
			resultSet = ps.executeQuery();
			
			if(resultSet.next()==false) {
				fbtList=null;
			}
			else {
				do{
					FbTimeline fbtr=new FbTimeline();
					fbtr.setMessage(resultSet.getString(1));
					fbtr.setTime(resultSet.getString(2));
					fbtList.add(fbtr);
				}while (resultSet.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return fbtList;
	}

	@Override
	public List<FbTimeline> seePostDAO(FbTimeline fbt) {
		List<FbTimeline> fbtList=new ArrayList<FbTimeline>();
		try {
			con=Database.getConnection();
			PreparedStatement ps = con.prepareStatement(Queries.fb_getPostTimeline);
			ps.setString(1, fbt.getEmail());
			resultSet = ps.executeQuery();
			
			if(resultSet.next()==false) {
				fbtList=null;
			}
			else {
				do{
					FbTimeline fbtr=new FbTimeline();
					fbtr.setMessage(resultSet.getString(1));
					fbtr.setEmail(resultSet.getString(2));
					fbtList.add(fbtr);
				}while (resultSet.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps=null;
		resultSet=null;
		return fbtList;
	}

	

}
