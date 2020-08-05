package io.pactflow.example.xml.todo;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class Project {
  @JacksonXmlProperty(isAttribute = true)
  private int id;

  @JacksonXmlProperty(isAttribute = true)
  private String type;

  @JacksonXmlProperty(isAttribute = true)
  private String name;

  @JacksonXmlProperty(isAttribute = true)
  private String due;

  @JacksonXmlProperty(localName = "task")
  @JacksonXmlElementWrapper(useWrapping = true, localName = "tasks")
  private List<Task> tasks = new ArrayList<Task>();
}
