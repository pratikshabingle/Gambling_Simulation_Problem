package com.Gamblingsimulation;

import java.util.Scanner;
public class Gambing {

    float stake = 100;
    float currentStake=0;
    int bettingAmount = 1;
    float percent;
    float win_amount = 0;
    float loss_amount = 0;
    int counter= 0;
    int daysWon = 0;
    int daysLost = 0;

    // checking for winning or losing
    public void betGenerator () {

        int bet = (int) Math.floor(Math.random() * 10) % 2;
        if(bet == 1){
            System.out.println("\n");
            System.out.println("You have won the bet");
            currentStake=currentStake+bettingAmount;
        }
        else {
            System.out.println("\n");
            System.out.println("You have lost the bet ");
            currentStake=currentStake-bettingAmount;
        }
        System.out.println("Your current stake is: " + currentStake);
    }


    boolean resignCondition()

    {

        percent = (stake * 50) / 100;
        float difference = Math.abs(currentStake - stake);
        return difference == percent;
    }


    void betSave()
    {
        if(currentStake > stake)
        {
            win_amount = win_amount + (currentStake-stake);
            daysWon = daysWon + 1;
            System.out.println(" The win amount of day " + daysWon + " is: " + daysWon);

        }
        else
        {
            loss_amount = loss_amount + (stake-currentStake);
            daysLost = daysLost + 1;

        }

        stake = currentStake = 100;
        counter++;
        System.out.println("The number of days you betted: "+counter);
        System.out.println("The days you won in a month is :" +daysWon);
        System.out.println("Total gain amount is:" +win_amount);
        System.out.println("The days you lost in a month is :" +daysLost);
        System.out.println("Total loss amount is:" +loss_amount);
    }


    public static void main(String[] args) {

        Gambing g1 = new Gambing();

        Scanner sc = new Scanner(System.in);

        while (g1.counter < 20) {
            while (!g1.resignCondition()) {
                g1.betGenerator();
            }
            System.out.println(" The bet has reached the resign conditon ...so further no play");
            g1.betSave();
	  }
	}
}
