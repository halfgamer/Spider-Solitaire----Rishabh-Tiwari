

public class CardTester
{
    public static void main(String[] args) {
        Card myCard1 = new Card ("King", 13);
        
        System.out.printf("Card 1\n");
        System.out.printf("\tSymbol: %s\n",myCard1.getSymbol());
        System.out.printf("\tValue: %d\n",myCard1.getValue());
        
        Card myCard2 = new Card("Ace",1);
        
        System.out.printf("\nCard 2\n");
        System.out.printf("\tIs it faced up ? : %b", myCard2.isFaceUp());
        System.out.printf("\n\tIs it equal to Card 1? : %b",myCard2.equals(myCard1));
        
        Card myCard3 = new Card("10",10);
        
        System.out.printf("\n\nCard 3\n");
        System.out.printf("\tTo String prints: %s",myCard3.toString());
        myCard3.setFaceUp(true);
        System.out.printf("\n\tAfter setting it's face to be up, isFaceUp() returns: %b",myCard3.isFaceUp());
        System.out.printf("\n\tNow To String prints: %s",myCard3.toString());
        
        Card myCard4 = new Card("Queen",12);
        
        System.out.printf("\n\nCard 4\n");
        System.out.printf("\tValue: %d\n",myCard4.getValue());
        System.out.printf("\tComparing this to Card 3 returns: %d\n",myCard4.compareTo(myCard3));
    }
}
