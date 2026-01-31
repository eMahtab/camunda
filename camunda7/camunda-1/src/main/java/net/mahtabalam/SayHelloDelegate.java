package net.mahtabalam;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SayHelloDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Hello from Camunda 7 Process!");
        System.out.println("Process Instance ID: " + execution.getProcessInstanceId());
    }
}