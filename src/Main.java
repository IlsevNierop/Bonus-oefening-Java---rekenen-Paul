import java.util.Random;
import java.util.Scanner;

public class Main {
//
//    schrijf een klein rekenoefening programma die rekensommen maakt en om een input vraagt en de input checkt met het correcte antwoord.
//    # bouw een applicatie die twee random nummers uit print.# en hier een som van maakt.
//    # vervolgens moet deze om een invoer vragen en checken of de invoer klopt met de gegeven som.
//    # Bonus : maak de methode zo dat er een random operator wordt gebruikt van de soort + - * of /. en hier dus een som van maakt.(tip voeg deze stap voor stap toe niet allemaal gelijk want elke heeft zijn uitdagingen)
//    # Bonus: bij het aftrekken kom je soms negatief uit. als dit het geval is draai dan de nummers om.
//    # Bonus: bij het delen kom je soms op decimalen uit. maak de functie zo dat dit niet meer het geval is. # Tip modulo uitkomst van het grootste getal zetten en deze voorin in de berekening zetten
//    # Bonus bouw in dat je van te voren kan opgeven hoeveel vragen je wilt beantwoorden.
//    # Bonus: bouw een punten systeem erbij voor goede antwoorden en foute antwoorden.
//    # Bonus: schrijf de functie zo dat je zelf kan ingeven hoe hoog de getalen mogen zijn


    public static void main(String[] args) {


        Random rand = new Random();
        Scanner myScanner = new Scanner(System.in);


        //The Game
        boolean playGame = true;
//        while (playGame){

        System.out.println("You want to play: " + askForRounds(myScanner) + " rounds. Let's go!");
        int randNum1 = getRandomNumber(rand);
        int randNum2 = getRandomNumber(rand);
        String operator = getRandomOperator(rand);

        int result = doCalculation(randNum1, randNum2, operator);

        boolean inputResultIsResult = false;
        System.out.println("What do you think is the result of the above calculation?");
        while (!inputResultIsResult) {
            int inputResult = askForResult(myScanner, result);
            inputResultIsResult = checkResult(result, inputResult);

        }


////        System.out.println(result);
////        System.out.println(inputResult);



    }

    public static int getRandomNumber(Random rand) {

        int upperbound = 100;

        int randNum = rand.nextInt(upperbound);

        return randNum;

    }

    public static String getRandomOperator(Random rand) {
        String[] operators = {"+", "-", "/", "*"};
        int operatorIndex = rand.nextInt(0, 4);

        String randOperator = operators[operatorIndex];

        return randOperator;


    }

    public static int doCalculation(int randNum1, int randNum2, String operator) {
        int result1 = 0;
       if (operator == "+") {
            result1 = randNum1 + randNum2;
           System.out.println("Calculate the following calculation: " + randNum1 + " + " + randNum2);
        } else if (operator == "*") {
           result1 = randNum1 * randNum2;
           System.out.println("Calculate the following calculation: " + randNum1 + " * " + randNum2);
        }
        else if (operator == "-") {
           result1 = Math.max(randNum1, randNum2) - Math.min(randNum1, randNum2);
           System.out.println("Calculate the following calculation: " + Math.max(randNum1, randNum2) + " - " + Math.min(randNum1, randNum2));
        }
        else if (operator == "/") {
           int maxRandNumMod = Math.max(randNum1, randNum2) - (Math.max(randNum1, randNum2) % Math.min(randNum1, randNum2));
           result1 = maxRandNumMod / Math.min(randNum1, randNum2);
           System.out.println("Calculate the following calculation: " + maxRandNumMod + " / " + Math.min(randNum1, randNum2));
        }


        return result1;
    }

    public static int askForRounds(Scanner myScanner) {
        System.out.println("How many rounds do you want to play?");
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

    public static boolean checkResult(int inputResult, int result){
        if (inputResult != result){
            System.out.println("This is not the correct answer. Try again.");
        }
        else{
            System.out.println("Yes you did it, good job!");
        }
        return inputResult == result;

    }

}


