package com.aptu.sd.coffeemachine.machine;

public class BrokenMachine implements VendingMachine  {

    public void deposit(long amount) throws NonPositiveDepositException {}

    public long cancel() { return -1; }

    public void purchaseProduct(String productName) throws NoSuchProductException, DepositTooSmallException {}
}
