package io.pactflow.example.xml.provider.todo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Task {
  @JacksonXmlProperty(isAttribute = true)
  int id;

  @JacksonXmlProperty(isAttribute = true)
  String name;

  @JacksonXmlProperty(isAttribute = true)
  Boolean done;
}
