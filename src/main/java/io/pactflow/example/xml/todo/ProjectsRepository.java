package io.pactflow.example.xml.todo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProjectsRepository {
  private Projects projects;
}