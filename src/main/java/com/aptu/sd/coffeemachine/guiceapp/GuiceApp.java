package com.aptu.sd.coffeemachine.guiceapp;

import com.aptu.sd.coffeemachine.shell.Shell;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by IntelliJ IDEA.
 * User: andrey
 * Date: 5/23/12, 10:07 AM
 */
public class GuiceApp {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        Shell shell = injector.getInstance(Shell.class);
        shell.run();
    }
}
