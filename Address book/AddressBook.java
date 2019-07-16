package com.bridgelab.oops;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AddressBook
{
    public static void main(String[] args) throws IOException 
    {
    	Scanner s=new Scanner(System.in);
        JSONObject obj = new JSONObject();
        
        JSONArray list = new JSONArray();
        
        char ch;
		System.out.println("Welcome to the Address Book:");
		do
		{
			System.out.println("What you want to do?");
			System.out.print(" 1.Add A/C\n 2.Update\n 3.Delete\n 4.Sort by name\n 5.exit\n");
			int input=s.nextInt();
			switch(input)
			{
				case 1:
					Add(obj);
					break;
				case 2:
					Update(obj);
					break;
				case 3:
					Delete(obj);
					break;
				case 4:
					Sortbyname(obj);
					break;
				case 5:
					System.exit(0);
					break;
			}	
					System.out.println("Do you want to perform more operations?");
					ch=s.next().charAt(0);					
		}while(ch=='y'|| ch=='Y');
		


    }

	private static void Add(JSONObject obj)
	{
		Scanner s=new Scanner(System.in);
		 System.out.println("Enter file name");
	        String name=s.nextLine();
		System.out.println("Enter name");
        obj.put("name", s.nextLine());
        System.out.println("Enter address");
        obj.put("addr", s.nextLine());
        System.out.println("Enter phoneno");
        obj.put("phone", s.nextLine());
       
        try (FileWriter file = new FileWriter("/home/admin1/eclipse-workspace/Address Book/"+name+".json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Your deatails are successfully added.....");
        System.out.print(obj);
	}

	private static void Update(JSONObject obj)
	{
		Scanner s=new Scanner(System.in);
		 System.out.println("Enter file name");
	        String name=s.nextLine();
		System.out.println("Enter name");
        obj.put("name", s.nextLine());
        System.out.println("Enter address");
        obj.put("addr", s.nextLine());
        System.out.println("Enter phoneno");
        obj.put("phone", s.nextLine());
       
        try (FileWriter file = new FileWriter("/home/admin1/eclipse-workspace/Address Book/"+name+".json")) {        
        	file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Your deatails are successfully updated.....");
        System.out.print(obj);
	}

	private static void Delete(JSONObject obj) throws IOException
	{
		Scanner s=new Scanner(System.in);
		 System.out.println("Enter file name");
	        String name=s.nextLine();
		PrintWriter writer = new PrintWriter("/home/admin1/eclipse-workspace/Address Book/"+name+".json");
		writer.print("");
		// other operations
		writer.close();	
		System.out.println("Your deatails are successfully deleted.....");
		}

	private static void Sortbyname(JSONObject obj)
	{
		 File dir = new File("/home/admin1/eclipse-workspace/Address Book");

	      File[] files = dir.listFiles();

	      Arrays.sort(files, (f1, f2) -> f1.compareTo(f2));

	      for (File file : files) {
	         if (!file.isHidden()) {
	            if (file.isDirectory()) {
	               System.out.println("DIR \t" + file.getName());
	            } else {
	               System.out.println("FILE\t" + file.getName());
	            }
	         }
	      }
	}
}