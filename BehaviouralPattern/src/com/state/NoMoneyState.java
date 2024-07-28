package com.state;

public class NoMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money inserted. You can now select a product.");
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void selectProduct() {
        System.out.println("Please insert money first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please insert money first.");
    }
}
