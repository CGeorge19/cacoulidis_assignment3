import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5
{
    // create input stream
    private static Scanner stdIn = new Scanner(System.in);

    public static int generateQuestionArgument(int difficultyLevel)
    {
        int bound = 0;

        SecureRandom rando = new SecureRandom();

        // use difficulty level to feed the correct bounds to the rando SecureRandom
        if (difficultyLevel == 1)
            bound = 10;
        else if (difficultyLevel == 2)
            bound = 100;
        else if (difficultyLevel == 3)
            bound = 1000;
        else if (difficultyLevel == 4)
            bound = 10000;

        return rando.nextInt(bound);
    }

    public static int readProblemType()
    {
        int difficultyLevel;

        // print menu of problem types
        System.out.println("\n1) Addition problems");
        System.out.println("2) Multiplication problems");
        System.out.println("3) Subtraction problems");
        System.out.println("4) Division problems");
        System.out.println("5) Randomized problems");

        // read in and set difficulty level from user
        do {

            System.out.print("\nPlease enter a difficulty level between 1 and 5: ");
            difficultyLevel = stdIn.nextInt();
        } while (difficultyLevel < 1 || difficultyLevel > 5);

        return difficultyLevel;
    }

    public static void displayCompletionMessage(int score)
    {
        int percentCorrect = (score * 100) / 10;

        System.out.printf("%nYour score was: %d%%%n", percentCorrect);

        if (percentCorrect < 75)
            System.out.println("Please ask your teacher for extra help.");
        else
            System.out.println("Congratulations, you are ready to go to the next level!");
    }

    public static void displayIncorrectResponse(int randomSwitch)
    {
        switch (randomSwitch)
        {
            case 1:
                System.out.println("No. Please try again.");
                break;

            case 2:
                System.out.println("Wrong. Try once more.");
                break;

            case 3:
                System.out.println("Don't give up!");
                break;

            case 4:
                System.out.println("No. Keep Trying.");
                break;
        }
    }

    public static void displayCorrectResponse(int randomSwitch)
    {
        switch (randomSwitch)
        {
            case 1:
                System.out.println("Very Good!");
                break;

            case 2:
                System.out.println("Excellent!");
                break;

            case 3:
                System.out.println("Nice Work!");
                break;

            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    public static int isAnswerCorrect(int correctAns, int studentAns)
    {
        if (studentAns == correctAns)
            return 1;
        else
            return 0;
    }

    public static int readResponse()
    {
        int response;
        response = stdIn.nextInt();
        return response;
    }

    public static void askQuestion(int random1, int random2, char operator)
    {
        System.out.printf("%nWhat is %d %c %d?%n", random1, operator, random2);
    }

    public static int conductOperation(int random1, int random2, char operator)
    {
        if (operator == '+')
            return random1 + random2;
        if (operator == '*')
            return random1 * random2;
        if (operator == '-')
            return random1 - random2;
        if (operator == '/')
            return random1 / random2;
        else
            return -1;
    }

    public static char decideOperator(int difficultyLevel)
    {
        if (difficultyLevel == 1)
            return '+';
        if (difficultyLevel == 2)
            return '*';
        if (difficultyLevel == 3)
            return '-';
        if (difficultyLevel == 4)
            return '/';
        else
            return '\0';
    }

    public static void quiz()
    {
        int i, flag, score, response, bound, random1, random2, randomSwitch, difficultyLevel, difficultyChanged = 0;
        char playAgain, operator;
        SecureRandom rando = new SecureRandom();

        do {
            score = 0;
            difficultyLevel = readProblemType();

            for (i = 0; i < 10; i++)
            {
                if (difficultyLevel > 4)
                {
                    difficultyChanged = 1;
                    difficultyLevel = rando.nextInt(3 + 1) + 1;
                }


                random1 = generateQuestionArgument(difficultyLevel);
                random2 = generateQuestionArgument(difficultyLevel);

                randomSwitch = rando.nextInt( 3 + 1) + 1;

                operator = decideOperator(difficultyLevel);

                askQuestion(random1, random2, operator);
                response = readResponse();
                flag = isAnswerCorrect(conductOperation(random1, random2, operator), response);

                if(flag == 1)
                {
                    displayCorrectResponse(randomSwitch);
                    score +=1;
                }

                else
                    displayIncorrectResponse(randomSwitch);

                if (difficultyChanged == 1)
                    difficultyLevel = 5;
            }

            displayCompletionMessage(score);

            System.out.println("\nWould you like to solve another set? (y/n)");
            playAgain = stdIn.next().toLowerCase().charAt(0);
        } while (playAgain == 'y');
    }

    public static void main(String[] args)
    {
        quiz();
    }
}
