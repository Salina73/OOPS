package com.bridgelab.oops;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InventoryManager 
{
	public static void main(String[]args)
	{
		Scanner s=new Scanner(System.in);
		JSONParser jsonParser = new JSONParser();
		JSONObject obj=new JSONObject();
		JSONArray sample=new JSONArray();
		try 
        {
            //Read JSON file
            obj = (JSONObject)jsonParser.parse(new FileReader("/home/admin1/eclipse-workspace/OOPs/src/inventory.json"));
            System.out.println(); 
            System.out.println("Inventory Mnagement System");
            System.out.println(); 
            System.out.println("Here is the list of all inventory:"); 
            System.out.println("Rice"); 
            System.out.println("Pulses"); 
            System.out.println("Wheat"); 
            System.out.println(); 
            int n=1;
            long sum=0;
            while(n<4)
            {
            	System.out.print("Enter inventory you want:"); 
            	String s1=s.nextLine();
            	 sample = (JSONArray) obj.get(s1);
                 sum=sum+calculate(sample);
                 System.out.println(); 
                 n++;
            } 
            System.out.println("Type y for total else type n"); 
            char c=s.next().charAt(0);;
            if(c=='y')
            {
            	System.out.print("Total is: "+sum); 
            }
            else
            	System.out.println("Thank You !!!!!!"); 
        }	
	 catch (Exception e) {
        e.printStackTrace();
	 } 
	}

	private static long calculate(JSONArray sample)
	{	
		Iterator<?> i=sample.iterator();
		long w=0;
		while(i.hasNext())
		{
			 JSONObject obj = (JSONObject)i.next();			 
			 String w1=(String)obj.get("Name");
			 System.out.print(w1+":"); 
			 w=(long)obj.get("Weight")*(long)obj.get("Price");
			 System.out.print(w+" having weight "+((long)obj.get("Weight"))+" and price "+((long)obj.get("Price"))+"(per kg)"); 
			 System.out.println(); 
		}
		return w;

		
	}
}