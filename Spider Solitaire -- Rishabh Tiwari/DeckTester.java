/*
/*
Name:       Rishabh Tiwari
Date:       14 December 2024
Period:     4

Is this lab fully working?  Yes

Homework problem: Make a class called coin. Make it have some attributes like weight, type (nickel,dime, etc...) and which side is facing up
                  Add a flip method. That (on equal chance) flips the coin with an equal chance of heads or tails. Also add an attribute that
                  determines if the coin is in your pocjet or not. If that attribute is true(meaning the coin is in the pocket), display an
                  error method is anything else except the takeOutOfPocket() method is called.

 */

public class DeckTester
{
    public static void main(String[] args) {
        Deck myDeck = new Deck(13);
        
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        
        for (int i=0 ; i<=symbols.length-1; i++){
            myDeck.addCard(new Card(symbols[i], values[i]));
     }
     
     System.out.println(myDeck.toString());
     myDeck.shuffle();
     System.out.println();
     System.out.println(myDeck.toString());
     
     System.out.println();
     System.out.println();
     System.out.println();
     
     myDeck.addCard(new Card("Ace", 1));
     myDeck.addCard(myDeck.getDeckArrayList().size() - 1, new Card("Pokemon", 0));

     System.out.println(myDeck.toString());
     
     System.out.println();
     System.out.println();
     System.out.println();
     
     myDeck.removeCard(1);
     System.out.println(myDeck.toString());
     System.out.println("Size: "+myDeck.deckSize());
     System.out.println();
     System.out.println();
     System.out.println();
     
     

    }
}
