package us.pdavidson.proxyobjects;

import java.util.Random;

public class Exerciser {
    private static final Random random = new Random();

    private final SpecialTemplate specialTemplate1;
    private final SpecialTemplate specialTemplate2;

    private SpecialTemplate specialTemplate;


    public Exerciser(SpecialTemplate specialTemplate2,
                     SpecialTemplate specialTemplate1) {
        this.specialTemplate2 = specialTemplate2;
        this.specialTemplate1 = specialTemplate1;

        this.electNewLeader();
    }

    public void electNewLeader() {
        if (random.nextBoolean()) {
            specialTemplate = specialTemplate1;
        } else {
            specialTemplate = specialTemplate2;
        }
    }

    public void exerciseTemplate() {
        specialTemplate.logName();
        System.out.println("What's My name? " + specialTemplate.whatsMyName());
        Boolean couldWeBeFriends = specialTemplate.couldWeBeFriends("Jerry Jones");
        if (couldWeBeFriends){
            System.out.println(specialTemplate.whatsMyName() + " could be friends with Jerry Jones");
        } else {
            System.out.println(specialTemplate.whatsMyName() + " couldn't be friends with Jerry Jones");
        }
    }

}
