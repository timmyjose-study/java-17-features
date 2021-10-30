public class Demo {
  public static void main(String[] args) {
    System.out.println(42);
    System.out.println("hello");
    System.out.println(4.2);
    System.out.println(true);
    System.out.println(new Foo());

    testFooBar(null);
    testFooBar("Foo");
    testFooBar("Hola");

    matchStringOrNull(null);
    matchStringOrNull("hello");
    matchStringOrNull(42);

    testTriangle(null);
    testTriangle(new Triangle(200, 300));
    testTriangle(new Triangle(10, 20));
    testTriangle(new Rectangle());
  }

  static String formatObject(Object o) {
    return switch (o) {
      case Integer i -> 
        String.format("int: %d", i);
      case String s->
        String.format("string: %s", s);
      case Double d ->
        String.format("double: %f", d);
      default ->
        o.toString();
    };
  }

  static void testFooBar(String s) {
    switch (s) {
      case null -> 
        System.out.println("No NPE today");
      case "Foo", "Bar" ->
      System.out.println("Yay!");
      default ->
        System.out.println("Boo");
    }
  }

  static void matchStringOrNull(Object o) {
    switch (o) {
      case null, String s ->
        System.out.println("matched!");
      default ->
        System.out.println("Not matched");
    }
  }

  static void testTriangle(Shape s) {
    switch (s) {
      case Triangle t && t.calculateArea() > 100 ->
          System.out.println("Large triangle");

      case null, default ->
        System.out.println("Some shape, possibly mull or a small triangle");
    }
  }
}

class Foo {}

class Shape {}

class Rectangle extends Shape {}

class Triangle extends Shape {
  int b, h;

  public Triangle(int b, int h) {
    this.b = b;
    this.h = h;
  }

  int calculateArea() {
    return (int) (b * h * 0.5);
  }
}
