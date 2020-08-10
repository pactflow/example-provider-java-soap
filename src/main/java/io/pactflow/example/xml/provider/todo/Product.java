package io.pactflow.example.xml.provider.todo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Data
@Entity
@JacksonXmlRootElement(localName = "Product")
class Product {
  @JacksonXmlProperty(isAttribute = true)
  private @Id Long id;
  @JacksonXmlProperty
  private String name;
  @JacksonXmlProperty
  private String type;

  Product() {}

  Product(Long id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }
}
