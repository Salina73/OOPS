package com.bridgelab.oops;

import java.io.IOException;
import java.util.Scanner;

public class CompanyShares 
{
	  Node head;
	  static class Node
	  {
		  String data;
		  Node next;
		  
		  Node(String d) 
		  {
			  data = d;
			  next=null;
		} 
	  }	   

	private static CompanyShares insert(CompanyShares list, String data) 
	{
		 Node new_node = new Node(data); 
	        new_node.next = null; 
	        
	        if (list.head == null)
	        { 
	            list.head = new_node; 
	        } 
	        else
	        {
	        	Node last=list.head;
	        	
	        while (last.next != null)
	        { 
             last = last.next; 
	        }
	        last.next=new_node;
	        }
	        return list;
	}
	
	private static CompanyShares remove(CompanyShares list, String key) 
	{
		Node currentNode=list.head,prev=null;
		 if (currentNode != null && key.compareTo(currentNode.data)==0)
		 { 
	            list.head = currentNode.next; 
	           
	            return list; 
	      }
		 while (currentNode != null && key.compareTo(currentNode.data)!=0) 
		 { 	
	            prev = currentNode; 
	            currentNode = currentNode.next; 
	      } 
		  if (currentNode != null)
		  {   
	            prev.next = currentNode.next; 
	            
	      } 
		return list;	
	}
	
	private static void printList(CompanyShares list) 
	{
		Node currentNode=list.head;
		System.out.println("LinkedList: "); 
		 while (currentNode != null) { 
	            System.out.print(currentNode.data + "\n");
	            currentNode = currentNode.next;       
	        } 
	}
	
	public static void main(String[] args) throws IOException 
	   {
			Scanner s=new Scanner(System.in);
		  char ans;
	      CompanyShares list = new CompanyShares();
			System.out.println();
			System.out.println("***** Share Manager *****");	
			do 
			{
				System.out.println();
				System.out.println("What you want to do?");
				System.out.println("1.Add Shares\n 2.Remove Shares\n ");
				int n=s.nextInt();
				System.out.println();
				switch(n)
				{
				case 1:	
					System.out.println("Enter share name");
					String n1=s.next();
					list = insert(list, n1);
					System.out.println("Share is  added......");
					System.out.println();
					break;
					
				case 2:
					System.out.println("Enter share name");
					list = remove(list, s.next());
					System.out.println("Share is  removed......");
					break;
					default:
						System.out.println("Enter valid choice please...");
				}
				System.out.println("Next (If next is not available enter n/N)");
				ans=s.next().charAt(0);
			}while(ans=='Y'||ans=='y');			
	      
	     printList(list);
	   }
}
	   
