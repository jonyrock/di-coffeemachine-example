package com.aptu.sd.coffeemachine.shell;

import com.aptu.sd.coffeemachine.machine.VendingMachine;

/**
 * Created by IntelliJ IDEA.
 * User: andrey
 * Date: 5/22/12, 11:58 PM
 */
public class Cancel extends AbstractCommand {
    public Cancel(VendingMachine m) {
        super(m);
    }

    public void execute(String[] args) {
        long amount = machine.cancel();
        System.out.println("Returned: " + amount);
    }
}
