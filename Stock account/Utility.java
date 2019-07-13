package com.bridgelab.oops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Utility {

	public static void stockAccount() throws InterruptedException 
	{
		Scanner s=new Scanner(System.in);
		 Random rand = new Random();
		 try {
			 System.out.println("Enter your username:");
			 String UN=s.nextLine();
	         File file = new File("/home/admin1/eclipse-workspace/Stock Details/"+UN+".txt");
	         
	         if(file.createNewFile())
	         {
	        	 FileWriter fr = new FileWriter(file, true);
	        	 fr.write("User Name:"+UN+"\n");
	        	 
	        	 System.out.println("Enter Company name:");
				 String UN1=s.nextLine();
				  fr.write("Company Name:"+UN1+"\n");
				 System.out.println();
				 
				 fr.write("Your Account no is:"+rand.nextInt(1000)+"\n");
	        	 fr.close();
	        	 Thread.sleep(2000);
	        	 System.out.println("Account is Created!!!!!!!");
	         }
	         else System.out.println ("Error, file already exists.");
	      }
	      catch(IOException ioe) {
	         ioe.printStackTrace();
	      }	
		 
	}

	public static void stockBalance() throws IOException 
	{
		Scanner s=new Scanner(System.in);
		Random rand = new Random();
		int d=rand.nextInt(10000000);
		
		System.out.println("Enter your username:");
		 String UN1=s.nextLine();
		 File file = new File("/home/admin1/eclipse-workspace/Stock Details/"+UN1+".txt");
    	 FileWriter fr = new FileWriter(file, true);
    	 fr.write("Stock Balance : "+d+"\n");
    	 fr.write("\n");
   
    	 fr.close();
    	 System.out.println("Your stock balance is:"+d);		 
	}

	public static void BuyShares() throws IOException
	{
		Scanner s=new Scanner(System.in);
		Random rand = new Random();
		int d=rand.nextInt(10);
		System.out.println("Enter your username:");
		 String UN1=s.nextLine();
		 File file = new File("/home/admin1/eclipse-workspace/Stock Details/"+UN1+".txt");
		 FileWriter fr = new FileWriter(file, true);
   	
		System.out.println("Enter which shares you want to buy");
		while(d>0)
		{
		 String UN2=s.nextLine();	
		 fr.write("Share :"+UN2+"\n");
		 d--;
		}
		fr.write("\n");
		fr.close();
		System.out.println("Shares are added............");
		System.out.println("file saved....");
		
	}

	public static void SellShares() throws IOException
	{
		Scanner s=new Scanner(System.in);
		Random rand = new Random();
		int d=rand.nextInt(10);
		System.out.println("Enter your username:");
		 String UN1=s.nextLine();
		 System.out.println("Enter which shares you want to sell");
		 File file = new File("/home/admin1/eclipse-workspace/Stock Details/"+UN1+".txt");
		 FileWriter fr = new FileWriter(file, true);	
		while(d>0)
		{
		 String UN=s.nextLine(); 
    	 fr.write("Share sold:"+UN+"\n");
		 d--;
		}	
		System.out.println("file saved....");
		fr.write("\n");
		fr.close();
	}

	public static void Report() throws FileNotFoundException 
	{
		Scanner s=new Scanner(System.in);
		 System.out.println("Enter User Name"); 
		 String UN1=s.nextLine();
		File file = new File("/home/admin1/eclipse-workspace/Stock Details/"+UN1+".txt"); 
	    Scanner sc = new Scanner(file); 
	  
	    // we just need to use \\Z as delimiter 
	    sc.useDelimiter("\\Z"); 
	  
	    System.out.println(sc.next()); 
		
	}

}
