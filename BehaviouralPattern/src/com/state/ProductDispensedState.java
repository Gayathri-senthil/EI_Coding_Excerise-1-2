package com.state;
public class ProductDispensedState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public ProductDispensedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Please wait. Product is being dispensed.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product already selected. Dispensing product.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product dispensed. Thank you!");
        vendingMachine.setState(vendingMachine.getNoMoneyState());
    }
}
