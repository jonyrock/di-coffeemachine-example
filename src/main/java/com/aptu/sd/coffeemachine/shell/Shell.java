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
    private Map<String, String> commands = new HashMap<String, String>();
    private List<CommandName> initCommandNames;
    private VendingMachine machine;
    private VendingMachine toSwitchMachine;

    public Shell() {
        toSwitchMachine = new BrokenMachine();
    }

    @Inject
    public void setCommands(List<String> commands) {
        for (String  command : commands) {
            this.commands.put(command.toLowerCase(), command);
        }
    }

    public void setInitCommandNames(List<CommandName> commands) {
        for (CommandName command : commands) {
            this.commands.put(command.getName().toLowerCase(), command.getName());
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
            if (cmdName.toLowerCase().equals("switch")) {
                switchMachine();
                continue;
            }
            Command command = commandsFabric(cmdName);
            if (command == null) {
                System.out.println("Unknown command: " + cmdName);
                continue;
            }

            String[] args = Arrays.copyOfRange(split, 1, split.length);
            try {
                command.execute(args);
            } catch (CommandParseException e) {
                System.out.println("Invalid " + cmdName + " arguments: " + StringUtils.join(args, " "));
            } catch (Exception e) {
                System.out.println("Can't create command. System error.");
            }


        }
    }

    @Inject
    public void setMachine(VendingMachine machine) {
        this.machine = machine;
    }

    private void switchMachine() {
        VendingMachine t = machine;
        machine = toSwitchMachine;
        toSwitchMachine = t;
    }

    private Command commandsFabric(String cmdName) {

        try {
            String name = commands.get(cmdName);
            Class<?> command = Class.forName("com.aptu.sd.coffeemachine.shell." + name);
            return (Command) command.getConstructors()[0].newInstance(machine);
        } catch (Exception e) {
            return null;
        }

    }

}
