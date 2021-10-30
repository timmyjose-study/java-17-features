import java.util.Objects;

public class Demo {
  public static void main(String[] args) {
    Object message = "Hello, world!";

    if (message instanceof String s1) {
      System.out.println("s1 = " + s1);
    }

    if (message instanceof String s2 && s2.length() < 5) {
      System.out.println("This line will not be printed");
    }

    if (message instanceof String s3 && s3.length() >= 10) {
      System.out.println("s3 = " + s3);
    }

    Object spurious = null;

    if (spurious instanceof String s && s.length() > 11) {
      System.out.println("This line will not be printed, but the null check is implied");
    }

    Person bob = new Person("Bob", 42, 123.45);
    Person bobAgain = new Person("Bob", 42, 123.45);
    assert(bob.equals(bobAgain));
    Person notBob = new Person("Not Bob", 42, 123.45);
    assert(!bob.equals(notBob));
  }
}

class Person {
  private String name;
  private int age;
  private double salary;

  public Person(String name, int age, double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Person p 
        && this.name.equals(p.name) 
        && this.age == p.age 
        && this.salary == p.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this);
  }
}
