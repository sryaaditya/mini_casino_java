import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * GameHandler Class
 */

public class GameHandler extends Blackjack {

    private Card[] Deck = new Card[52];
    private Transaction transaction = new Transaction();
    private Account.getSetAccount account = new Account.getSetAccount();
    private ArrayList<Card> playerHand = new ArrayList<>();
    private ArrayList<Card> dealerHand = new ArrayList<>();
    private int pValue = 0;
    private int dValue = 0;
    private int cardCounter = 0;
    private boolean endGame = false;

    /**
     * Winner Prize
     */
    final int blackjackWin = 125;
    final int defaultWin = 100;

    /**
     * 
     * End Game Setter & Getter
     */
    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    /**
     * Card counter Setter & Getter
     */
    public int getCardCounter() {
        return cardCounter;
    }

    public void setCardCounter(int cardCounter) {
        this.cardCounter = cardCounter;
    }

    /**
     * Player value Setter & Getter
     */
    public int getpValue() {
        return pValue;
    }

    public int getdValue() {
        return dValue;
    }

    /**
     * Player deck Setter & Getter
     */
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    /**
     * Pick one card method Getter & Setter
     */
    public void dealOneCardPlayer(int i) {
        playerHand.add(Deck[i]);
    }

    public void dealoneCardDealer(int i) {
        dealerHand.add(Deck[i]);
    }

    public void setDealerHand(ArrayList<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public void setDeck(Card[] Deck) {
        this.Deck = Deck;
    }

    /**
     * Reset deck getter & Setter
     */
    public void resetAllDeck() {
        playerHand.removeAll(playerHand);
        dealerHand.removeAll(dealerHand);
    }

    /**
     * Display last deck and summary value on Players deck
     */
    public void displayPlayer() {
        pValue = 0;
        dValue = 0;
        System.out.println("---------------------------------------------");
        System.out.println("\t\tDEALER HAND");
        System.out.println("---------------------------------------------");
        /**
         * Summary and get dealer hand deck
         */
        for (int i = 0; i < dealerHand.size(); i++) {
            System.out.println(dealerHand.get(i).getName() + " of " + dealerHand.get(i).getSuit());
            dValue = dValue + dealerHand.get(i).getValue();
        }
        System.out.println("---------------------------------------------");
        System.out.println(" Dealer Hand Value = " + dValue);
        System.out.println("---------------------------------------------");

        System.out.println("---------------------------------------------");
        System.out.println("\t\tPLAYER HAND");
        System.out.println("---------------------------------------------");
        /**
         * Summary and get player hand deck
         */
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).getName() + " of " + playerHand.get(i).getSuit());
            pValue = pValue + playerHand.get(i).getValue();
        }
        System.out.println("---------------------------------------------");
        System.out.println(" Player Hand Value = " + pValue);
        System.out.println("---------------------------------------------\n\n");
    }

    /**
     * Decisiion for Players to Hit, Stay or Call
     */
    public void turnLoop() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Do you want to (H)it, (S)tay, or (C)all?");
        System.out.println("---------------------------------------------");
        System.out.print(" Enter your answer: ");
        String hitstaycall = keyboard.nextLine();

        /**
         * This method will add a card to player
         */
        if ("h".equals(hitstaycall.toLowerCase())) {
            playerHand.add(Deck[cardCounter]);
            pValue = pValue + Deck[cardCounter].getValue();
            cardCounter++;
            /**
             * As long as the dealer deck sum less than 16 dealer must take a card
             */
            if (dValue < 16) {
                dealerHand.add(Deck[cardCounter]);
                dValue = dValue + Deck[cardCounter].getValue();
                cardCounter++;
            }

            dValue = 0;
            pValue = 0;

            for (int i = 0; i < dealerHand.size(); i++) {
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for (int i = 0; i < playerHand.size(); i++) {
                pValue = pValue + playerHand.get(i).getValue();
            }

            if (dValue > 21 && pValue > 21) {
                System.out.println("---------------------------------------------");
                System.out.println(" You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21) {
                if (pValue == 21) {
                    transaction.deposite(account.getBalance(), blackjackWin);
                    System.out.println("---------------------------------------------");
                    System.out.println(" BLACKJACK!, You win");
                    System.out.println(" Your balance is now : " + account.getBalance());
                    System.out.println("---------------------------------------------");
                } else {
                    System.out.println("---------------------------------------------");
                    System.out.println(" BLACKJACK!, Dealer win");
                    System.out.println("---------------------------------------------");
                }
                endGame = true;
            }
            if (dValue > 21 && pValue < 22) {

                transaction.deposite(account.getBalance(), defaultWin);
                System.out.println("---------------------------------------------");
                System.out.println(" Dealer BUST. You Win");
                System.out.println(" Your balance is now : " + account.getBalance());
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (pValue > 21 && dValue < 22) {
                System.out.println("---------------------------------------------");
                System.out.println(" You BUST. Dealer Win");
                System.out.println("---------------------------------------------");
                endGame = true;
            }

        }
        /**
         * This condiiton not gonna do anything for player but add card to dealer if the
         * dealer deck value < 16
         */
        else if ("s".equals(hitstaycall.toLowerCase())) {
            /**
             * As long as the dealer deck sum less than 16 dealer must take a card
             */
            if (dValue < 16) {
                dealerHand.add(Deck[cardCounter]);
                dValue = dValue + Deck[cardCounter].getValue();
                cardCounter++;
            }

            dValue = 0;
            pValue = 0;

            for (int i = 0; i < dealerHand.size(); i++) {
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for (int i = 0; i < playerHand.size(); i++) {
                pValue = pValue + playerHand.get(i).getValue();
            }

            if (dValue > 21 && pValue > 21) {
                System.out.println("---------------------------------------------");
                System.out.println(" You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21) {
                if (pValue == 21) {
                    transaction.deposite(account.getBalance(), blackjackWin);
                    System.out.println("---------------------------------------------");
                    System.out.println(" BLACKJACK!, You win");
                    System.out.println(" Your balance is now : " + account.getBalance());
                    System.out.println("---------------------------------------------");
                } else {
                    System.out.println("---------------------------------------------");
                    System.out.println(" BLACKJACK!, Dealer win");
                    System.out.println("---------------------------------------------");
                }
                endGame = true;
            }
            if (dValue > 21 && pValue < 22) {
                transaction.deposite(account.getBalance(), defaultWin);
                System.out.println("---------------------------------------------");
                System.out.println(" Dealer BUST. You Win");
                System.out.println(" Your balance is now : " + account.getBalance());
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (pValue > 21 && dValue < 22) {
                System.out.println("---------------------------------------------");
                System.out.println(" You BUST. Dealer Win");
                System.out.println("---------------------------------------------");
                endGame = true;
            }

        }
        /**
         * This methid will check last deck all players had and if dealer value less
         * than player dealer add a card to his deck
         */
        else if ("c".equals(hitstaycall.toLowerCase())) {
            dValue = 0;
            pValue = 0;

            for (int i = 0; i < dealerHand.size(); i++) {
                dValue = dValue + dealerHand.get(i).getValue();
            }
            for (int i = 0; i < playerHand.size(); i++) {
                pValue = pValue + playerHand.get(i).getValue();
            }

            /**
             * Add card to dealer if dealer value < player value and player value < 21
             */
            if (dValue < pValue && pValue < 21) {
                dealerHand.add(Deck[cardCounter]);
                dValue = dValue + Deck[cardCounter].getValue();
                cardCounter++;
            }
            if (pValue > dValue && pValue < 22) {
                transaction.deposite(account.getBalance(), defaultWin);
                System.out.println("---------------------------------------------");
                System.out.println(" YOU WIN!!!!");
                System.out.println(" Your balance is now : " + account.getBalance());
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (dValue > pValue && dValue < 22) {
                System.out.println("---------------------------------------------");
                System.out.println(" Dealer Wins!");
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (dValue > 21 && pValue > 21) {
                System.out.println("---------------------------------------------");
                System.out.println(" You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (pValue == 21 || dValue == 21) {
                if (pValue == 21) {
                    transaction.deposite(account.getBalance(), blackjackWin);
                    System.out.println("---------------------------------------------");
                    System.out.println(" BLACKJACK!, You win");
                    System.out.println(" Your balance is now : " + account.getBalance());
                    System.out.println("---------------------------------------------");
                } else {
                    System.out.println("---------------------------------------------");
                    System.out.println(" BLACKJACK!, Dealer win");
                    System.out.println("---------------------------------------------");
                }
                endGame = true;
            }
            if (dValue > 21 && pValue < 22) {
                transaction.deposite(account.getBalance(), defaultWin);
                System.out.println("---------------------------------------------");
                System.out.println(" Dealer BUST. You Win");
                System.out.println(" Your balance is now : " + account.getBalance());
                System.out.println("---------------------------------------------");
                endGame = true;
            }
            if (pValue > 21 && dValue < 22) {
                System.out.println("---------------------------------------------");
                System.out.println(" You BUST. Dealer Win");
                System.out.println("---------------------------------------------");
                endGame = true;
            }
        } else {
            System.out.println("Hey you.");
            keyboard.close();
        }
    }

    /**
     * This method just like win checker summary the value than compare who is the
     * closest to 21
     */
    public void check() {
        dValue = 0;
        pValue = 0;

        for (int i = 0; i < dealerHand.size(); i++) {
            dValue = dValue + dealerHand.get(i).getValue();
        }
        for (int i = 0; i < playerHand.size(); i++) {
            pValue = pValue + playerHand.get(i).getValue();
        }

        if (dValue > 21 && pValue > 21) {
            System.out.println("---------------------------------------------");
            System.out.println(" You Lose. Dealer doesn't lose because you bust first. Its the House rules...");
            System.out.println("---------------------------------------------");
            endGame = true;
        }
        if (pValue == 21 || dValue == 21) {
            if (pValue == 21) {
                transaction.deposite(account.getBalance(), blackjackWin);
                System.out.println("---------------------------------------------");
                System.out.println(" BLACKJACK!, You win");
                System.out.println(" Your balance is now : " + account.getBalance());
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("---------------------------------------------");
                System.out.println(" BLACKJACK!, Dealer win");
                System.out.println("---------------------------------------------");
            }
            endGame = true;
        }
        if (dValue > 21 && pValue < 22) {
            transaction.deposite(account.getBalance(), defaultWin);
            System.out.println("---------------------------------------------");
            System.out.println(" Dealer BUST. You Win");
            System.out.println(" Your balance is now : " + account.getBalance());
            System.out.println("---------------------------------------------");
            endGame = true;
        }
        if (pValue > 21 && dValue < 22) {
            System.out.println("---------------------------------------------");
            System.out.println(" You BUST. Dealer Win");
            System.out.println("---------------------------------------------");
            endGame = true;
        }
    }
}