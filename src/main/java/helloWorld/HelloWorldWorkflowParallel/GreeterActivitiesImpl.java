package helloWorld.HelloWorldWorkflowParallel;

public class GreeterActivitiesImpl implements GreeterActivities {
    @Override
    public String getName() {
        return "World!";
    }

    @Override
    public String getGreeting() {
        return "Hello ";
    }

    @Override
    public void say(String greeting, String name) {
        System.out.println(greeting + name);
    }
}
