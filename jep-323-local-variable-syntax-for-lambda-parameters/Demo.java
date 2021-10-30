import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Demo {
  public static void main(String[] args) {
    var list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
    var evens = list.stream().filter(d -> d % 2 == 0).collect(Collectors.toList());
    var evensAgain = list.stream().filter((var d) -> d % 2 == 0).collect(Collectors.toList());
    assert(evens.equals(evensAgain));
  }
}