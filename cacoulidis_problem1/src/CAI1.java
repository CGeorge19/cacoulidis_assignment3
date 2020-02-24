import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1
{
    public static void displayIncorrectResponse()
    {
        System.out.println("No. Please try again.");
    }

    public static void displayCorrectResponse()
    {
        System.out.println("Very good!");
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
        int response, flag;

        do{
            askQuestion(random1, random2);
            response = readResponse();
            flag = isAnswerCorrect(random1 * random2, response);

            if(flag == 1)
                displayCorrectResponse();
            else
                displayIncorrectResponse();
        } while(flag != 1);
    }

    public static void main(String[] args)
    {
        quiz();
    }
}
