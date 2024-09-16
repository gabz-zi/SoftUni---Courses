

import java.util.Scanner;
import java.util.Random;

public class rockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playersMove = scanner.nextLine();
        int playersWins = 0;
        int computersWins = 0;
        while (!playersMove.equals("quit")) {
            boolean invalid = !playersMove.equals("r") && !playersMove.equals("p") && !playersMove.equals("s") && !playersMove.equals("rock") && !playersMove.equals("paper") && !playersMove.equals("scissors");
            if (invalid) {
                System.out.println("Invalid Input. Try Again...");
                while (invalid) {
                    System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
                    playersMove = scanner.nextLine();
                    if (playersMove.equals("r") || playersMove.equals("p") || playersMove.equals("s") || playersMove.equals("rock") || playersMove.equals("paper") || playersMove.equals("scissors")) {
                        break;
                    }
                }
            }
            if (playersMove.equals("r") || playersMove.equals("rock")) {
                playersMove = ROCK;
            } else if (playersMove.equals("p") || playersMove.equals("paper")) {
                playersMove = PAPER;
            } else if (playersMove.equals("s") || playersMove.equals("scissors")) {
                playersMove = SCISSORS;
            }
            Random random = new Random();
            int computerRandomNumber = random.nextInt(3);
            String computersMove = "";
            switch (computerRandomNumber) {
                case 0:
                    computersMove = ROCK;
                    break;
                case 1:
                    computersMove = PAPER;
                    break;
                case 2:
                    computersMove = SCISSORS;
                    break;
            }
            System.out.printf("The computer chose %s.%n", computersMove);
            if ((playersMove.equals(ROCK) && computersMove.equals(SCISSORS)) || (playersMove.equals(PAPER) && computersMove.equals(ROCK)) || (playersMove.equals(SCISSORS) && computersMove.equals(PAPER))) {
                System.out.println("You win.");
                playersWins++;
            } else if ((playersMove.equals(ROCK) && computersMove.equals(PAPER)) || (playersMove.equals(PAPER) && computersMove.equals(SCISSORS)) || (playersMove.equals(SCISSORS) && computersMove.equals(ROCK))) {
                System.out.println("You lose.");
                computersWins++;
            } else {
                System.out.println("This game was a draw.");
            }
            System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
            playersMove = scanner.nextLine();
        }
        if (playersWins > computersWins) {
            System.out.println("   :>)                       :<(");
            System.out.printf("Player: %d       VS       Computer: %d", playersWins, computersWins);
        } else if (playersWins < computersWins) {
            System.out.println("   :<(                       :>)");
            System.out.printf("Player: %d       VS       Computer: %d", playersWins, computersWins);
        } else {
            System.out.println("   :*|                       :*|");
            System.out.printf("Player: %d       VS       Computer: %d", playersWins, computersWins);
        }
    }
}
