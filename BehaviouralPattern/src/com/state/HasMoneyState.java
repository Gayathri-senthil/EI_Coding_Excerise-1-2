package com.state;

public class HasMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money already inserted. Please select a product.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected. Dispensing product.");
        vendingMachine.setState(vendingMachine.getProductDispensedState());
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first.");
    }
}
