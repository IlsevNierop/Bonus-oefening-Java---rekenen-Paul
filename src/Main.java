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
        Inputs input = new Inputs();
        DoCalculations calculation = new DoCalculations();


        System.out.println("Let's go do some calculations. I will pick two random numbers and add these to a calculation. You will have to calculate the result.\nFor every right answer you will get 5 points, and for every wrong answer 2 points will be deducted.");
        int rounds = Inputs.askForRounds(myScanner);
        int upperbound = Inputs.askForMaxNum(myScanner);

        System.out.println("You want to play " + rounds + " rounds and the numbers will be max " + upperbound + ". Let's go!");

        int playedRounds = 0;
        int score = 0;
        while (playedRounds < rounds) {
            if ((playedRounds+1) == rounds) {
                System.out.println("Last round!");
                ++playedRounds;
            } else {
                System.out.println("Round " + ++playedRounds);
            }
            GetRandoms randNum1 = new GetRandoms(GetRandoms.getRandomNumber(rand, upperbound));
            GetRandoms randNum2 = new GetRandoms(GetRandoms.getRandomNumber(rand, upperbound));
            GetRandoms randOperator = new GetRandoms(GetRandoms.getRandomOperator(rand));
            int result = DoCalculations.doCalculation(randNum1.randNum, randNum2.randNum, randOperator.randOperator);

            boolean inputResultIsResult = false;
            System.out.println("What do you think is the result?");
            while (!inputResultIsResult) {
                int inputResult = Inputs.askForResult(myScanner, result);
                inputResultIsResult = DoCalculations.checkResult(result, inputResult, playedRounds, rounds, score);
                score = DoCalculations.calculateScore(inputResultIsResult, score);
                if ((playedRounds) == rounds){
                    System.out.println("Your final score is " + score + " points.");
                }
                else {
                    System.out.println("Your current score is " + score + " points.");
                }
            }

        }

    }






}


