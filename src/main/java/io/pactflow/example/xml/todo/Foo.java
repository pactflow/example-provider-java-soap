package io.pactflow.example.xml.todo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class Foo {
  public Foo(String bar) {
    this.bar = bar;
  }

  @JacksonXmlProperty(isAttribute = true)
  private String bar;
}
