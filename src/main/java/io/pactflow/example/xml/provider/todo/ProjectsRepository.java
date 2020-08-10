package io.pactflow.example.xml.provider.todo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProjectsRepository {
  private Projects projects;

  public void add(Project project) {
    projects.add(project);
  }
}