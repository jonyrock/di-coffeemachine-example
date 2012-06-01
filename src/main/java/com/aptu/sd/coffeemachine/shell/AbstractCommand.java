package com.aptu.sd.coffeemachine.shell;

import com.aptu.sd.coffeemachine.machine.VendingMachine;

public abstract class AbstractCommand {
    protected VendingMachine machine;

    public AbstractCommand(VendingMachine machine) {
        this.machine = machine;
    }
}
