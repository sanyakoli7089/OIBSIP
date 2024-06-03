import java.util.*;

public class NUMBER_GUESSING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String play ="YES";
        int Round =0;
        int Total_Score = 0;
        int Total_Tries = 0; 

        System.out.println();
        System.out.println("Choose Number between 1 to 100. You have oly 5 tries.");
        while (play.equals("YES")){
            ++Round;

            int Guess;
            int i;
            int k=5;
            int Tries=0;
            int Score=5;
            Random random = new Random();
            int Number = random.nextInt(100);

            for(i =0; i<k;i++){
                System.out.println();
                System.out.println("Guess the Number : ");
                Guess = sc.nextInt();

                if(Number==Guess){
                    Tries++;

                    System.out.println("CONGRATULATIONS!!\n You guessed the number.");
                    System.out.println();
                    System.out.println("\nTries : "+Tries);
                    System.out.println("Score : "+Score);
                    
                    Total_Tries += Tries;
                    Total_Score += Score;

                    System.out.println();
                    System.out.print("Would you like to play again? \n YES or NO : ");
                    play = sc.next().toUpperCase();
                    break;
                } else if (Number > Guess && i!=k-1){
                    System.out.println("The Number is greater than " + Guess);
                    Tries++;
                    Score--;
                } else {
                    System.out.println("The number is less than " +Guess);
                    Tries++;
                    Score--;
                }
            }
            if(i==k){
                System.out.println("You have exhausted 5 Tries.");
                System.out.println("The Number was "+ Number);
                Total_Tries += Tries;
                Total_Score += Score;

                System.out.println("\nTries : "+Tries);
                System.out.println("Score : "+Score);
                System.out.println();
                System.out.print("Would you like to play Again? YES or NO : ");
                play = sc.next().toUpperCase();
            }
        }
        System.out.println("\nRounds : "+Round);
        System.out.println("Total Tries : "+Total_Tries);
        System.out.println("Total Score : "+Total_Score);
    }
}