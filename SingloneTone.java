package com.sada;

public class SingloneTone {

	private static SingloneTone singloneTone=null;

	public static synchronized SingloneTone getInstaince() {

		if(singloneTone==null) {
			singloneTone =new SingloneTone();
			return  singloneTone;
		}
		return singloneTone;
	}

	private SingloneTone(){
		System.out.println("Only one object will be created ");
	}
}

