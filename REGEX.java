package com.bridgelab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class REGEX
{
	 static String input=" Hello <<name>>, We have your full name as <<full name>> in our system.\n "
				+ "Your contact number is 91-xxxxxxxxxx.\n "
				+ "Please,let us know in case of any clarification.\n "
				+ "Thank you BridgeLabz 01/01/2016.\n";
	public static void main(String[]args)
	{
		Scanner s=new Scanner(System.in);		
		
		System.out.println("Enter your First name:");
		Expression("<<name>>",s.nextLine());
		
		System.out.println("Enter your Full name:");
		Expression("<<full name>>",s.nextLine());
		
		System.out.println("Enter your contact:");
		Expression("91-xxxxxxxxxx",s.nextLine());
		
		System.out.println("Enter Date");
		Expression("01/01/2016",s.nextLine());
		
		System.out.println(input);
	
	}
//pattern matching
	private static void Expression(String s1, String s2) {
		Pattern p = Pattern.compile(s1);	
		Matcher m= p.matcher(input);	
		input= m.replaceFirst(s2);
	}
}
