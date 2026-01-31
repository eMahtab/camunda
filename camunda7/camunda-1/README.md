# Simple Camunda APP, implementing JavaDelegate

A simple Camunda process, with just one simple delegate.

JavaDelegate is an interface in Camunda 7 that allows you to execute custom Java code within a Service Task in your BPMN process.

```java
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SayHelloDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Hello from Camunda 7 Process!");
        System.out.println("Process Instance ID: " + execution.getProcessInstanceId());
    }
}
```
We deploy the BPMN and start the process instance.

### Output
```declarative
Process deployed successfully!
Hello from Camunda 7 Process!
Process Instance ID: 4
Process instance started: 4
Process completed: true
```
