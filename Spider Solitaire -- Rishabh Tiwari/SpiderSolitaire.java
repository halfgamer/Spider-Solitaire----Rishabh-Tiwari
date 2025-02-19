
import java.util.Scanner;
import java.util.*;
/** This classes is where all the game pieces, i.e the cards, the decks, and the Board are put to gether to work in accoridance with the input that the user has to give to the program
 * 
 */
public class SpiderSolitaire
{
    /** Number of stacks on the board **/
    public final int NUM_STACKS = 7;

    /** Number of complete decks used in this game.  A 1-suit deck, which is the
     *  default for this lab, consists of 13 cards (Ace through King).
     */
    public final int NUM_DECKS = 4;

    /** A Board contains stacks and a draw pile **/
    private Board board;

    /** Used for keyboard input **/
    private Scanner input;
    
    /**Constructor that initlializes the board and the Scanner that we wil be using to interact with the user*/
    public SpiderSolitaire()
    {
        // Start a new game with NUM_STACKS stacks and NUM_DECKS of cards
        board = new Board(NUM_STACKS, NUM_DECKS);
        input = new Scanner(System.in);
    }

    /** Main game loop that plays games until user wins or quits **/
    public void play() {

        boolean gameOver = false;
        
        
        while(!gameOver) {
            board.printBoard();

            System.out.println("\nCommands:");
            System.out.println("   move [card] [source_stack] [destination_stack]");
            System.out.println("   draw");
            System.out.println("   clear [source_stack]");
            System.out.println("   restart");
            System.out.println("   save");
            System.out.println("   load");
            System.out.println("   quit");
            System.out.print(">");

            String command = input.next();

            if (command.equals("move")) {
                /* *** TO BE MODIFIED IN ACTIVITY 5 *** */
                String symbol;
                int sourceStack;
                int destinationStack;
                try{
                    symbol= input.next();
                    sourceStack = input.nextInt();
                    destinationStack = input.nextInt();
                    board.makeMove(symbol, sourceStack, destinationStack);
                }
                catch (Exception e){
                    System.out.println("Please enter a valid move command in the following format: move [card] [source_stack] [destination_stack]\n");
                    input.nextLine();
                    continue; 
                }
                input = new Scanner(System.in);
            }
            else if (command.equals("draw")) {
                board.drawCards();
                
            }
            else if (command.equals("clear")) {
                /* *** TO BE MODIFIED IN ACTIVITY 5 *** */
                int sourceStack;
                try{
                    sourceStack= input.nextInt();
                    
                }
                catch  (Exception e){
                    System.out.println("Please enter a valid clear command in the following format: clear [source_stack]\n");
                    input.nextLine();
                    continue; 
                }
                board.clear(sourceStack );
                input = new Scanner(System.in);
            }
            else if (command.equals("restart")) {
                board = new Board(NUM_STACKS, NUM_DECKS);
                input = new Scanner(System.in);
                continue; 
            }
            else if (command.equals("quit")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            else if (command.equals("save")){
                board.save();
                input = new Scanner(System.in);
            }
            else if (command.equals("load")){
                //board = board.restore();
                board.restore();
                input = new Scanner(System.in);
            }
            else {
                System.out.println("Invalid command.");
                input = new Scanner(System.in);
                continue; 
            }

            // If all stacks and the draw pile are clear, you win!
            if (board.isEmpty()) {
                gameOver = true;
            }
        }
        System.out.println("Congratulations!  You win !");
    }
}
