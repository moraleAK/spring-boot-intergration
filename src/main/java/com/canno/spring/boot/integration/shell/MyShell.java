package com.canno.spring.boot.integration.shell;

/**
 * @author CannoGcc
 * @since 2018/7/9 19:03
 */
//@ShellComponent
public class MyShell {
//    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }

//    @ShellMethod("Calculate two integers product.")
    public int product(int a, int b) {
        return a * b;
    }

//    @ShellMethod("Zoo shout.")
    public String zoo(String zooName) {
        switch (zooName) {
            case "cat":
                return "喵喵喵";
            case "dog":
                return "汪汪汪";
            default:
                return "emmmmmmm";
        }
    }


}
