import java.util.Scanner;

class Guesser {
    int guessNum;

    int guessNum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guesser, please provide a number for the game:");
        guessNum = scan.nextInt();
        System.out.println();
        return guessNum;
    }
}

class Player {
    int guessNum;

    int guessNum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player, please enter your guess:");
        guessNum = scan.nextInt();
        return guessNum;
    }
}

class Referee {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void collectNumFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessNum();
    }

    void collectNumFromPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        numFromPlayer1 = p1.guessNum();
        numFromPlayer2 = p2.guessNum();
        numFromPlayer3 = p3.guessNum();
    }

    void compare() {
        int trials = 3;
        while (trials >= 1) {
            if (numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("All players guessed correctly. It's a tie!");
                break;
            } else if (numFromGuesser == numFromPlayer1 || numFromGuesser == numFromPlayer2 || numFromGuesser == numFromPlayer3) {
                System.out.println("Congratulations! One of the players guessed correctly.");
                break;
            } else {
                trials--;
                if (trials > 0) {
                    System.out.println("No one guessed correctly. " + trials + " attempts remaining.");
                    collectNumFromPlayers();
                } else {
                    System.out.println("Attempts exhausted. No winner this time.");
                }
            }
        }
    }
}

public class GuessTheNumberGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Number Game!");
        System.out.println("Numbers used are between 0 and 9.");

        Referee referee = new Referee();
        referee.collectNumFromGuesser();
        referee.collectNumFromPlayers();
        referee.compare();
    }
}
