package example;

import annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

public class Main {
    public static void main( String[] args ) throws Exception
    {
        ClassLoader classLoader = new ClassLoader();
        int passed = 0;
        int failed = 0;

        String pathForClass = "C:/Users/ciobo/Desktop/facultate/an_2/sem_2/PA/Laboratoare/PA_2022_2B4_CIOBOTARU_COSMIN/Lab12/src/main/java/UserController.class";
        System.out.println("The path for the class: " + pathForClass);


        File pathClass = new File(pathForClass);
        if (pathClass.exists()) {
            URL urlClass = pathClass.toURI().toURL();
            classLoader.addURL(urlClass);
        }


        for(Method method : classLoader.loadClass("example.TestClass").getMethods()){
            System.out.print(method.getReturnType() + " " + method.getName() + "(");
            boolean first = true;
            for (var i : method.getParameters()) {
                if (first) {
                    System.out.print(i.getType().toGenericString() + " " + i.getName());
                    first = false;
                } else {
                    System.out.print(", " + i.getType().toGenericString() + " " + i.getName());
                }
            }
            System.out.print(");"+"\n");
        }
        System.out.println();
        for (Method method : classLoader.loadClass("example.TestClass").getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Throwable throwable) {
                    System.out.printf("Test %s failed: %s  %n", method, throwable.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);

    }

}