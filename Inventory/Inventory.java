package com.bridgelab.oops;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Inventory 
{
	public static void main(String[]args)
	{

		JSONParser jsonParser = new JSONParser();
		JSONObject obj=new JSONObject();
		JSONArray sample=new JSONArray();
		try 
        {
            //Read JSON file
            obj = (JSONObject)jsonParser.parse(new FileReader("/home/admin1/eclipse-workspace/OOPs/src/inventory.json"));
            sample = (JSONArray) obj.get("Rice");
            calculate(sample);
            System.out.println();  
            
            sample = (JSONArray) obj.get("Pulses");
            calculate(sample);
            System.out.println();  
            
            sample = (JSONArray) obj.get("Wheat");
            calculate(sample);
            System.out.println();  
            
        }	
	 catch (Exception e) {
        e.printStackTrace();
	 } 
	}

	private static void calculate(JSONArray sample)
	{	
		Iterator<?> i=sample.iterator();
		while(i.hasNext())
		{
			 JSONObject obj = (JSONObject)i.next();			 
			 String w1=(String)obj.get("Name");
			 System.out.print(w1+":"); 
			 long w=(long)obj.get("Weight")*(long)obj.get("Price");
			 System.out.print(w); 
		}

		
	}
}