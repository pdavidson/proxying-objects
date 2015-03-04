package us.pdavidson.proxyobjects;

import java.util.Random;
import java.util.stream.IntStream;

public class Application {
    private static final Random random = new Random();
    private final SpecialTemplate specialTemplate1;
    private final SpecialTemplate specialTemplate2;
    private SpecialTemplate specialTemplate;
    public static void main(String[] args) {
        final Application application = new Application();
        int max = 10;
        IntStream.range(0, max)
                .forEach(value -> {
                    System.out.println("-------- Looping " + (value + 1) + " of " + max + " ------------" );
                    application.electNewLeader();
                    application.exerciseTemplate();
                });

    }


    public Application() {
        this.specialTemplate1 = new SpecialTemplate("Lebron James");
        this.specialTemplate2 = new SpecialTemplate("Barry Melrose");

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
