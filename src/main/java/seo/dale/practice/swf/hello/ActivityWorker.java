package seo.dale.practice.swf.hello;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClientBuilder;
import com.amazonaws.services.simpleworkflow.model.*;

public class ActivityWorker {
    private static final AmazonSimpleWorkflow swf = AmazonSimpleWorkflowClientBuilder.defaultClient();

    private static String sayHello(String input) throws Throwable {
        return "Hello, " + input + "!";
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Polling for an activity task from the tasklist '" + HelloTypes.TASKLIST + "' in the domain '" + HelloTypes.DOMAIN + "'.");

            ActivityTask task = swf.pollForActivityTask(
                    new PollForActivityTaskRequest()
                            .withDomain(HelloTypes.DOMAIN)
                            .withTaskList(new TaskList().withName(HelloTypes.TASKLIST)));

            String task_token = task.getTaskToken();

            if (task_token != null) {
                String result = null;
                Throwable error = null;

                try {
                    System.out.println("Executing the activity task with input '" + task.getInput() + "'.");
                    result = sayHello(task.getInput());
                } catch (Throwable th) {
                    error = th;
                }

                if (error == null) {
                    System.out.println("The activity task succeeded with result '" + result + "'.");
                    swf.respondActivityTaskCompleted(
                            new RespondActivityTaskCompletedRequest()
                                    .withTaskToken(task_token)
                                    .withResult(result));
                } else {
                    System.out.println("The activity task failed with the error '" + error.getClass().getSimpleName() + "'.");
                    swf.respondActivityTaskFailed(
                            new RespondActivityTaskFailedRequest()
                                    .withTaskToken(task_token)
                                    .withReason(error.getClass().getSimpleName())
                                    .withDetails(error.getMessage()));
                }


            }
        }
    }
}
