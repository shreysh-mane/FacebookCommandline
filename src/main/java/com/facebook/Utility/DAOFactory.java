package com.facebook.Utility;

import com.facebook.DAO.FbDAO;
import com.facebook.DAO.FbDAOInterface;

public class DAOFactory {
	private DAOFactory() {}
	
	private static FbDAOInterface fbDAO;
	public static FbDAOInterface createObj() {
		if(fbDAO==null) {
			fbDAO=new FbDAO();
		}
		
		return fbDAO;
	}

}
