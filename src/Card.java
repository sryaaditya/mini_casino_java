
/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * Card Class
 */
public class Card extends Deck {
    private int value;
    private String suit;
    private String name;

    /**
     * Card name Getter & Setter
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Summary of deck Getter & Setter
     */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Suit (Spades, Clubs, Diamonds, Hearts) Setter & Getter
     */
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

}