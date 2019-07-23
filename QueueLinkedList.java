package com.bridgelab.oops;
import java.util.*;

public class QueueLinkedList 
{
	public static Node front, rear;
	public static int size;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			front=null;
			rear=null;
			size=0;
			next=null;
		}		
	}
	private boolean isEmpty()
	{
		return(size==0);		
	}
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		char ans;
		QueueLinkedList q=new QueueLinkedList(); 
		System.out.println("Welcome to Market.....");
		System.out.println();
		System.out.println("***** Transaction Maintenance *****");		
		do 
		{
			System.out.println();
			System.out.println("What you want to do?");
			System.out.println("1.Buy symbol\n2.Display Date and Time ");
			int n=s.nextInt();
			System.out.println();
			switch(n)
			{
			case 1:
				System.out.println("Enter Symbol");
				int d=s.nextInt();
				q.insert(d);
				break;
			case 2:
				System.out.println();
				q.display();
				break;
			}
			System.out.println("more operations?");
			ans=s.next().charAt(0);
		}while(ans=='Y'||ans=='y');
	}

	private void insert(int data) 
	{
		 Node oldRear = rear;
		 rear = new Node(data);
		 rear.data = data;
		 rear.next = null;
		 if (isEmpty()) 
		 {
		 front = rear;
		 }
		 else 
		 {
		 oldRear.next = rear;
		 }
		 size++;
	 }	

	private void display()
	{
	        System.out.print("\nQueue = ");
	        if (size == 0)
	        {
	        	System.out.print("No transaction happened today\n");
	        	return ;
	        }
	        Node ptr = front;
	        while (ptr != rear.next)
	        {
	            System.out.print(ptr.data+" ");
	            ptr = ptr.next;
	        }
	        System.out.println();        
	  }		
}
	
	

