public class Demo {
  public static void main(String[] args) {
    var expr = new MulExpr(new AddExpr(new ConstExpr(1), new SubExpr(new ConstExpr(2), new ConstExpr(10))), 
        new SubExpr(new DivExpr(new ConstExpr(10), new ConstExpr(2)), new ConstExpr(2)));
    System.out.printf("%d\n", expr.eval());

    var bst = new Node(new Node(new Leaf(), 8, new Node(new Leaf(), 10, new Leaf())), 15, new Leaf());
    bst.preOrder();
    System.out.println();
    bst.inOrder();
    System.out.println();
    bst.postOrder();
    System.out.println();
  }
}

sealed interface Expr 
permits ConstExpr, AddExpr, SubExpr, MulExpr, DivExpr {
  int eval();
}

record ConstExpr(int value) implements Expr {
  @Override
  public int eval() {
    return this.value;
  }
}

record AddExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return this.lhs.eval() + this.rhs.eval();
  }
}

record SubExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return this.lhs.eval() - this.rhs.eval();
  }
}

record MulExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return this.lhs.eval() * this.rhs.eval();
  }
}

record DivExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    var rhsVal = this.rhs.eval();
    return rhsVal == 0 ? 0 : this.lhs.eval() / rhsVal;
  }
}

sealed abstract class BST<T> permits Leaf, Node {
  void preOrder() {
    switch (this) {
      case Leaf l ->
        System.out.print("");
      case Node n ->
      {
        System.out.print(n.data + " ");
        n.left.preOrder();
        n.right.preOrder();
      }
    }
  }

  void inOrder() {
    switch (this) {
      case Leaf l ->
        System.out.print("");
      case Node n -> {
        n.left.inOrder();
        System.out.print(n.data +  " ");
        n.right.inOrder();
      }
    }
  }

  void postOrder() {
    switch (this) {
      case Leaf l ->
        System.out.print("");
      case Node n -> {
        n.left.postOrder();
        n.right.postOrder();
        System.out.print(n.data + " ");
      }
    }
  }
}

final class Leaf extends BST {}

final class Node<T> extends BST<T> {
  BST<T> left;
  T data;
  BST<T> right;

  public Node(BST<T> left, T data, BST<T> right) {
    this.left = left;
    this.data = data;
    this.right = right;
  }
}