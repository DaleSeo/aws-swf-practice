package helloWorld.HelloWorldWorkflowParallel;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version = "5.0")
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300, defaultTaskStartToCloseTimeoutSeconds = 10)
public interface GreeterActivities {
    String getName();
    String getGreeting();
    void say(String greeting, String name);
}
