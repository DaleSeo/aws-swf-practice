package helloWorld.HelloWorldWorkflowParallel;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class GreeterWorkflowImpl implements GreeterWorkflow {
    private GreeterActivitiesClient operations = new GreeterActivitiesClientImpl();

    @Override
    public void greet() {
        Promise<String> name = operations.getName();
        Promise<String> greeting = operations.getGreeting();
        operations.say(greeting, name);
    }
}
