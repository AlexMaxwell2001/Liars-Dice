import java.util.*;

public class LiarDice {

    public static void main(String args[] ) throws Exception {

       Scanner sc = new Scanner(System.in);

        String p = sc.nextLine();

        int players = Integer.parseInt(p);

        String input = sc.nextLine();

        String[] mydice = input.split(" ");

        int quantity = 0;

        int value = 0;

        int[] dicearray = new int[6];

        for(int i = 0; i<mydice.length;i++){

            for(int j=0;j<6;j++){

                if((int)Integer.parseInt(mydice[i])==j+1||(int)Integer.parseInt(mydice[i])==1){

                    dicearray[j]++;

                }
            }
        }

        for(int i=0;i<6;i++){

            if(dicearray[i]>=quantity){

                quantity=dicearray[i];

                value = i+1;
            }
        }

        int probability=100;
        int claim = quantity;
        while(probability>=50){

            claim++;
            int successes = 0;
            for(int i=0;i<10000;i++)
            {
                int total = quantity;
                for(int j=0;j<(players-1)*5;j++)
                {
                    int roll = (int)(Math.random()*6)+1;
                    if(roll==1||roll==value){
                        total++;
                    }
                }
                if(total>=claim){
                    successes++;
                }
            }
            probability=(successes/100);
        }
        System.out.println(claim-1+" "+value);
    }
}