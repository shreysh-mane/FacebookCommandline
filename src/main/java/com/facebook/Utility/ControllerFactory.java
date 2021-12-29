package com.facebook.Utility;

import com.facebook.Controller.FBController;
import com.facebook.Controller.FbControllerInterface;

public class ControllerFactory {
	private ControllerFactory() {}
	private static FbControllerInterface fbC;
	
	public static FbControllerInterface createObj() {
		if(fbC==null) {
			fbC=new FBController();
		}
		return fbC;
	}
	
}
