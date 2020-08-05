package  io.pactflow.example.xml.todo;

class ProductNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 8087803211710068858L;

  ProductNotFoundException(Long id) {
    super("Could not find product " + id);
  }
}