package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:35 PM.
 */
public class HasCard implements AtmState {

    AtmMachine atmMachine;

    public HasCard(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You can only insert one card at a time");
    }

    @Override
    public void ejectCard() {
        System.out.println("Your card is ejected");
        atmMachine.setAtmState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinEntered) {
        if (pinEntered == 123456) {
            System.out.println("You entered the correct PIN");
            atmMachine.correctPinEntered = true;
            atmMachine.setAtmState(atmMachine.getHasPin());
        } else {
            System.out.println("You entered the wrong PIN");
            atmMachine.correctPinEntered = false;
        }
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("You have not entered your PIN");
    }

    @Override
    public String toString() {
        return "Has Card";
    }
}
