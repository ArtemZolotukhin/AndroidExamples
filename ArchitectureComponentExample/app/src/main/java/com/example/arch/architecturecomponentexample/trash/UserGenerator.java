package com.example.arch.architecturecomponentexample.trash;

import java.util.Random;

/**
 * Created by arch on 6/20/17.
 */

public class UserGenerator {

    private static String[] names = {"Artem", "Boris", "Viktor", "Gena", "Dima", "Egor", "Jena", "Igor", "Kolya"};

    public static User generate(){
        return new User(names[new Random(System.currentTimeMillis()).nextInt(names.length)],
                new Random(System.currentTimeMillis()).nextInt(90) + 10);
    }

}
