package us.pdavidson.proxyobjects;

public class Exerciser {


    private SpecialTemplate specialTemplate;
    private final RoutingInvokerHandler routingInvokerHandler;

    public Exerciser(SpecialTemplate specialTemplate, RoutingInvokerHandler routingInvokerHandler) {
        this.specialTemplate = specialTemplate;
        this.routingInvokerHandler = routingInvokerHandler;
        this.electNewLeader();
    }

    public void electNewLeader() {
        routingInvokerHandler.electNewLeader();
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
