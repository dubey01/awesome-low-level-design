package vendingmachine;

public class DispenseState implements VendingMachineState {
    private final VendingMachine vendingMachine;
    // VendingMachine object to perform its related specific functions
    
    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already made. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setState(vendingMachine.getReadyState());

        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState()); // Change the state to ReturnChangeState
        // as soon as the product is dispensed, the vending machine moves to returnChangeState and starts performing other function to calculate the change that 
        // needs to be returned if any.
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the dispensed product first.");
    }
}
