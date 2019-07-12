package com.bridgelab.oops;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockPortfolio 
{
	public static void main(String[]args)
	{

		JSONParser jsonParser = new JSONParser();
		JSONObject obj=new JSONObject();
		JSONArray sample=new JSONArray();
		try 
        {
            //Read JSON file
			long sum=0;
            obj = (JSONObject)jsonParser.parse(new FileReader("/home/admin1/eclipse-workspace/OOPs/src/Stock.json"));
            System.out.println(); 
            System.out.println(); 
            System.out.println("<--------------------Stock Portfolio-------------------->"); 
            System.out.println(); 
            System.out.println(); 
            System.out.println("Stock Name      Quantity    Price(of Each)     Total"); 
            System.out.println("-------------------------------------------------------");
            sample = (JSONArray) obj.get("ICIC Bank");
            sum=sum+calculate(sample);
            System.out.println();  
            
            sample = (JSONArray) obj.get("AXIS Bank");
            sum=sum+calculate(sample);
            System.out.println();  
            
            sample = (JSONArray) obj.get("HDFC Bank");
            sum=sum+calculate(sample);
            System.out.println();  
            
            sample = (JSONArray) obj.get("Reliance ");
            sum=sum+calculate(sample);
            System.out.println();  
            
            System.out.println("-------------------------------------------------------");
            System.out.println("Total Cost:                                      "+sum);
        }	
	 catch (Exception e) {
        e.printStackTrace();
	 } 
	}

	private static long calculate(JSONArray sample)
	{	
		Iterator<?> i=sample.iterator();
		long t=0;
		while(i.hasNext())
		{
			 JSONObject obj = (JSONObject)i.next();			 
			 String w1=(String)obj.get("Name");
			 System.out.print(w1+":  "); 
			 long w=(long)obj.get("No of Shares");
			 long p=(long)obj.get("Price of share");
			  t=w*p;
			 System.out.print("       "+w+"            "+p+"             "+t); 	
			
		}
		 return t;
		
	}
}