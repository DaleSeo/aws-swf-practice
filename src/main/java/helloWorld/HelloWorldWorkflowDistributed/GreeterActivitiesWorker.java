package helloWorld.HelloWorldWorkflowDistributed;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

public class GreeterActivitiesWorker {
    public static void main(String[] args) throws Exception  {
        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient();
        service.setEndpoint("https://swf.us-west-2.amazonaws.com");

        String domain = "helloWorldWalkthrough";
        String taskListToPoll = "HelloWorldAsyncList";

        WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
        wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
        wfw.start();
    }
}
