package us.pdavidson.proxyobjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import java.util.stream.IntStream;

@Import(AppConfig.class)
public class Application implements CommandLineRunner{

    @Autowired
    Exerciser exerciser;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        final Application application = new Application();
        int max = 10;
        IntStream.range(0, max)
                .forEach(value -> {
                    System.out.println("-------- Looping " + (value + 1) + " of " + max + " ------------" );
                    exerciser.electNewLeader();
                    exerciser.exerciseTemplate();
                });
    }
}
