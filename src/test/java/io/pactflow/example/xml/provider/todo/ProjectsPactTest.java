package io.pactflow.example.xml.provider.todo;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

import java.io.IOException;

import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Provider("pactflow-example-provider-java-soap")
//@PactBroker(scheme = "https", host = "${PACT_BROKER_HOST}", tags = {"master", "prod"},
//  authentication = @PactBrokerAuth(token = "${PACT_BROKER_TOKEN}"))
@PactFolder("/home/ronald/Development/Projects/Pact/xml/example-consumer-java-soap/build/pacts")
class ProductsPactTest {

  @Autowired
  ProjectsRepository repository;

  @BeforeEach
  public void setupTestTarget(PactVerificationContext context) {
    context.setTarget(new HttpTestTarget("localhost", 8080));

//    System.setProperty("pact.provider.version", System.getenv("TRAVIS_COMMIT") == null ? "" : System.getenv("TRAVIS_COMMIT"));
//    System.setProperty("pact.provider.tag", System.getenv("TRAVIS_BRANCH") == null ? "" : System.getenv("TRAVIS_BRANCH"));
//    System.setProperty("pact.verifier.publishResults", System.getenv("PACT_BROKER_PUBLISH_VERIFICATION_RESULTS") == null ? "false" : "true");
  }

  @TestTemplate
  @ExtendWith(PactVerificationInvocationContextProvider.class)
  public void pactVerificationTestTemplate(PactVerificationContext context) {
    context.verifyInteraction();
  }

  @State("i have a list of projects")
  public void setupProductX010000021() throws IOException {
    System.out.println("a product with ID 10 exists");
    Project project = new Project();
    project.id = 10;
    project.name = "test";
    project.due = "2020-11-12T12:00:00.000+11:00";
    project.type = "activity";
    Task task = new Task();
    task.done = true;
    task.name = "Task 1";
    project.tasks.add(task);
    repository.add(project);
  }
}
