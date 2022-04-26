
import java.util.*;
import java.io.*;
import java.lang.*;

public class Trumps {

    Scanner keyboard = new Scanner(System.in);

    int handswon = 0;
    int handslost = 0;
    int gameswon = 0;
    int gameslost = 0;
    int handsplayed = 0;
    int startingcards = 7;
    int DealtCards = 0;

    boolean Suitvalidated = false;
    boolean Gameplaying = true;

    String playerName = getPlayerNameOnStart();

    private String getPlayerNameOnStart() {
        System.out.println("\nWelcome to Trumps");
        System.out.println("\nEnter player name");
        String playerName = keyboard.nextLine();
        return playerName;
    }

    private void printHands(Deck playerDeck1) {
        System.out.println("\nYour hand:");
        System.out.println(playerDeck1.toString());

        // System.out.println("\nOpponent hand:");
        // System.out.println(playerDeck2.toString());
    }

    private Card getChosenCard(Deck playerDeck1) {
        System.out.println("\nWhat card do you want to play");
        int cardChoice = keyboard.nextInt();

        while (cardChoice > playerDeck1.deckSize() || cardChoice < 1) {
            System.out.println("\nError, Input card number again");
            cardChoice = keyboard.nextInt();
        }
        Card chosenCard;
        chosenCard = playerDeck1.getCard(cardChoice - 1);
        playerDeck1.removeCard(cardChoice - 1);
        return chosenCard;
    }

    private Deck createDeck() {
        Deck playingDeck = new Deck();
        playingDeck.createFulldeck();
        playingDeck.shuffle();
        return playingDeck;
    }

    private void dealCards(Deck playerDeck1, Deck playerDeck2, Deck playingDeck) {
        while (DealtCards < startingcards) {
            playerDeck1.Draw(playingDeck);
            playerDeck2.Draw(playingDeck);
            DealtCards++;
        }
    }

    // top level design
    void processTrumps() throws IOException {
        Deck playerDeck1 = new Deck();
        Deck playerDeck2 = new Deck();
        Card opponentCard = null;

        Deck playingDeck = createDeck();
        dealCards(playerDeck1, playerDeck2, playingDeck);
        String trumpSuit = (getTrumpSuit());

        //Game Loop
        while (Gameplaying) {
            while (0 < playerDeck1.deckSize()) {
                printHands(playerDeck1);
                Card chosenCard = getChosenCard(playerDeck1);
                System.out.println(chosenCard);
                validate(playerDeck1, playerDeck2, chosenCard, opponentCard, trumpSuit);
            }
        }
        handsplayed++;
    }

    public void validate(Deck playerDeck1, Deck playerDeck2, Card chosenCard, Card opponentCard, String trumpSuit) throws IOException {

        boolean foundsameSuit = false;
        boolean foundtrumpSuit = false;
        boolean foundnoSuit = false;

        foundsameSuit = evaluateSameSuit(playerDeck2, chosenCard, foundsameSuit);

        if (!foundsameSuit) {
            foundtrumpSuit = evaluateTrumpSuit(playerDeck2, chosenCard, foundsameSuit, foundtrumpSuit, trumpSuit);
        }

        if (!foundsameSuit && !foundtrumpSuit) {
            evaluateNoSuit(playerDeck2);
        }


        if (playerDeck1.deckSize() == 0) {

            if (handslost < handswon) {
                System.out.println("You win the game");
                gameswon++;
                endgame(playerDeck1, handswon, gameswon);
            } else if (handslost > handswon) {
                System.out.println("You lose the game");
                gameslost++;
                endgame(playerDeck1, handswon, gameswon);
            }


        }

        if (!Gameplaying) {
            startingcards--;
        }


    }

    public void endgame(Deck playerDeck1, int handswon, int gameswon) throws IOException {

        if (playerDeck1.deckSize() == 0) {
            String decision = "";
            System.out.println("Out of cards");

            String resultsData = "";
            String resultsData1 = "";


// Java object to output a file
            PrintWriter fileWriter;
            PrintWriter fileWriter1;


            // open file for writing
            fileWriter = new PrintWriter("leaderboard.txt");

            // write output string to file
            fileWriter.println(resultsData = resultsData + playerName + "," + gameswon + "\n");


            // close the file
            fileWriter.close();

            // open file for writing
            fileWriter1 = new PrintWriter("opponent.txt");

            // write output string to file
            fileWriter1.println(resultsData1 = resultsData1 + "Player2" + "," + gameslost + "\n");


            // close the file
            fileWriter1.close();

            Gameplaying = false;

        }
    }

    public boolean evaluateSameSuit(Deck playerDeck2, Card chosenCard, boolean foundsameSuit) {

        int counter = 0;
        //plays same suit
        //works
        while (counter < playerDeck2.deckSize() && !foundsameSuit) {
            if (playerDeck2.getCard(counter).getSuit() == chosenCard.getSuit()) {
                Card opponentCard = playerDeck2.getCard(counter);
                playerDeck2.removeCard(counter);
                System.out.println("\nOpponent plays " + opponentCard);

                if (cardsValue1(chosenCard) > cardsValue2(playerDeck2, opponentCard)) {
                    System.out.println("\nYou win the hand");
                    handswon += 1;
                    foundsameSuit = true;
                } else if (cardsValue1(chosenCard) < cardsValue2(playerDeck2, opponentCard)) {
                    System.out.println("\nYou lose the hand");
                    handslost += 1;
                    foundsameSuit = true;
                }
            }
            counter++;
        }
        return foundsameSuit;
    }

    public boolean evaluateTrumpSuit(Deck playerDeck2, Card chosenCard, boolean foundsameSuit, boolean foundTrumpSuit, String trumpSuit) {

        int counter = 0;
        while (counter < playerDeck2.deckSize()) {
            if ((((playerDeck2.getCard(counter).getSuit())).toString().equals(trumpSuit))) {
                Card opponentCard = playerDeck2.getCard(counter);
                playerDeck2.removeCard(counter);
                System.out.println("Opponent plays " + opponentCard);
                foundTrumpSuit = true;

                if (cardsValue1(chosenCard) > cardsValue2(playerDeck2, opponentCard)) {
                    System.out.println("You win the hand");
                    handswon += 1;
                } else if (cardsValue1(chosenCard) < cardsValue2(playerDeck2, opponentCard)) {
                    System.out.println("You lose the hand");
                    handslost += 1;
                }

                if (foundTrumpSuit && !foundsameSuit) {
                    System.out.println("You lose the hand");
                    handslost += 1;
                }
                Suitvalidated = true;
                break;
            }
            counter++;
        }
        return foundTrumpSuit;
    }

    public void evaluateNoSuit(Deck playerDeck2) {
        Card opponentCard = playerDeck2.getCard(0);
        playerDeck2.removeCard(0);
        System.out.println("Opponent plays " + opponentCard);
        System.out.println("You win the hand");
        handswon += 1;
        Suitvalidated = true;
    }

    public String getTrumpSuit() {
        int r = (int) (Math.random() * 4);
        String trumpSuit = new String[]{"Clubs", "Diamonds", "Spades", "Hearts"}[r];
        System.out.println("src.Trumps is " + trumpSuit);
        return trumpSuit;
    }

    public int cardsValue1(Card chosenCard) {

        int intvalue1 = 0;


        if (chosenCard.getValue().toString() == ("Two")) {
            intvalue1 = 2;

        } else if (chosenCard.getValue().toString() == ("Three")) {
            intvalue1 = 3;

        } else if (chosenCard.getValue().toString() == ("Four")) {
            intvalue1 = 4;

        } else if (chosenCard.getValue().toString() == ("Five")) {
            intvalue1 = 5;

        } else if (chosenCard.getValue().toString() == ("Six")) {
            intvalue1 = 6;

        } else if (chosenCard.getValue().toString() == ("Seven")) {
            intvalue1 = 7;

        } else if (chosenCard.getValue().toString() == ("Eight")) {
            intvalue1 = 8;

        } else if (chosenCard.getValue().toString() == ("Nine")) {
            intvalue1 = 9;

        } else if (chosenCard.getValue().toString() == ("Ten")) {
            intvalue1 = 10;

        } else if (chosenCard.getValue().toString() == ("Jack")) {
            intvalue1 = 11;

        } else if (chosenCard.getValue().toString() == ("Queen")) {
            intvalue1 = 12;

        } else if (chosenCard.getValue().toString() == ("King")) {
            intvalue1 = 13;

        } else if (chosenCard.getValue().toString() == ("Ace")) {
            intvalue1 = 14;

        }


        return intvalue1;
    }


    public int cardsValue2(Deck playerDeck2, Card opponentCard) {

        int intvalue2 = 0;


        if (opponentCard.getValue().toString() == ("Two")) {
            intvalue2 = 2;

        } else if (opponentCard.getValue().toString() == ("Three")) {
            intvalue2 = 3;

        } else if (opponentCard.getValue().toString() == ("Four")) {
            intvalue2 = 4;

        } else if (opponentCard.getValue().toString() == ("Five")) {
            intvalue2 = 5;

        } else if (opponentCard.getValue().toString() == ("Six")) {
            intvalue2 = 6;

        } else if (opponentCard.getValue().toString() == ("Seven")) {
            intvalue2 = 7;

        } else if (opponentCard.getValue().toString() == ("Eight")) {
            intvalue2 = 8;

        } else if (opponentCard.getValue().toString() == ("Nine")) {
            intvalue2 = 9;

        } else if (opponentCard.getValue().toString() == ("Ten")) {
            intvalue2 = 10;

        } else if (opponentCard.getValue().toString() == ("Jack")) {
            intvalue2 = 11;

        } else if (opponentCard.getValue().toString() == ("Queen")) {
            intvalue2 = 12;

        } else if (opponentCard.getValue().toString() == ("King")) {
            intvalue2 = 13;

        } else if (opponentCard.getValue().toString() == ("Ace")) {
            intvalue2 = 14;

        }


        return intvalue2;
    }
}