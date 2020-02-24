import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2
{
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

        Scanner stdIn = new Scanner(System.in);
        response = stdIn.nextInt();

        return response;
    }

    public static void askQuestion(int random1, int random2)
    {
        System.out.printf("%nWhat is %d * %d?%n", random1, random2);
    }

    public static void quiz()
    {
        SecureRandom rando = new SecureRandom();

        int random1 = rando.nextInt(10);
        int random2 = rando.nextInt(10);
        int response, flag, randomSwitch;

        do {
            randomSwitch = rando.nextInt(4 + 1);
            askQuestion(random1, random2);
            response = readResponse();
            flag = isAnswerCorrect(random1 * random2, response);

            if(flag == 1)
                displayCorrectResponse(randomSwitch);
            else
                displayIncorrectResponse(randomSwitch);
        } while(flag != 1);
    }

    public static void main(String[] args)
    {
        quiz();
    }
}
