package com.bridgelab.oops;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelab.oops.Utility;
public class StockAccount 
{
	public static void main(String[]args) throws InterruptedException, IOException
	{
		char ch;
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to stock market:");
		do
		{
			System.out.println("What you want to do?");
			System.out.print(" 1.Create A/C\n 2.Balance\n 3.Buy Shares\n 4.Sell Shares\n 5.Want report?\n");
			int input=s.nextInt();
			switch(input)
			{
				case 1:
					Utility.stockAccount();
					break;
				case 2:
					Utility.stockBalance();
					break;
				case 3:
					Utility.BuyShares();
					break;
				case 4:
					Utility.SellShares();
					break;
				case 5:
					Utility.Report();
					break;
			}	
					System.out.println("Do you want to perform more operations?");
					ch=s.next().charAt(0);					
		}while(ch=='y'|| ch=='Y');
		
	}

}
