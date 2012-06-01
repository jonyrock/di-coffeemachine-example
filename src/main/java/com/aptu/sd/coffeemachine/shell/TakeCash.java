package com.aptu.sd.coffeemachine.shell;

import com.aptu.sd.coffeemachine.machine.VendingMachine;

public class TakeCash implements Command {
    public void execute(String[] args, VendingMachine machine) {
        long amount = machine.cancel();
        System.out.println("Took: " + amount);
    }
}
