package com.bridgelab.oops;
import java.util.Random; 
public class DeckOfCards 
{
	static Methods d=new Methods();
	
    public static void main(String[] args)
    {    
        String[] suits = { "Club", "Diamond", "Heart", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace" };
        
        DeckOfCard(suits,ranks);
    }  
   // initializing of deck   
    static void DeckOfCard(String[] s, String[] r)
    {
    	int n = (s.length) * (r.length);
        String[] deck = new String[n];
        
        for (int i = 0; i < r.length; i++) 
        {
            for (int j = 0; j < s.length; j++)
            {
                deck[s.length*i + j] = r[i] + " of " + s[j];
            }
        }
        d.DeckOfCard(deck,n);
    } 	
}
class Methods extends DeckOfCards
{      
	// shuffling of deck
    public void DeckOfCard(String[] deck, int n)
    {

        	Random rand = new Random(); 
        	 int i=0;
           	 for(String s:deck)
                {
           		 if(i<52) {
                	 int r = i + rand.nextInt(n - i); 
                    String temp = deck[r];
                    deck[r] = deck[i];
                    deck[i] = temp;
           		 }
           		 i++;
                }
       	 int start=0,end=8,stop=1;
         DeckOfCard(deck,n,start,end,stop);
       
		
	}
	
  //distributing of cards
     public void DeckOfCard(String[] deck, int n, int start, int end, int stop) 
     {
    	 start=end+1;
     	end=start+8;   
     	System.out.println("For player "+stop+" :");
 		for(int i = start; i <= end; i++)
         {
             System.out.println(deck[i]);
         }
 		System.out.println();
 		stop++;
 		if(stop<5)
 		{
 			 DeckOfCard(deck,n,start,end,stop);
 		}
}   
}
