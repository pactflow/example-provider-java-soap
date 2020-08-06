package io.pactflow.example.xml.todo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "projects", namespace = "http://some.namespace/and/more/stuff")
public class Projects {
  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "project")
  private List<Project> projects = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "foo")
  private List<Foo> foos = new ArrayList<>();

  @JacksonXmlProperty(isAttribute = true)
  private String id;
}
