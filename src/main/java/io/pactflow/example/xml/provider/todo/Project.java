package io.pactflow.example.xml.provider.todo;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class Project {
  @JacksonXmlProperty(isAttribute = true)
  int id;

  @JacksonXmlProperty(isAttribute = true)
  String type;

  @JacksonXmlProperty(isAttribute = true)
  String name;

  @JacksonXmlProperty(isAttribute = true)
  String due;

  @JacksonXmlProperty(localName = "task")
  @JacksonXmlElementWrapper(useWrapping = true, localName = "tasks")
  List<Task> tasks = new ArrayList<Task>();
}
