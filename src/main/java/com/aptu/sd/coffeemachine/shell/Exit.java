package com.aptu.sd.coffeemachine.shell;

import com.aptu.sd.coffeemachine.machine.VendingMachine;

/**
 * Created by IntelliJ IDEA.
 * User: andrey
 * Date: 5/23/12, 12:40 AM
 */
public class Exit extends AbstractCommand {
    public Exit(VendingMachine m){
        super(m);
    }
    public void execute(String[] args) throws CommandParseException {
        System.exit(0);
    }
}
