public class Demo {
  public static void main(String[] args) {
    try {
      Foo foo = null;
      System.out.println(foo.i);
    } catch (NullPointerException ex) { // only for testing, don't ever do this!
      System.err.println(ex.getLocalizedMessage());
    }

    try {
      Foo fooAgain = new Foo(42);
      fooAgain.b = null;
      System.out.println(fooAgain.b.c);
    } catch (NullPointerException ex) {
      System.err.println(ex.getLocalizedMessage());
    }

    try {
      Foo arr[][][][] = new Foo[1][2][3][4];
      arr[0][1][2][3] = null;
      System.out.println(arr[0][1][2][3].i);
    } catch (NullPointerException ex) {
      System.err.println(ex.getLocalizedMessage());
    }
  }
}

class Foo {
  int i;
  Bar b;

  public Foo(int i) {
    this.i = i;
  }
}

class Bar {
  Baz c;

  public Bar(Baz c) {
    this.c = c;
  }
}

class Baz {



}