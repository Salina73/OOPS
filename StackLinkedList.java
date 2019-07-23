package com.bridgelab.oops;
import static java.lang.System.exit;

import java.util.Scanner; 
class StackUsingLinkedlist 
{ 
	private class Node 
	{ 
		String data; 
		Node link;
	} 
	Node top; 
	StackUsingLinkedlist() 
	{ 
		this.top = null; 
	} 
	@SuppressWarnings("unused")
	public void push(String n1) 
	{ 
		Node temp = new Node(); 
		if (temp == null)
		{ 
			System.out.print("\nHeap Overflow"); 
			return; 
		} 
		temp.data = n1; 
		temp.link = top; 
		top = temp; 
	} 
	public boolean isEmpty() 
	{ 
		return top == null; 
	} 
	public String peek() 
	{ 
		if (!isEmpty()) { 
			return top.data; 
		} 
		else { 
			System.out.println("Stack is empty"); 
		}
		return null; 
	} 
	public void pop(String string) 
	{ 
		if (top == null) { 
			System.out.print("\nStack Underflow"); 
			return; 
		} 
		top = (top).link; 
	} 

	public void display() 
	{ 
		if (top == null) { 
			System.out.printf("\nStack Underflow"); 
			exit(1); 
		} 
		else { 
			Node temp = top; 
			while (temp != null) 
			{ 
				System.out.printf("%s ", temp.data); 
				temp = temp.link; 
			} 
		} 
		System.out.println();
	} 
} 

public class StackLinkedList { 
	public static void main(String[] args) 
	{ 
		StackUsingLinkedlist obj = new StackUsingLinkedlist(); 
		Scanner s=new Scanner(System.in);
		  char ans;
			System.out.println();
			System.out.println("***** Share(Symbol) Manager *****");	
			do 
			{
				System.out.println();
				System.out.println("What you want to do?");
				System.out.println(" 1.Buy Symbol\n 2.Sel Symbol\n 3.Display ");
				int n=s.nextInt();
				System.out.println();
				switch(n)
				{
				case 1:	
					System.out.println("Enter share name");
					String n1=s.next();
					obj.push(n1); 
					System.out.println("Symbol is  bought......");
					System.out.println();
					break;
					
				case 2:
					System.out.println("Enter share name");
					obj.pop(s.next()); 
					System.out.println("Symbol is sold......");
					break;
					
				case 3:
					System.out.println("Available symbols are:");
					obj.display(); 
					break;
					
					default:
						System.out.println("Enter valid choice please...");
				}
				System.out.println("Do you want to perform more operations?");
				ans=s.next().charAt(0);
			}while(ans=='Y'||ans=='y');			
	     

		System.out.printf("\nTop element is %d\n", obj.peek()); 
	} 
} 
