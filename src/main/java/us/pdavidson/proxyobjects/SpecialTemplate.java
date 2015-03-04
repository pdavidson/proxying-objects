package us.pdavidson.proxyobjects;

import java.util.Random;

public class SpecialTemplate {
    Random random = new Random();
    private final String name;

    public SpecialTemplate(String name){
        this.name = name;
    }


    public void logName(){
        System.out.println("My name is " + name);
    }

    public String whatsMyName() {
        return name;
    }

    public Boolean couldWeBeFriends(String otherName){
        return random.nextBoolean();
    }

}
