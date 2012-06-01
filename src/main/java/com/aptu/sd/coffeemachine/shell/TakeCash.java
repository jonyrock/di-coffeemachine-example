package com.aptu.sd.coffeemachine.shell;

import com.aptu.sd.coffeemachine.machine.VendingMachine;

public class TakeCash extends AbstractCommand {
    public TakeCash(VendingMachine m){
        super(m);
    }
    public void execute(String[] args) {
        long amount = machine.cancel();
        System.out.println("Took: " + amount);
    }
}
