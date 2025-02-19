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
import java.util.Iterator;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.PrintWriter;
import java.util.Scanner;
/**This board class represents the game board that the player uses to play the game. Its filled with methods and variables that come together
 * to make a functioning text based board for the player to be able to play the game
 */
public class Board {   
    /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
    // Attributes
    /**An array lists of Deck's to store the different stacks*/
    public ArrayList<Deck> playingStacks;
    /**A large deck that stores all the cards that are supposed to make up the Draw Pile*/
    public Deck drawPile;
    /**A variable to store the number of stack we will be dealing with*/
    private int numStacks;

    public Board() {}

    /**
     *  Sets up the Board and fills the stacks and draw pile from a Deck
     *  consisting of numDecks Decks.  Here are examples:
     *  
     *  # numDecks     #cards in overall Deck
     *      1          13 (all same suit)
     *      2          26 (all same suit)
     *      3          39 (all same suit)
     *      4          52 (all same suit)
     *      
     *  Once the overall Deck is built, it is shuffled and half the cards
     *  are placed as evenly as possible into the stacks.  The other half
     *  of the cards remain in the draw pile.
     *  @param numStacks Number of stacks to place cards within while playing
     *  @param numDecks Number of decks of 13 cars each(Ace-King) do be played with
     */    
    public Board(int numStacks, int numDecks) {
        this.numStacks=numStacks;
        Deck globalDeck = new Deck(numDecks * 13);

        playingStacks = new ArrayList<Deck>(numStacks);
        for (int i = 1; i <= numDecks; i++) {
            for (int j = 1; j <= 10; j++) {
                Card localNumberedCard = new Card("" + j, j);
                //localNumberedCard.setFaceUp(true);
                globalDeck.addCard(localNumberedCard); // Add numbered cards
            }
            Card localJack = new Card("J", 11);
            //localJack.setFaceUp(true);

            Card localQueen = new Card("Q", 12);
            //localQueen.setFaceUp(true);

            Card localKing = new Card("K", 13);
            //localKing.setFaceUp(true);

            globalDeck.addCard(localJack); 
            globalDeck.addCard(localQueen); 
            globalDeck.addCard(localKing); 
        }

        globalDeck.shuffle();

        //System.out.println(globalDeck.toString());

        Deck dealingCard = new Deck(globalDeck.deckSize() / 2);
        int halfDeckSize = globalDeck.deckSize() / 2;
        for (int i = 0; i < halfDeckSize; i++) {
            dealingCard.addCard(globalDeck.removeCard(0));
        }

        //System.out.println(dealingCard);

        for (int i=0;i<=numStacks-1;i++){
            playingStacks.add(new Deck(0));
        }

        int currentStack=0;
        int currentDealingCard = 0;
        while (currentDealingCard < dealingCard.deckSize()) {
            if (currentStack >= numStacks) {
                currentStack = 0; 
            }

            playingStacks.get(currentStack).addCard(dealingCard.get(currentDealingCard));
            currentStack++; 
            currentDealingCard++; 
        }
        for (int i=0 ;i<=playingStacks.size()-1;i++){
            playingStacks.get(i).get(playingStacks.get(i).deckSize()-1).setFaceUp(true);
        }

        drawPile = new Deck(0);
        for (int i = globalDeck.deckSize()-dealingCard.deckSize(); i<= globalDeck.deckSize()-1; i++){
            //globalDeck.get(i).setFaceUp(true);
            drawPile.addCard(globalDeck.get(i));
        }

        //Previously tried code:
        /*int numInitialCard = dealingCard.deckSize();
        int fullPasses = numInitialCard / numStacks;
        int remainingPasses = numInitialCard % numStacks;

        // Full passes
        for (int i = 1; i <= fullPasses; i++) {
        Iterator<Deck> playingStacksIterator = playingStacks.iterator(); // Reset iterator
        while (playingStacksIterator.hasNext() && dealingCard.deckSize() > 0) {
        playingStacksIterator.next().addCard(dealingCard.removeCard(0));
        }
        }

        // Remaining passes
        Iterator<Deck> remainingStacksIterator = playingStacks.iterator(); // New iterator
        Iterator<Card> dealingCardIterator = dealingCard.getDeckArrayList().iterator();
        while (remainingStacksIterator.hasNext() && dealingCardIterator.hasNext()) {
        remainingStacksIterator.next().addCard(dealingCardIterator.next());
        dealingCardIterator.remove();
        }

        drawPile = new Deck(globalDeck.deckSize());
        while (globalDeck.deckSize() > 0) {
        drawPile.addCard(globalDeck.removeCard(0));
        }*/
    }

    /**
     *  Moves a run of cards from src to dest (if possible) and flips the
     *  next card if one is available.
     *  @param symbol The symbol of the the card at the end of run that you are trying to move
     *  @param src The stack number of where you are trying to move this run from
     *  @param dest The stack number of where you are trying to move this run to
     */
    public void makeMove(String symbol, int src, int dest) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        if (src>playingStacks.size() || dest>playingStacks.size()){
            System.out.println("Error: Either one or both of the stacks given is out of bounds and does not exists!\n");
            return;
        }
        Deck currentDeck = playingStacks.get(src-1);
        int symbolIndex = -1;
        for (int i=currentDeck.deckSize()-1 ; i>=0  ; i--){
            if (currentDeck.get(i).getSymbol().equals(symbol)){
                symbolIndex=i;
                break;
            }
        }
        if (symbolIndex==-1){
            System.out.println("Error: "+symbol+" not found in the stack "+src);
            return;
        }

        boolean isValidSequence = true;
        if (symbolIndex < currentDeck.deckSize() - 1) {
            for (int i = symbolIndex; i < currentDeck.deckSize() - 1; i++) {
                int currentValue = currentDeck.get(i).getValue();
                int nextValue = currentDeck.get(i + 1).getValue();

                if (currentValue - 1 != nextValue) {
                    isValidSequence = false;
                    break;
                }
            }
        }

        if (!isValidSequence) {
            System.out.println(symbolIndex);
            System.out.println(currentDeck.deckSize() - 1);
            System.out.println("Error: The " + symbol + " trying to get moved does not have a consecutive and descending run in the stack specified");
            return;
        }

        Deck movingDeck = new Deck(currentDeck.deckSize()-symbolIndex);
        for (int i = symbolIndex ; i<=currentDeck.deckSize()-1; i++){
            movingDeck.addCard(currentDeck.get(i));
        }
        for (int i =0 ; i<=movingDeck.deckSize()-1;i++){
            if (movingDeck.get(i).isFaceUp()==false){
                System.out.println("Error: "+symbol+" not found in the stack "+src);
                return;
            }
        }
        if (playingStacks.get(dest-1).deckSize()!=0){
            if (playingStacks.get(dest-1).get(playingStacks.get(dest-1).deckSize()-1).transalateValue()!=movingDeck.get(0).transalateValue()+1){
                System.out.println("You cannot make this move because the last card in the destination stack is not allowable");
                return;
            }
        }
        int myNum = movingDeck.deckSize();
        for (int i=1;i<=currentDeck.deckSize()-symbolIndex ; i++){
            playingStacks.get(dest-1).addCard(movingDeck.removeCard(0));
        }

        for (int i = 0; i < myNum; i++) {
            playingStacks.get(src - 1).removeCard(playingStacks.get(src - 1).deckSize() - 1);
        }
        if (symbolIndex!=0){
            playingStacks.get(src-1).get(symbolIndex-1).setFaceUp(true);
        }

    }

    /** 
     *  Moves one card onto each stack, or as many as are available
     */
    public void drawCards() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        if (drawPile.deckSize()==0){
            System.out.println("Cannot draw cards because draw pile is empty!\n");
            return;
        }
        for (int i=0;i<=playingStacks.size()-1;i++){
            if (playingStacks.get(i).deckSize()==0){
                System.out.println("Cannot draw cards because one of the stacks is empty!\n");
                return;
            }
        }

        int currentStack=0;
        int currentDrawingCard=0;

        //if the drawPile does not have enough cards to put into each stack
        if (numStacks>drawPile.deckSize()){
            for (int i=0;i<=drawPile.deckSize()-1;i++){
                drawPile.get(currentDrawingCard).setFaceUp(true);
                playingStacks.get(currentStack).addCard(drawPile.get(currentDrawingCard));

                currentStack++;
                currentDrawingCard++;

            }
            //After adding (to avoid conflict of skipping cards) removing the added cards from the drawPile

            for (int i=0;i<=drawPile.deckSize()-1;i++){
                drawPile.removeCard(0);

            }

            drawPile.blow();
        }
        //drawPile has eqaul or more cards to put into each stack
        else {
            for (int i=0;i<=playingStacks.size()-1;i++){
                drawPile.get(currentDrawingCard).setFaceUp(true);
                playingStacks.get(currentStack).addCard(drawPile.get(currentDrawingCard));

                currentStack++;
                currentDrawingCard++;
            }

            for (int i=0;i<=playingStacks.size()-1;i++){
                drawPile.removeCard(0);

            }
        }
    }

    /**
     *  Returns true if all stacks and the draw pile are all empty
     *  @return The boolean value for whether the whole board is empty or not
     */ 
    public boolean isEmpty() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        if (drawPile.deckSize()!=0){
            return false;
        }
        for (int i=0;i<=playingStacks.size()-1;i++){
            if (playingStacks.get(i).deckSize()!=0){
                return false;
            }
        }
        return true;

    }

    /**
     *  If there is a run of A through K starting at the end of sourceStack
     *  then the run is removed from the game or placed into a completed
     *  stacks area.
     *  
     *  If there is not a run of A through K starting at the end of sourceStack
     *  then an invalid move message is displayed and the Board is not changed.
     *  @param sourceStack The stack number that you want to clear
     */
    public void clear(int sourceStack) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        if (sourceStack>playingStacks.size()){
            System.out.println("Error: Stack given it out of bounds and does not exists!\n");
            return;
        }
        Deck currentStack = playingStacks.get(sourceStack-1);
        if(playingStacks.get(sourceStack-1).deckSize()<13){
            System.out.println("Error: The source stack given does not have enough card to clear!\n");
            return;
        }
        if (sourceStack-1>numStacks){
            System.out.println("Error: The source stack given does not exist!");
            return;
        }
        if (currentStack.get(currentStack.deckSize() - 1).getValue() == 1 && currentStack.get(currentStack.deckSize() - 1).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 2).getValue() == 2 && currentStack.get(currentStack.deckSize() - 2).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 3).getValue() == 3 && currentStack.get(currentStack.deckSize() - 3).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 4).getValue() == 4 && currentStack.get(currentStack.deckSize() - 4).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 5).getValue() == 5 && currentStack.get(currentStack.deckSize() - 5).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 6).getValue() == 6 && currentStack.get(currentStack.deckSize() - 6).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 7).getValue() == 7 && currentStack.get(currentStack.deckSize() - 7).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 8).getValue() == 8 && currentStack.get(currentStack.deckSize() - 8).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 9).getValue() == 9 && currentStack.get(currentStack.deckSize() - 9).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 10).getValue() == 10 && currentStack.get(currentStack.deckSize() - 10).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 11).getValue() == 11 && currentStack.get(currentStack.deckSize() - 11).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 12).getValue() == 12 && currentStack.get(currentStack.deckSize() - 12).isFaceUp() &&
        currentStack.get(currentStack.deckSize() - 13).getValue() == 13 && currentStack.get(currentStack.deckSize() - 13).isFaceUp()) {

            //Need to clear those cards
            for (int i = 0 ; i<=12; i++){
                playingStacks.get(sourceStack - 1).removeCard(playingStacks.get(sourceStack-1).deckSize()-1);
            }

            System.out.printf("%d was sucesfully cleared!\n",sourceStack);
        }
        else {
            System.out.println("Error: This source stacks does not contain a full stack of Ace-King Cards or the cards at not all faced up");
        }
    }

    /**
     * Prints the board to the terminal window by displaying the stacks, draw
     * pile, and done stacks (if you chose to have them)
     */
    public void printBoard() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
        System.out.printf("Stacks:\n");

        for (int i = 0 ; i <=playingStacks.size()-1; i++){

            System.out.printf((i+1)+": "+playingStacks.get(i).toString() + "\n");
        }

        System.out.printf("\nDraw Pile:\n"+drawPile.toString()+"\n\n");
    }

    @Override
    public String toString(){
        String myString = "";

        for (int i = 0 ; i <=playingStacks.size()-1; i++){
            myString+=(playingStacks.get(i).toString() + "\n");
        }

        myString+=(drawPile.toString());

        return myString;
    }

    /**This is a method that is used to generate a string that will be stored in the file. This string will be stored in such a way that it indicates to how many stacks, the cards in each stack, and how each card was flipped.
     * This is important so that we can properly resotre the Board as needed by processing this String that we formatted
     * @return The string that stores the formatted string which will be written to the file that the user saves the game into
     */
    public String specialToString(){

        String myString="";
        for (int i = 0 ; i <=playingStacks.size()-1; i++){
            myString+=(playingStacks.get(i).specialToString() + "\n");
        }

        myString+=(drawPile.specialToString());

        return myString;
    }

    /**The save method that will get called when the user selects the save option from the game menu. This writes the string that gets returned from the 
     * specialToString method into the file that user selects using the JFileChooser
     */
    public void save(){
        Deck currentDrawPile = this.drawPile;
        ArrayList<Deck> currentPlayingStacks = this.playingStacks;
        String myString = this.specialToString();
        // Create a JFileChooser that points to the current directory
        JFileChooser chooser = new JFileChooser(".");

        // Tell the JFileChooser to show a Save dialog window
        chooser.showSaveDialog(null);

        // Ask the JFileChooser for the File the user typed in or selected
        File tester = chooser.getSelectedFile();
        File apple;
        if (tester==null){
            return;
        }
        else {
            apple = tester;
        }

        PrintWriter writer = null;
        try{
            writer =  new PrintWriter(apple);
            //System.out.println("Writen to file");
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        /*for (int i = 0 ; i <=playingStacks.size()-1; i++){
        for (int j = 0; j<playingStacks.get(i).deckSize()-1; j++){
        playingStacks.get(i).get(j).setFaceUp(true);
        }
        }

        for (int i = 0; i<=drawPile.deckSize()-1 ; i++){
        drawPile.get(i).setFaceUp(true);
        }*/

        writer.write(myString);
        writer.close();

        /*for (int i = 0; i<=drawPile.deckSize()-1 ; i++){
        drawPile.get(i).setFaceUp(false);
        }
        for (int i = 0 ; i <=playingStacks.size()-1; i++){
        for (int j = 0; j<playingStacks.get(i).deckSize()-1; j++){
        playingStacks.get(i).get(j).setFaceUp(false);
        }
        }*/

        this.drawPile = currentDrawPile;
        this.playingStacks = currentPlayingStacks;
    }

    /**This is the restore method that gets called when the user chooses the load method from the game menu. The main function of this method
     * is to process the string in the chosen file and restore the board with the given information
     */
    public void restore(){
        // Create a JFileChooser that points to the current directory

        JFileChooser chooser = new JFileChooser(".");

        // Tell the JFileChooser to show a Save dialog window
        chooser.showOpenDialog(null);

        File tester = chooser.getSelectedFile();
        File apple;
        if (tester==null){
            System.out.println("Error: Need to choose a file a restore. Try again! \n");
            return;
        }
        else {
            apple = tester;
        }

        String fileName = apple.getName();
        int dotIndex = 0;
        for (int i=0 ;i<=fileName.length()-1;i++){
            if (fileName.charAt(i)=='.'){
                dotIndex = i;
            }
        }
        String extension = fileName.substring(dotIndex+1);
        if (!extension.equals("txt")){
            System.out.println("Please choose a valid file where you save your game");
            return;
        }

        Scanner sc = null;
        try{
            sc = new Scanner(apple);
        }
        catch( IOException bob){
            System.out.println("Error: "+bob.getMessage());
            return;
        }

        Board returnBoard = new Board();

        String myString= "";
        int numLines=0;
        try{
            while(sc.hasNextLine()){
                myString+=sc.nextLine();
                myString+="\n";
                numLines++;
            }
        }
        catch (NullPointerException bob){
            System.out.println("Error: Please provide a valid file!");
            return;
        }

        //Storing each line as a string
        ArrayList<String> stackStrings = new ArrayList<String> (1);
        Scanner lineReader = new Scanner(myString);
        for (int i=0;i<=numLines-1;i++){
            stackStrings.add(lineReader.nextLine());
        }
        //Removing the [ and ] for each line
        /*for (int i=0;i<=stackStrings.size()-1;i++){
        String currentStackString = stackStrings.get(i);
        stackStrings.set(i,currentStackString.substring(1,currentStackString.length()-1));
        }*/
        try{
            for (int i=0;i<=stackStrings.size()-2;i++){
                lineReader = new Scanner(stackStrings.get(i));

                Deck localDeck = new Deck(0);
                while(lineReader.hasNext()){
                    String currentRead = lineReader.next();
                    String up = lineReader.next();
                    int currentValue = 0;
                    if (currentRead.equals("K")){
                        currentValue = 13;
                    }
                    else if (currentRead.equals("Q")){
                        currentValue = 12;
                    }
                    else if (currentRead.equals("J")){
                        currentValue = 11;
                    }
                    else {
                        currentValue = Integer.parseInt(currentRead);
                    }
                    Card localCard = new Card(currentRead,currentValue);
                    if(up.equals("Y")){
                        localCard.setFaceUp(true);
                    }
                    else if (up.equals("N")){

                        localCard.setFaceUp(false);

                    }
                    localDeck.addCard(localCard);
                }
                playingStacks.set(i,localDeck);
            }
        }
        catch (Exception bob){
            System.out.println("Please enter a valid file where you saved your game");
        }
        //Populating the remaining drawPile

        
        try{
            drawPile.blow(); 
            if (!stackStrings.isEmpty()) {
                String lastLine = stackStrings.get(stackStrings.size() - 1); 
                Scanner drawPileReader = new Scanner(lastLine); 

                while (drawPileReader.hasNext()) {
                    String currentRead = drawPileReader.next();
                    drawPileReader.next();
                    int currentValue = 0;

                    if (currentRead.equals("K")) {
                        currentValue = 13;
                    } else if (currentRead.equals("Q")) {
                        currentValue = 12;
                    } else if (currentRead.equals("J")) {
                        currentValue = 11;
                    } else {
                        currentValue = Integer.parseInt(currentRead);
                    }

                    // Create and add card to drawPile
                    Card localCard = new Card(currentRead, currentValue);
                    drawPile.addCard(localCard);
                }

            }
        }
        catch (Exception bob){
            System.out.println("Please enter a valid file where you saved your game");
        }

        //Flipping the appropriate cards
    }
}