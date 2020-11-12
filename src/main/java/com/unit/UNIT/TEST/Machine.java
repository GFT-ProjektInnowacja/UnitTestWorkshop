package com.unit.UNIT.TEST;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Machine {

    public static final int WINNING_NUMBER = 7;
    public List<Integer> gameSigns;
    public int bankAmount = 10000;
//    public Validator validator;

    public Machine(/*Validator validator*/){
 //       this.validator = validator;
    }

    public void insertCoin(Money money) {
 //       if (validator.validateMoney(money)) {
            bankAmount = bankAmount + money.value;
            startGame();
/*      } else {
            System.out.println("Invalid Coin");
        }*/

    }

    public void startGame() {
        generateThreeSigns();
        if (checkWin()) {
            winInfo();
        } else {
            loseInfo();
        }
    }

    public void generateThreeSigns() {
        Random random = new Random();
        gameSigns = random.ints(5, 0, 9).boxed().collect(Collectors.toList());
    }

    public boolean checkWin() {
        return gameSigns.stream().allMatch(u -> u.equals(WINNING_NUMBER));
    }

    public void winInfo() {
        bankAmount = 0;
        System.out.println("wygrałeś 10k Smoczych monet wymiennych na euro gąbki.");
    }

    public void loseInfo() {
        System.out.println("Spróbuj ponownie.");
    }
}
