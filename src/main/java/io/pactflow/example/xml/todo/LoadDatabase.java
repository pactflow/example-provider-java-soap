package io.pactflow.example.xml.todo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ProjectsRepository repository) {
    Task task = new Task();
    task.setName("Task 1");
    task.setDone(true);
    task.setId(100);

    List<Task> taskList = new ArrayList<Task>();
    taskList.add(task);

    Project p = new Project();
    p.setName("Project 1");
    p.setDue("2016-02-11T09:46:56.023Z");
    p.setType("activity");
    p.setId(100);
    p.setTasks(taskList);


    List<Project> projectsList = new ArrayList<Project>();
    projectsList.add(p);
    Projects projects = new Projects();
    projects.setProjects(projectsList);
    projects.setId("1234");

    // To show that extra elements are just ignored
    List<Foo> foos = new ArrayList<Foo>();
    foos.add(new Foo("baz"));
    projects.setFoos(foos);

    return args -> {
      log.info("Preloading projets");
      repository.setProjects(projects);
    };
  }
}