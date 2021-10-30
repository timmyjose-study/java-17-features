public class Demo {
  static enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
  }

  public static void main(String[] args) {
    Day d = Day.FRIDAY;

    switch (d) {
      case MONDAY, TUESDAY, WEDNESDAY ->
        System.out.println("It's Monday, Tuesday, or Wednesday");
      case THURSDAY -> 
        System.out.println("It's Thursday");
      case FRIDAY, SATURDAY, SUNDAY ->
        System.out.println("It's Friday, Saturday, or Sunday");
    }

    int numLetters = switch (d) {
      case MONDAY, FRIDAY, SUNDAY -> 6;
      case TUESDAY -> 7;
      case THURSDAY, SATURDAY -> 8;
      case WEDNESDAY -> 9;
    };

    assert(numLetters == 6);

    howMany(1);
    howMany(2);
    howMany(3);
    howMany(4);
    howMany(5);

    howManyAgain(1);
    howManyAgain(2);
    howManyAgain(100);

    System.out.println(foo(Day.MONDAY));
    System.out.println(foo(Day.TUESDAY));
    System.out.println(foo(Day.SATURDAY));
  }

  static void howMany(int k) {
    switch (k) {
      case 1 -> 
        System.out.println("One");
      case 2 -> 
        System.out.println("Two");
      default ->
        System.out.println("Many!");
    }
  }

  static void howManyAgain(int k) {
    System.out.println(switch (k) {
      case 1 -> "One";
      case 2 -> "Two";
      default -> "Many!";
    });
  }

  static int foo(Day d) {
    return switch (d) {
      case MONDAY -> 0;
      case TUESDAY -> 1;
      default -> {
        int k = d.toString().length();
        int result = f(k);
        yield result; // value of this block, as so that of the enclosing switch expression
      }
    };
  }

  static int f(int k) {
    return k * 2 + k + 1;
  }
}