import java.util.*;
public class PokerDice {
    public static void main(String[] args) {
        //Initializing counts for each hand
        double none = 0;
        double  pair = 0;
        double twop = 0;
        double  threep = 0;
        double  full = 0;
        double fourp = 0;
        double fivep = 0;
        //Runs million times
        for (int i = 0; i<=1000000; i++) {
            //Sets rolls of each dice in an array
            int [] rolls = new int[5];
            rolls[0] = (int)(1 + (Math.random()*(6)));
            rolls[1] = (int)(1 + (Math.random()*(6)));
            rolls[2] = (int)(1 + (Math.random()*(6)));
            rolls[3] = (int)(1 + (Math.random()*(6)));
            rolls[4] = (int)(1 + (Math.random()*(6)));
            //Returns the array passed from counts method which contains counts of each number rolled
            int [] counts = Counts(rolls);
            int length = counts.length;
            int hand = 0;
            //Logic for case 7
            for (int j = 0; j < length; j++) {
                if (counts[j] == 5) {
                    hand = 7;
                } 
            }
            //Logic for case 6
            if (hand < 7) {
                for (int j = 0; j < length; j++) {
                    if (counts[j] == 4) {
                        hand = 6;
                    } 
                }
            }
            //Logic for case 5
            if (hand < 6) {
                int counter3 = 0;
                int counter2 = 0;
                for (int j = 0; j < length; j++) {
                     if (counts[j] == 3) {
                        counter3++;
                     }
                     if (counts [j] == 2) {
                        counter2++;
                     } 
                }
                if (counter3 == 1 && counter2 == 1) {
                    hand = 5;
                }
            }
            //Logic for case 4
            if (hand < 5) {
                for (int j = 0; j < length; j++) {
                    if (counts[j] == 3) {
                        hand = 4;
                    } 
                }
            }
            //Logic for case 3 and 2
             if (hand < 4) {
                int newcounter = 0;
                for (int j = 0; j < length; j++) {
                    if (counts[j] == 2) {
                       newcounter++;
                    }
                }
                    if (newcounter == 2) {
                        hand = 3;
                    } else if (newcounter == 1) {
                        hand = 2;
                    }
              if (newcounter==1) {
                hand = 2;
              }
            }
            //Logic for case 1
            if (hand < 2) {
                 hand = 1;
            }   
            //Sets case to plus one inside loop
            if (hand == 7) {
                 fivep++;
            }
            if (hand == 6) {
                fourp++;
            }
            if (hand == 5) {
                full++;
            }
            if (hand == 4) {
                threep++;
            }
            if (hand == 3) {
                twop++;
            }
            if (hand == 2) {
                pair++;
            }
            if (hand == 1) {
                none++;
            }
        }
       //Calculates percentages after 1000000 loops
        fivep/=1000000;
        fourp/=1000000;
        full/=1000000;
        threep/=1000000;
        twop/=1000000;
        pair/=1000000;
        none/=1000000;
        //Prints results
        System.out.println("Poker Dice Probability Calculator - Ayush Gaur");
        System.out.println("Running 1,000,000 trials");
        System.out.println();
        System.out.println("Case 1, None alike, is "+none);
        System.out.println("Case 2, One pair, is "+pair);
        System.out.println("Case 3, Two pair, is "+twop);
        System.out.println("Case 4, Three of a kind, is "+threep);
        System.out.println("Case 5, Full House, is "+full);
        System.out.println("Case 6, Four of a kind, is "+fourp);
        System.out.printf("Case 7, Five of a kind, is %f",fivep);    
        System.out.println();
    }
    public static int[] Counts (int [] rolled) {
       //This method is in charge of figuring out how much of each number are rolled 
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int len = rolled.length;
        int [] rolltimes = new int[6];
        //These loops add up how many of each number were rolled in the 5 dice
        for (int i = 0; i<len; i++) {
            if (rolled [i] == 1) {
                one++;
            }
             else if (rolled [i] == 2) {
                two++;
            }
            else if (rolled [i] == 3) {
                three++;
            }
            else if (rolled [i] == 4) {
                four++;
            }
            else if (rolled [i] == 5) {
                five++;
            }
            else if (rolled [i] == 6) {
                six++;
            }
        }
        //The values from the if statemtns are put into an array rolltimes
        rolltimes[0] = one;
        rolltimes[1] = two;
        rolltimes[2] = three;
        rolltimes[3] = four;
        rolltimes[4] = five;
        rolltimes[5] = six;
        return rolltimes;
    }
}