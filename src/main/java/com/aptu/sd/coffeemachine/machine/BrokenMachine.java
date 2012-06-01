package com.aptu.sd.coffeemachine.machine;

public class BrokenMachine implements VendingMachine  {

    public void deposit(long amount) throws NonPositiveDepositException {
        System.out.println("Broken");
    }

    public long cancel() {
        System.out.println("Broken");
        return -1; 
    }

    public void purchaseProduct(String productName) throws NoSuchProductException, DepositTooSmallException {
        System.out.println("Broken");
    }
}
