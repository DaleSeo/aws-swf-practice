package helloWorld.HelloWorldWorkflowDistributed;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import helloWorld.HelloWorldWorkflowAsync.GreeterWorkflowClientExternal;
import helloWorld.HelloWorldWorkflowAsync.GreeterWorkflowClientExternalFactory;
import helloWorld.HelloWorldWorkflowAsync.GreeterWorkflowClientExternalFactoryImpl;

/**
 * Workflow Starter
 */
public class GreeterMain {
    public static void main(String[] args) {
        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient();
        service.setEndpoint("https://swf.us-west-2.amazonaws.com");

        String domain = "helloWorldWalkthrough";

        GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(service, domain);
        GreeterWorkflowClientExternal greeter = factory.getClient("someID");
        greeter.greet();
    }
}
