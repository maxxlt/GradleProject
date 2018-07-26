package ru.maxlt.javalib;

import java.util.Random;

public class JavaJoker {
    String[] jokeArray = new String[4];

    public String getJoke(){
        jokeArray[0]= "How do functions break up? \"They stop calling each other!\"";
        jokeArray[1] = "In what unit do you measure a function's length? \"In Para meters...\"";
        jokeArray[2] = "What did the flirtatious function say? \"Call me ;)\"";
        jokeArray[3] = "Q: How do you tell an introverted computer scientist from an extroverted computer scientist?\n" +
                "\n" +
                "A: An extroverted computer scientist looks at your shoes when he talks to you.";
        return jokeArray[new Random().nextInt(jokeArray.length)];
    }
}
