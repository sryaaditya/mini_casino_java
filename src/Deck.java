import java.util.Random;

/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * Deck Class
 */
public class Deck extends GameHandler {

    private Card[] Deck1 = new Card[52];
    private Card[] Deck2 = new Card[52];

    /**
     * Deck Setter & Getter
     */

    public Card[] getDeck1() {
        return Deck1;
    }

    public void setDeck1(Card[] Deck1) {
        this.Deck1 = Deck1;
    }

    public Card[] getDeck2() {
        return Deck2;
    }

    public void setDeck2(Card[] Deck2) {
        this.Deck2 = Deck2;
    }

    /**
     * More like create Card here
     */
    public void shuffleDeck(Card[] Deck) {
        for (int i = 0; i < 52; i++) {
            Random rand = new Random();
            int position = rand.nextInt((51 - 0) + 1);
            Deck2[i] = Deck1[position];
        }
    }

    /**
     * Deck Generator
     */
    public void createDeck() {
        int B;
        int value;
        String suit;
        int deckPosition = 0;
        for (B = 1; B <= 4; B++) {
            if (B == 1) {
                suit = "Spades";
            } else if (B == 2) {
                suit = "Hearts";
            } else if (B == 3) {
                suit = "Clubs";
            } else {
                suit = "Diamonds";
            }
            for (int i = 1; i <= 13; i++) {
                value = i;
                Card card = new Card(value, suit);
                Deck1[deckPosition] = card;
                if (Deck1[deckPosition].getValue() == 11) {
                    Deck1[deckPosition].setName("Jack");
                    Deck1[deckPosition].setValue(10);
                } else if (Deck1[deckPosition].getValue() == 12) {
                    Deck1[deckPosition].setName("Queen");
                    Deck1[deckPosition].setValue(10);
                } else if (Deck1[deckPosition].getValue() == 13) {
                    Deck1[deckPosition].setName("King");
                    Deck1[deckPosition].setValue(10);
                } else if (Deck1[deckPosition].getValue() == 1) {
                    Deck1[deckPosition].setName("Ace");
                    Deck1[deckPosition].setValue(11);

                } else {
                    Deck1[deckPosition].setName(Integer.toString(Deck1[deckPosition].getValue()));
                }
                deckPosition++;
            }
        }

    }

}