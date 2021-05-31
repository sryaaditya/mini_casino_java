import java.util.Scanner;

/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * Blackjack Class
 */
public class Blackjack extends Casino {

    public void game() {
        boolean play = true;
        GameHandler gameHandler = new GameHandler();
        Cashier cashier = new Cashier();
        Account.getSetAccount account = new Account.getSetAccount();
        Scanner keyboard = new Scanner(System.in);

        do {

            Deck deck1 = new Deck();
            deck1.createDeck();
            deck1.shuffleDeck(deck1.getDeck1());
            gameHandler.setDeck(deck1.getDeck2());

            System.out.println(" Hi " + account.getName() + ", Welcome to Blackjack");
            System.out.println(" Your current balance is: $" + account.getBalance());
            System.out.println("---------------------------------------------");

            deck1.createDeck();
            System.out.println(" Shuffling Deck...");
            deck1.shuffleDeck(deck1.getDeck1());
            System.out.println(" Shuffling Deck...");

            System.out.println("---------------------------------------------");
            System.out.println(" Lets Play!");

            /**
             * Get 2 cards each for both players
             */
            // Player
            gameHandler.dealOneCardPlayer(gameHandler.getCardCounter());
            gameHandler.setCardCounter(gameHandler.getCardCounter() + 1);

            gameHandler.dealOneCardPlayer(gameHandler.getCardCounter());
            gameHandler.setCardCounter(gameHandler.getCardCounter() + 1);

            // Dealer
            gameHandler.dealoneCardDealer(gameHandler.getCardCounter());
            gameHandler.setCardCounter(gameHandler.getCardCounter() + 1);

            gameHandler.dealoneCardDealer(gameHandler.getCardCounter());
            gameHandler.setCardCounter(gameHandler.getCardCounter() + 1);

            while (gameHandler.isEndGame() == false) {
                gameHandler.displayPlayer();
                gameHandler.turnLoop();
            }

            if (gameHandler.isEndGame() == true) {
                System.out.println("\n\tFINAL HANDS\n\n");
                gameHandler.displayPlayer();
                gameHandler.check();
                gameHandler.resetAllDeck();
                System.out.println("");
                System.out
                        .print(" Do you want to Play again? \n [1 = Yes, 2 = No, 3 = Cashier]\n Enter your decision: ");
                short answer = keyboard.nextShort();
                switch (answer) {
                    case 1:
                        play = true;
                        gameHandler.setEndGame(false);
                        break;
                    case 2:
                        System.out.println(" Goodluck!");
                        play = false;
                        keyboard.close();
                    case 3:
                        cashier.cashier();
                        break;
                    default:
                        System.out.println(" Cant find what you need sir/mam");
                        break;
                }
                if (answer == 1) {
                } else if (answer == 2) {
                    System.out.println(" Goodluck!");
                    play = false;
                    keyboard.close();
                }

            } else {
                System.out.println(" Thanks for coming!");
                keyboard.close();
            }

        } while (play == true);

    }
}