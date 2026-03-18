import java.util.Scanner;

/**
 * This class represents the Guesser who picks a secret number.
 * The players will try to guess this number.
 */
class Guesser {
    /** The secret number chosen by the guesser */
    int gnum;

    /**
     * Asks the guesser to enter a number.
     * @param scn Scanner object for taking input
     * @return the number entered by the guesser
     */
    int guessingNum(Scanner scn) {
        System.out.println("Guesser, enter a number:");
        gnum = scn.nextInt();
        return gnum;
    }
}

/**
 * This class represents a Player who tries to predict the guesser's number.
 */
class Player {
    /** The number predicted by the player */
    int pnum;

    /**
     * Asks the player to enter their predicted number.
     * @param scn Scanner object for taking input
     * @return the predicted number
     */
    int number(Scanner scn) {
        System.out.println("Enter your predicted number:");
        pnum = scn.nextInt();
        return pnum;
    }
}

/**
 * The Umpire manages the whole game.
 * It collects numbers from the guesser and players, then compares them.
 */
class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    Scanner scn;

    /**
     * Constructor that takes a Scanner for input.
     * @param scn shared Scanner object
     */
    Umpire(Scanner scn) {
        this.scn = scn;
    }

    /**
     * Collects the secret number from the guesser.
     */
    void collectNumFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessingNum(scn);
    }

    /**
     * Collects predicted numbers from all three players.
     */
    void collectNumFromPlayers() {
        Player p1 = new Player();
        System.out.println("-- Player 1 --");
        numFromPlayer1 = p1.number(scn);

        Player p2 = new Player();
        System.out.println("-- Player 2 --");
        numFromPlayer2 = p2.number(scn);

        Player p3 = new Player();
        System.out.println("-- Player 3 --");
        numFromPlayer3 = p3.number(scn);
    }

    /**
     * Compares the guesser's number with each player's prediction
     * and announces the winner.
     */
    void compare() {
        if (numFromGuesser == numFromPlayer1) {
            System.out.println("Player 1 won!");
        } else if (numFromGuesser == numFromPlayer2) {
            System.out.println("Player 2 won!");
        } else if (numFromGuesser == numFromPlayer3) {
            System.out.println("Player 3 won!");
        } else {
            System.out.println("Nobody guessed it. Try again!");
        }
    }
}

/**
 * Main class for the Number Guessing Game.
 * One guesser picks a number and three players try to predict it.
 * The umpire checks who got it right.
 *
 * @author Aryan Gupta
 */
public class GuesserGame {
    /**
     * Entry point - starts the game.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Umpire u = new Umpire(scn);
        u.collectNumFromGuesser();
        u.collectNumFromPlayers();
        u.compare();

        scn.close();
    }
}
