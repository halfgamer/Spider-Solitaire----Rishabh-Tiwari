/*
Name:       Rishabh Tiwari
Date:       14 December 2024
Period:     4

Is this lab fully working?  Yes

Homework problem: Make a class called dice, which has the instance variable of the number of sides that the dice has. Add a roll method 
that returns a random value that is possible when the dice is rolled. Also add a overriden toString() method that prints out instnace variable(s)
of the Dice object in a properly fotmatted way. 

 */
public class Driver
{
    public static void main(String[] args) {
        new SpiderSolitaire().play();
        
        /*System.out.println("\n++++++++++++++++++++++++++++++++++++ Start of Test cases for isEmpty() method++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
        
        //Activtiy 5 Test cases:

        //Test Case 1: The stacks and draw pile have cards
        System.out.println("Test Case1:");
        Board b1 = new Board(5,2);
        //Output: false (Sucesfully)
        System.out.println("\n"+b1.isEmpty());

        b1.printBoard();

         
        //Made the playStacks and drawPile in the Board class to public for now to remove and test cards as required

        System.out.println();
        System.out.println();

        System.out.println("Test Case2:");
        //TestCase2: Some stacks have cards and the draw pile is empty
        //Removing all the cards from one of the playingStacks
        b1.playingStacks.get(1).blow();
        //Removing all the cards in the drawPile
        b1.drawPile.blow();

        b1.printBoard();
        System.out.println("\n"+b1.isEmpty());
        //Output: false (Sucesfully)

        System.out.println();
        System.out.println();

        //TestCase3: The stacks are empty but the draw pile has at least one card
        System.out.println("Test Case3:");
        //reviving the b1 board
        b1 = new Board(5,2);
        //clearing all the stacks
        for (int i = 0; i<=b1.playingStacks.size()-1;i++){
            b1.playingStacks.get(i).blow();
        }

        b1.printBoard();
        System.out.println("\n"+b1.isEmpty());
        //Output: false (Sucesfully)

        System.out.println();
        System.out.println();

        //Test case 4: The stakcs and drawPile are both empty
        //clearing the drawPile
        System.out.println("Test Case4:");
        b1.drawPile.blow();

        b1.printBoard();
        System.out.println("\n"+b1.isEmpty());
        //Output: true (Sucesfully)

        System.out.println("\n++++++++++++++++++++++++++++++++++++ End of Test cases for isEmpty() method++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
        System.out.println("\n++++++++++++++++++++++++++++++++++++ Start of Test cases for clear() method++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
        
        Board b2 = new Board (5,2);
        
        //Test case1: A stack with a complete run of A through K in the correct order and no extra cards.
        System.out.println("Test Case1:");
        Deck testCaseDeck = new Deck (13);
        Card localJack = new Card("J", 11);
        localJack.setFaceUp(true);

        Card localQueen = new Card("Q", 12);
        localQueen.setFaceUp(true);

        Card localKing = new Card("K", 13);
        localKing.setFaceUp(true);

        
        testCaseDeck.addCard(localKing);
        testCaseDeck.addCard(localQueen);
        testCaseDeck.addCard(localJack); 
         

        
        for (int j = 10; j >= 1; j--) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testCaseDeck.addCard(localNumberedCard); // Add numbered cards
        }
        
        
        b2.playingStacks.add(testCaseDeck);
        
        b2.printBoard();
        
        //Output: Sucesfully print the the message after clearing all the required cards
        b2.clear(6);
        
        System.out.println();

        //Output: Sucesfully prints the mepty 6th stack where all the cards were cleared
        b2.printBoard();
        
        System.out.println();     
        System.out.println();     
        
        System.out.println("Test Case2:");
        
        //Re populating the 6th stack with additional cars on top
        //Additional cards on top
        Card additionalCard = new Card("10",10);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        additionalCard = new Card("2",2);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        additionalCard = new Card("5",5);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        additionalCard = new Card("7",7);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        
        testCaseDeck.addCard(localKing);
        testCaseDeck.addCard(localQueen);
        testCaseDeck.addCard(localJack); 
         

        
        for (int j = 10; j >= 1; j--) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testCaseDeck.addCard(localNumberedCard); // Add numbered cards
        }
        
        
        b2.playingStacks.set(5,testCaseDeck);
        
        b2.printBoard();
        
        System.out.println("\nClearing the 6th stack now:");
        //Output: Sucesfull
        b2.clear(6);
        b2.printBoard();
        
        
        //Test Case3
        System.out.println("\nTest Case3:");
        b2.playingStacks.get(5).blow();
        
        testCaseDeck.addCard(localKing);
        testCaseDeck.addCard(localQueen);
        testCaseDeck.addCard(localJack); 
         

        
        for (int j = 10; j >= 1; j--) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testCaseDeck.addCard(localNumberedCard); // Add numbered cards
        }
        
        additionalCard = new Card("10",10);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        additionalCard = new Card("2",2);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        additionalCard = new Card("5",5);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        additionalCard = new Card("7",7);
        additionalCard.setFaceUp(true);
        testCaseDeck.addCard(additionalCard);
        
        b2.printBoard();
        
        //trying to clear the 6th stack
        //Output: reports an error (sucesfull);
        b2.clear(6);
        
        
        
        //Test case4
        System.out.println("\n\nTest Case4:");
        b2.playingStacks.get(5).blow();
        
        for (int j = 1; j <= 10; j++) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testCaseDeck.addCard(localNumberedCard); // Add numbered cards
        }
        testCaseDeck.addCard(localJack); 
        testCaseDeck.addCard(localQueen);
        testCaseDeck.addCard(localKing);
        
        b2.playingStacks.set(5,testCaseDeck);
        
        b2.printBoard();
        
        //Output: Prints error (Sucesfull)
        b2.clear(6);
        
        
        
        //Test case5
        System.out.println("\n\nTest Case5:");
        b2.playingStacks.get(5).blow();
        
        for (int j = 10; j >=1; j--) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testCaseDeck.addCard(localNumberedCard); // Add numbered cards
        }
        b2.playingStacks.set(5,testCaseDeck);
        
        b2.printBoard();
        
        //Output: Prints error (Sucesfull)
        b2.clear(6);
        
        
        
        //Test case6
        System.out.println("\n\nTest Case6:");
        b2.playingStacks.get(5).blow();
        
        
        testCaseDeck.addCard(localKing);
        testCaseDeck.addCard(localQueen);
        testCaseDeck.addCard(localJack); 
        for (int j = 10; j >=1; j--) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testCaseDeck.addCard(localNumberedCard); // Add numbered cards
        }
        b2.playingStacks.set(5,testCaseDeck);
        b2.playingStacks.get(5).get(0).setFaceUp(false);
        b2.playingStacks.get(5).get(1).setFaceUp(false);
        b2.playingStacks.get(5).get(2).setFaceUp(false);
        
        b2.printBoard();
        
        //Output: Prints error (Sucesfull)
        b2.clear(6);
        
        
        
        System.out.println("\n++++++++++++++++++++++++++++++++++++ End of Test cases for clear() method++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\nTesting the drawCard() and makeMove() method on my own:\n");
        
        
        b2 =new Board(5,2);
        
        testCaseDeck.blow();
        testCaseDeck.addCard(localKing);
        testCaseDeck.addCard(localQueen);
        testCaseDeck.addCard(localJack); 
        testCaseDeck.get(0).setFaceUp(false);
        testCaseDeck.get(1).setFaceUp(true);
        testCaseDeck.get(2).setFaceUp(true);
        
        b2.playingStacks.add(testCaseDeck);
        
        Deck testDeck2 = new Deck(10);
        for (int j = 10; j >=1; j--) {
            Card localNumberedCard = new Card("" + j, j);
            localNumberedCard.setFaceUp(true);
            testDeck2.addCard(localNumberedCard); // Add numbered cards
        }
        
        b2.playingStacks.add(testDeck2);
        
        b2.printBoard();
        
        b2.makeMove("K",6,7);
        b2.makeMove("10",7,6);
        System.out.println();
        b2.printBoard();
        b2.drawCards();*/
    }
}
