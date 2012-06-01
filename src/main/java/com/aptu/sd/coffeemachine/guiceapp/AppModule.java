package com.aptu.sd.coffeemachine.guiceapp;

import com.aptu.sd.coffeemachine.machine.Product;
import com.aptu.sd.coffeemachine.machine.SimpleMachine;
import com.aptu.sd.coffeemachine.machine.VendingMachine;
import com.aptu.sd.coffeemachine.shell.*;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: andrey
 * Date: 5/23/12, 10:03 AM
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(VendingMachine.class).to(SimpleMachine.class);
        List<Product> products = Arrays.asList(new Product("capuccino", 4, 10), new Product("latte", 6, 15));
        bind(new TypeLiteral<List<Product>>() {}).toInstance(products);

        List<Command> commands = Arrays.asList(new Insert(), new Select(), 
                new Cancel(), new Exit(), new TakeCash());
        bind(new TypeLiteral<List<Command>>() {}).toInstance(commands);
    }
}
