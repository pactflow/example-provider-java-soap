package io.pactflow.example.xml.provider.todo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

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
