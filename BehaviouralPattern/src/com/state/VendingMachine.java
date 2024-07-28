package com.state;
public class VendingMachine {
    private VendingMachineState noMoneyState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState productDispensedState;

    private VendingMachineState currentState;

    public VendingMachine() {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        productDispensedState = new ProductDispensedState(this);

        currentState = noMoneyState;
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public VendingMachineState getNoMoneyState() {
        return noMoneyState;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getProductDispensedState() {
        return productDispensedState;
    }

    public void insertMoney() {
        currentState.insertMoney();
    }

    public void selectProduct() {
        currentState.selectProduct();
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }
}
