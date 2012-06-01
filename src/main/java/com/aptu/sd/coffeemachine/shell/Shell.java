package com.aptu.sd.coffeemachine.shell;

import com.aptu.sd.coffeemachine.machine.BrokenMachine;
import com.aptu.sd.coffeemachine.machine.VendingMachine;
import com.google.inject.Inject;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: andrey
 * Date: 5/22/12, 11:41 PM
 */
public class Shell {
    private Map<String, Class<? extends Command>> commands = new HashMap<String, Class<? extends Command>>();
    private VendingMachine machine;
    private VendingMachine toSwitchMachine;
    
    public Shell(){
        toSwitchMachine = new BrokenMachine();
    }
    
    @Inject
    public void setCommands(List<Class<? extends Command>> commands) {
        for (Class<? extends Command> command : commands) {
            this.commands.put(command.getClass().getSimpleName().toLowerCase(), command);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (true) {
            String line = scanner.next();
            String[] split = line.split("\\s");
            if (split.length == 0) {
                continue;
            }
            String cmdName = split[0];
            Class<? extends Command> command = commands.get(cmdName);
            if (command == null) {
                System.out.println("Unknown command: " + cmdName);
                continue;
            }
            
            String[] args = Arrays.copyOfRange(split, 1, split.length);
            try {
                Command cmd = (Command)command.getConstructors()[0].newInstance(machine);
                
                //command.execute(args, machine);
            } catch (Exception e) {
                System.out.println("Invalid " + cmdName + " arguments: " + StringUtils.join(args, " "));
            }


        }
    }

    @Inject
    public void setMachine(VendingMachine machine) {
        this.machine = machine;
    }
    
    private void switchMachine(){
        VendingMachine t = machine;
        machine = toSwitchMachine;
        toSwitchMachine = t;
    } 
    
}
