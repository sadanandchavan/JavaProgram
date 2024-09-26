package com.sada;

public class SingletonTest {

	public static void main(String[] args) {
		
		//SingloneTone st = new SingloneTone();
		SingloneTone st = SingloneTone.getInstaince();
		System.out.println("1"+st.hashCode());
		
		SingloneTone st2 = SingloneTone.getInstaince();
		System.out.println("2"+st2.hashCode());
		
		
		SingloneTone st3 = SingloneTone.getInstaince();
		System.out.println("3"+st3.hashCode());
		
		
		
		SingloneTone st4 = SingloneTone.getInstaince();
		System.out.println("4"+st4.hashCode());
	}

}
