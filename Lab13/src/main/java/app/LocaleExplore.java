package app;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;

import static java.lang.System.exit;

public class LocaleExplore {
    Properties commands = new Properties();
    public void start() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        //folosesc un fisier de proprietati Locales.properties pentru a putea apela clasele comenzilor
        commands.load(this.getClass().getClassLoader().getResourceAsStream("Locales.properties"));
        //setez pe limba engleza, pt romana vom folosi ro-RO
        CommandsLocale.setLocale("en-US");
        Scanner scanner = new Scanner(System.in);//pentru citirea comenzilor de la tastatura
        while (true) {
            System.out.print(CommandsLocale.message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("Exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "DisplayLocales" : {
                    Class clazz = Class.forName(commands.getProperty("display-locale.impl"));
                    clazz.getConstructor().newInstance();
                    break;
                }
                case "SetLocale" : {
                    Class clazz = Class.forName(commands.getProperty("set-locale.impl"));
                    clazz.getConstructor(String.class).newInstance(params[1]);
                    break;
                }
                case "Info" : {
                    Class clazz = Class.forName(commands.getProperty("info-locale.impl"));
                    clazz.getConstructor().newInstance();
                    break;
                }
                case "Stop" : {
                    System.out.println("Program stopped!");
                    exit(1);
                }
                default : System.out.println(CommandsLocale.message("invalid"));

            }
        }
    }


    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        new LocaleExplore().start();
    }
}