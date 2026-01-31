package net.mahtabalam;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public class CamundaApplication {

    public static void main(String[] args) {
        // Create Process Engine
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createStandaloneInMemProcessEngineConfiguration()
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .setJdbcUrl("jdbc:h2:mem:camunda;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setJobExecutorActivate(true)
                .buildProcessEngine();

        System.out.println("Camunda Process Engine created successfully!");

        // Deploy Process
        processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("simple-process.bpmn")
                .deploy();

        System.out.println("Process deployed successfully!");

        // Start Process Instance
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("simple-process");

        System.out.println("Process instance started: " + processInstance.getId());
        System.out.println("Process completed: " + processInstance.isEnded());

        // Close engine
        processEngine.close();
    }
}