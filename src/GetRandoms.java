import java.util.Random;

public class GetRandoms {

    int randNum;

    String randOperator;


    public GetRandoms(int randNum) {
        this.randNum = randNum;
    }

    public GetRandoms(String randOperator) {
        this.randOperator = randOperator;
    }


    public GetRandoms(int randNum, String randOperator) {
        this.randNum = randNum;
        this.randOperator = randOperator;
    }

    Random rand = new Random();
    public static int getRandomNumber(Random rand, int upperbound) {

        int randNum = rand.nextInt(1, upperbound);

        return randNum;

    }

    public static String getRandomOperator(Random rand) {
        String[] operators = {"+", "-", "/", "*"};
        int operatorIndex = rand.nextInt(0, 4);

        String randOperator = operators[operatorIndex];

        return randOperator;


    }


}
