package com.bridgelab;
import java.util.Random; 
public class DeckOfCards {
    public static void main(String[] args)
    {       
        String[] suits = { "Club", "Diamond", "Heart", "Spades" };

        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace" };
        
        
        // initializing of deck   
        int n = (suits.length) * (ranks.length);
        String[] deck = new String[n];
        
        for (int i = 0; i < ranks.length; i++) 
        {
            for (int j = 0; j < suits.length; j++)
            {
                deck[suits.length*i + j] = ranks[i] + " of " + suits[j];
            }
        }
        
        shuffle(deck,n);
       }
    
        // shuffling of deck
         private static void shuffle(String[] deck, int n)
         {
        	 Random rand = new Random(); 
        	 for(int i = 0; i < n; i++)
             {
             	 int r = i + rand.nextInt(n - i); 
                 String temp = deck[r];
                 deck[r] = deck[i];
                 deck[i] = temp;
             }
        	 int start=0,end=8,stop=1;
        	 distribute(deck,n,start,end,stop);
	}

         //distributing of cards

        private static void distribute(String[] deck, int n, int start, int end,int stop) 
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
    		distribute(deck,n,start,end,stop);
    		}
		}
        
    }

