package io.pactflow.example.xml.provider.todo;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProjectsFixture {
  public static Projects sampleProjects() {
    Task task = new Task();
    task.setName("Task 1");
    task.setDone(true);
    task.setId(1001);

    List<Task> taskList = new ArrayList<Task>();
    taskList.add(task);

    Project p = new Project();
    p.setName("Project Test");
    p.setDue(OffsetDateTime.now().toString());
    p.setType("activity");
    p.setId(100);
    p.setTasks(taskList);

    List<Project> projectsList = new ArrayList<Project>();
    projectsList.add(p);
    // This won't work until the XML Builder in Pact-JVM is fixed to allow matchers on the root element
    //    Projects projects = Projects.of(RandomStringUtils.randomNumeric(4));
    Projects projects = Projects.of("1234");
    projects.setProjects(projectsList);

    // To show that extra elements are just ignored
    projects.setFoos(List.of(new Foo("baz")));

    return projects;
  }
}
