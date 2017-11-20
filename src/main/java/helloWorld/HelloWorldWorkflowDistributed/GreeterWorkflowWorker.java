package helloWorld.HelloWorldWorkflowDistributed;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;

public class GreeterWorkflowWorker {
    public static void main(String[] args) throws Exception {
        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient();
        service.setEndpoint("https://swf.us-west-2.amazonaws.com");

        String domain = "helloWorldWalkthrough";
        String taskListToPoll = "HelloWorldAsyncList";

        ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
        aw.addActivitiesImplementation(new GreeterActivitiesImpl());
        aw.start();
    }
}
