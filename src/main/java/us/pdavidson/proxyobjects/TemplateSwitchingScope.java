package us.pdavidson.proxyobjects;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Random;

public class TemplateSwitchingScope implements Scope {
    private static final Random random = new Random();
    private final SpecialTemplate[] templates;
    private SpecialTemplate leader;

    public TemplateSwitchingScope(SpecialTemplate ... templates) {
        this.templates = templates;

        electNewLeader();
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return leader;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    public void electNewLeader() {
        int index = Math.abs(random.nextInt()) % templates.length;
        leader = templates[index];
    }
}
