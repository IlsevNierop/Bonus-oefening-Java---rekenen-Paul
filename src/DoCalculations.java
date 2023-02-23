public class DoCalculations {


    public static int doCalculation(int randNum1, int randNum2, String operator) {
        int result1 = 0;
        if (operator == "+") {
            result1 = randNum1 + randNum2;
            System.out.println("Do the following calculation: " + randNum1 + " + " + randNum2);
        } else if (operator == "*") {
            result1 = randNum1 * randNum2;
            System.out.println("Do the following calculation: " + randNum1 + " * " + randNum2);
        } else if (operator == "-") {
            result1 = Math.max(randNum1, randNum2) - Math.min(randNum1, randNum2);
            System.out.println("Do the following calculation: " + Math.max(randNum1, randNum2) + " - " + Math.min(randNum1, randNum2));
        } else if (operator == "/") {
            int maxRandNumMod = Math.max(randNum1, randNum2) - (Math.max(randNum1, randNum2) % Math.min(randNum1, randNum2));
            result1 = maxRandNumMod / Math.min(randNum1, randNum2);
            System.out.println("Do the following calculation: " + maxRandNumMod + " / " + Math.min(randNum1, randNum2));
        }


        return result1;
    }

    public static boolean checkResult(int inputResult, int result, int playedRounds, int rounds, int score) {
        if (inputResult != result) {
            System.out.println("This is not the correct answer. Try again.");
        } else {
            if (playedRounds == rounds) {
                System.out.println("You calculated everything right! Good job!");

            } else {
                System.out.println("Yes you did it!");
            }
        }

        return inputResult == result;

    }

    public static int calculateScore (boolean checkResult, int score){
        if (!checkResult){
            score = score - 2;
        }
        else {
            score = score + 5;
        }
        return score;
    }
}
