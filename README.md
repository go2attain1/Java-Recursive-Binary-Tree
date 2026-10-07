# Recursive Binary Tree

A Java project demonstrating a generic binary tree built without a separate node
class. Each `BinaryTree<T>` object is both a node and the root of its own subtree,
so every operation is naturally recursive.

## Overview

| Type | Kind | Description |
|------|------|-------------|
| `BinaryTree<T>` | Class | Holds an element and left/right child trees; provides `size()`, `height()`, and three traversal methods |
| `BinaryTreeTest` | Test class | JUnit tests for every method, using trees with 0, 1, and 2 children |

## How It Works

A tree's size and height are defined in terms of its children's:

- **size** = 1 + size(left) + size(right), with a missing child counting as 0
- **height** = 1 + max(height(left), height(right)), with a missing child counting as 0

Each traversal builds a parenthesized string, differing only in where the node's
own element is placed.

For a tree with root `A`, left child `B`, and right child `C`:

  A
 / \
B   C


| Traversal | Order | Output |
|-----------|-------|--------|
| Pre-order | root, left, right | `(A(B)(C))` |
| In-order | left, root, right | `((B)A(C))` |
| Post-order | left, right, root | `((B)(C)A)` |

## Concepts Demonstrated

- **Recursive data structures**: a tree defined in terms of smaller trees
- **Base and recursive cases**: leaf nodes, one-child nodes, two-child nodes
- **Tree traversals**: pre-order, in-order, and post-order
- **Generics**: `BinaryTree<T>` stores any element type
- **Unit testing**: trees of varying shapes, including shared subtrees, checked against
  expected sizes, heights, and traversal strings

## Project Structure

recursivetree/

├── BinaryTree.java

└── BinaryTreeTest.java


## Running the Tests

The tests extend `student.TestCase`, so `student.jar` must be on your classpath.

1. Create a Java project and a package named `recursivetree`
2. Place both `.java` files in that package
3. Add `student.jar` to the project's build path
4. Run `BinaryTreeTest` as a JUnit test

## Example Usage

```java
BinaryTree<String> b = new BinaryTree<>("B");
BinaryTree<String> c = new BinaryTree<>("C");
BinaryTree<String> a = new BinaryTree<>("A", b, c);

a.size();               // 3
a.height();             // 2
a.toPreOrderString();   // "(A(B)(C))"
a.toInOrderString();    // "((B)A(C))"
a.toPostOrderString();  // "((B)(C)A)"
```
