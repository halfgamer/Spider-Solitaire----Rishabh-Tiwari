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


/**
 * Card.java
 *
 *  represents a basic playing card.
 */
public class Card implements Comparable<Card>
{
    /** String value that holds the symbol of the card.
    Examples: "A", "Ace", "10", "Ten", "Wild", "Pikachu"
     */
    private String symbol;

    /** int value that holds the value this card is worth */
    private int value;

    /** boolean value that determines whether this card is face up or down */
    private boolean isFaceUp;

    /**
     * Creates a new <code>Card</code> instance.
     *
     * @param symbol  a <code>String</code> value representing the symbol of the card
     * @param value an <code>int</code> value containing the point value of the card
     */    
    public Card(String symbol, int value) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        this.symbol=symbol;
        this.value = value;
        
        this.isFaceUp = false;
    }

    /**
     * Getter method to access this <code>Card</code>'s symbol.
     * 
     * @return this <code>Card</code>'s symbol.
     */
    public String getSymbol() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        return this.symbol;
    }

    /**
     * Getter method to access this <code>Card</code>'s value.
     * 
     * @return this <code>Card</code>'s value.
     */
    public int getValue() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        return this.value;
    }
    
    /**
     * Getter method to this <code>Card</code> is faced up or down .
     * 
     * @return true/false based on if the <code>Card</code> is faced up or down.
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    /**
     * Setter method to set whether the <code>Card</code> is faced up or down.
     * 
     * @param state Takes in the boolean value true/false if you want the card faced up/ down respectively 
     */
    public void setFaceUp(boolean state) {
        isFaceUp = state;
    }

    /**
     * Returns whether or not this <code>Card</code> is equal to another
     *  
     * @param other This is the <code>Card</code> card that you want to compare agains the current <code>Card</code>
     * @return whether or not this <code>Card</code> is equal in value to the <code>Card</code> passed in
     */
    public boolean equals(Card other) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        return this.value == other.getValue();
    }
    
    /**
     * Returns this card as a String.  If the card is face down, "X"
     * is returned.  Otherwise the symbol of the card is returned.
     *
     * @return a <code>String</code> containing the symbol or and X,
     * depending on whether the card is face up or down.
     */
    @Override
    public String toString() {
        if (isFaceUp){
            return this.symbol;
        }
        else {
            return "X";
        }
    }
    
    /** A method to translate this <code>Card</code>'s symbol into it's value
     * @reutrn An int value representing the <code>Card</code>'s value
     */
    public int transalateValue(){
        if (this.getSymbol()=="K"){
            return 13;
        }
        else if (this.getSymbol()=="Q"){
            return 12;
        }
        else if (this.getSymbol()=="J"){
            return 11;
        }
        else {
            return Integer.parseInt(this.getSymbol());
        }
    }
    
    /**A value that makes it convienant to just call and know the symbol of a certain card
       @return A String containing the symbol of the object
    */
    public String transalteSymbol(){
        if (this.getValue()==13){
            return "K";
        }
        else if (this.getValue()==12){
            return "Q";
        }
        else if (this.getValue()==11){
            return "J";
        }
        else {
            return ""+ this.getValue();
        }
    }
    
    /**
     * This the method is the implimentation of the  Comparable API that returns the difference in value between this Card and the Card being passed in as a parameter.
     * 
     * @param other This is the <code>Card</code> that the current <code>Card</code> will be diffrenciated against
     * @return The int different between the values of the current card and the card passed in.
     */
    public int compareTo(Card other){
        return this.value-other.getValue();
    }
}
