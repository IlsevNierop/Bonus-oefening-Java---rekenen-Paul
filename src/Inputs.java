import java.util.Scanner;

public class Inputs {




    public static int askForRounds(Scanner myScanner) {
        System.out.println("So first, tell me how many rounds do you want to play?");
        boolean askForRounds = true;
        while (askForRounds) {
            if (myScanner.hasNextInt()) {
                askForRounds = false;
                break;
            } else {
                System.out.println("This is not a valid number, please enter the rounds you want to play in numbers.");
                myScanner.next();
                continue;
            }

        }
        return myScanner.nextInt();
    }

    public static int askForMaxNum(Scanner myScanner) {
        System.out.println("And how much can the random numbers max be?");
        boolean askForMaxNum = true;
        while (askForMaxNum) {
            if (myScanner.hasNextInt()) {
                askForMaxNum = false;
                break;
            } else {
                System.out.println("This is not a valid number, please enter max number.");
                myScanner.next();
                continue;
            }

        }
        return myScanner.nextInt();
    }

    public static int askForResult(Scanner myScanner, int result) {
        boolean askForResult = true;
        while (askForResult) {
            if (myScanner.hasNextInt()) {
                askForResult = false;
            } else {
                System.out.println("This is not a valid number, please enter the result in numbers.");
                myScanner.next();
                continue;
            }

        }
        return myScanner.nextInt();
    }

}
