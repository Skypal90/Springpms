package com.artek;

import java.util.ArrayList;
import java.util.List;

public class A{
	
	public static void main(String ...s) {
		
		String str[] = {"a","b","c"};
		
		str[2] = "mahendra";
		for(String s1: str) {
			System.out.println(s1);
		}
			
			List<Double> list=new ArrayList<Double>();
			list.add(1.0);
			list.add(2.5);
			list.add(3.5);
			list.add(1.4);
				double sum=0.0;
				for(Double D:list)
				{
					sum=sum+D;
				}
				System.out.println(sum);
	}	
		
	}
