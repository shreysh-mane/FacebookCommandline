package com.facebook.Utility;

import com.facebook.Service.FbService;
import com.facebook.Service.FbServiceInterface;

public class ServiceFactory {
	private ServiceFactory() {}
	private static FbServiceInterface fbS;
	public static FbServiceInterface createObj() {
		if(fbS==null) {
			fbS=new FbService();
		}
		return fbS;
	}

}
