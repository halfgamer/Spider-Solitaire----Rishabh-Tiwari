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
import java.util.ArrayList;
import java.util.Random;
/**Represents a deck of multiple cards that are used throughout the game in one form or an another. In this game, a deck is difined as a stack of Card objects, no matter the size
 */
public class Deck
{
    /** Each <code>Deck</code> object comprises of an ArrayList that stores the list of <code>Card</code>s in it*/
    private ArrayList<Card> deck;

    /**
     * Creates a new <code>Deck</code> instance.
     *
     * @param numCard Number of cards you want the <code>Deck</code> to get initialized with 
     */   
    public Deck(int numCards){
        deck = new ArrayList<Card>(numCards);
    }

    /** This is the shuffle method that moves the cards in the currnet deck in a random order and modifies the <code>Deck</code> */
    public void shuffle(){
        Random r= new Random();
        for (int i = 0 ; i<= deck.size()-1 ; i++){
            int randomIndex= r.nextInt(deck.size());
            while(randomIndex == i){
                randomIndex= r.nextInt(deck.size());
                if (randomIndex==i){
                    //do nothing, keep looping
                }
                else {
                    //you can break
                    break;
                }
            }
            Card currentCard = deck.get(i);
            deck.set(i,deck.get(randomIndex) );
            deck.set(randomIndex, currentCard);
        }
    }

    /** Method for adding a <code>Card</code> at the end of a <code>Deck</code> 
     * @param o This is the card that you want to add at the end of the <code>Deck</code>
     */
    public void addCard(Card o){
        deck.add(o);
    }

    /** Method for adding a <code>Card</code> at a certain index of a <code>Deck</code> 
     * @param index This is the index that you want the passed in <code>Card</code> to get added on
     * @param o This is the card that you want to add at the certain index <code>Deck</code>
     */
    public void addCard(int index, Card o){
        deck.add(index,o);
    }

    /** Method for removing a <code>Card</code> at a certain index of a <code>Deck</code>
     * @param index This is the index at which you want the <code>Card</code> to be removed
     * @return Returns the <code>Card</code> object being removed from the <code>Deck</code>
     */
    public Card removeCard(int index){
        Card c = deck.get(index);
        deck.remove(index);
        return c;

    }

    /**This method draw the top(ending) card of the deck and returns the <code>Card</code> being drawn and removed
     * @return Returns the <code>Code</code> being drawn and removed from the <code>Deck</code>
     */
    public Card drawTopCard(){
        Card c = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return c;
    }

    /**Method that returns the size of the array list being used to store the card objects in the <code>Deck</code>
     * @return The size of the array list being used to store the card objects in the <code>Deck</code>
     */
    public int deckSize(){
        return deck.size();
    }

    /**Method that simply the returns a <code>Card</code> at a cetain index for the current <code>Deck</code>
     * @param index The index of which you want the <code>Card</code> returned
     * @return A card object the specified index
     */
    public Card get(int index){
        return deck.get(index);
    }

    /** Method that returns the ArrayList object the cards of the <code>Deck</code>
     * @return The ArrayList of Card object type that the <code>Deck</code> object uses for storing the <code>Card</code> object within
     */
    public ArrayList<Card> getDeckArrayList(){
        return deck;
    }

    /**A simple method that just clears the current deck of all it's cards*/
    public void blow(){
        deck.clear();
    }

    /**
     * Returns this <code>Deck</code> as a String. Each card is printed out with a "[" and a "] around it that contains it's symbol and value
     *
     * @return a <code>String</code> containing all the cards in the <code>Deck</code> represented by their symbol and values.
     */
    @Override
    public String toString() {
        String myString = "[";
        for (int i = 0 ; i<=deck.size()-2; i++){
            myString+=deck.get(i).toString()+", ";
        }
        if (deckSize()>0){
            
            myString+= deck.get(deck.size()-1).toString()+"]";
        }
        else {
            myString="[]";
        }
        return myString;
    }
    
    /**This is the special toString method for the deck. This get's called in the specialToString of the board class when the code is trying to
     * save a specially formatted string to write to the file that the user chooses to same his/her game on
     * @return The string representation of the deck, but in a way that given us information as to what each card war and wether it was faced up or down. This way, we can be 100% accurate while regenerating the Board
     */
    public String specialToString() {
        String myString = "";
        
        for (int i = 0 ; i<=deck.size()-1; i++){
            
            myString+=deck.get(i).getSymbol()+" ";
            if (deck.get(i).isFaceUp()==true){
                myString+="Y ";
            }
            else {
                 myString+="N ";
            }
            
        }
        
        
        return myString;
    }
}

