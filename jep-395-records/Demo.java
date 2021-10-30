public class Demo {
  public static void main(String[] args) {
    var r1 = new Rational(2, 4); // 1/2
    var r2 = new Rational(4, 6); // 2/3

    var sum = r1.add(r2); // 7/6
    System.out.printf("%s\n", sum);

    var diff = r1.sub(r2); // -1/6
    System.out.printf("%s\n", diff);

    var prod = r1.mul(r2); // 1/3
    System.out.printf("%s\n", prod);

    var quot = r1.div(r2); // 3/4
    System.out.printf("%s\n", quot);
  }
}

record Rational(int num, int denom) {
  Rational {
    int g = gcd(num, denom);
    num /= g;
    denom /= g;

    if (denom < 0) {
      num *= -1;
      denom *= -1;
    }
  }

  int gcd(int x, int y) {
    if (y == 0) {
      return x;
    }
    return gcd(y, x % y);
  }

  Rational add(Rational other) {
    return new Rational(this.num * other.denom + this.denom * other.num, this.denom * other.denom);
  }

  Rational sub(Rational other) {
    return new Rational(this.num * other.denom - this.denom * other.num, this.denom * other.denom);
  }

  Rational mul(Rational other) {
    return new Rational(this.num * other.num, this.denom * other.denom);
  }

  Rational div(Rational other) {
    return new Rational(this.num * other.denom, this.denom * other.num);
  }

  @Override
  public String toString() {
    return this.num + "/" + this.denom;
  }
}
