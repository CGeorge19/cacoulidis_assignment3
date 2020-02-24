import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4
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

    public static int readDifficulty()
    {
        int difficultyLevel;

        // read in and set difficulty level from user
        do {
            System.out.print("\nPlease enter a difficulty level between 1 and 4: ");
            difficultyLevel = stdIn.nextInt();
        } while (difficultyLevel < 1 || difficultyLevel > 4);

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

    public static void askQuestion(int random1, int random2)
    {
        System.out.printf("%nWhat is %d * %d?%n", random1, random2);
    }

    public static void quiz()
    {
        int i, flag, score, response, bound, random1, random2, randomSwitch, difficultyLevel;
        char playAgain;
        SecureRandom rando = new SecureRandom();

        do {
            score = 0;
            difficultyLevel = readDifficulty();

            for (i = 0; i < 10; i++)
            {
                random1 = generateQuestionArgument(difficultyLevel);
                random2 = generateQuestionArgument(difficultyLevel);

                randomSwitch = rando.nextInt( 3 + 1) + 1;

                askQuestion(random1, random2);
                response = readResponse();
                flag = isAnswerCorrect(random1 * random2, response);

                if(flag == 1)
                {
                    displayCorrectResponse(randomSwitch);
                    score +=1;
                }

                else
                    displayIncorrectResponse(randomSwitch);
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
