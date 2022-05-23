package example;

import annotations.Test;

public class TestClass {

    @Test
    public static void Method1() {
        throw new RuntimeException("Here comes a crash! BOOM!");
    }

    public static void Method2() {
    }

    @Test
    public static void Method3() {
        throw new RuntimeException("Another crash!");
    }

    public static void Method4() {
    }

    @Test
    public static void Method5() {

    }

    public static void Method6() {
    }

    @Test
    public static void Method7() {

    }

    public static void Method8() {
        throw new RuntimeException("You've done it again!");
    }
}