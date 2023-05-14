# Codespaces Clojure template

## Chap 1

### Concepts from SICP

Computational **processes** are abstract beings that inhabit computers. As they evolve, processes manipulate other abstract things called **data**.

Processes are the abstract notion of computation or the sequence of steps that transform data. A process is essentially a series of operations that take input and produce output, possibly modifying the input along the way.

In the context of Clojure, a process can be thought of as a sequence of transformations applied to data using **functions**. Clojure embraces a functional programming paradigm, where functions are the primary means of performing computations. These functions take input data and return transformed data **without modifying the original input**.

In Clojure, you can define **a process as a composition of functions**, where each function represents a step in the computation. The output of one function becomes the input for the next, forming a **chain of transformations**. This compositional approach allows you to express complex processes by breaking them down into smaller, reusable functions.

```clojure
(defn square [x]
  (* x x))

(defn square-list [lst]
  (map square lst))
```

In the above code, we define a function square that takes a number x and returns its square. Then, we define square-list, which takes a list lst and applies the square function to each element using the **map** function. This composition of functions represents the process of squaring each number in the list.

You can then call the square-list function with some input data:

```clojure
(square-list [1 2 3 4 5])
```

The result would be a new list [1 4 9 16 25], where each element of the original list has been squared.

In Clojure, **processes can be represented using higher-order functions** like map, reduce, filter, and others. These functions allow you to express computations in a concise and declarative manner, focusing on the transformation of data rather than the explicit control flow.

A Clojure function is a reusable block of code and one of the fundamental building blocks of computation. Functions are the primary means of computation and abstraction in Clojure. You can define functions using the **defn** special form, which binds a symbol to a function definition.

Here's an example that defines a simple function in Clojure:

```clojure
(defn add-two-numbers [a b]
  (+ a b))
```

In this example, the add-two-numbers function takes two parameters, a and b, and returns their sum using the + function.

You can then call the function by providing arguments:

```clojure
(add-two-numbers 3 5) ; Returns 8
```

Clojure functions support various features, such as default values, variable arity, destructuring, and higher-order functions. These features allow you to express complex computations and create abstractions.

Additionally, Clojure provides anonymous functions, which are functions without a name. You can define them using the fn special form or the shorthand #() syntax. Anonymous functions are often used as arguments to higher-order functions or to create small, one-off functions.

For example, here's an anonymous function that doubles a number:

```clojure
(#(* 2 %) 4) ; Returns 8
```

In this code, #(* 2 %) is an anonymous function that multiplies its argument (%) by 2.

They allow you to encapsulate reusable code, express computations, and build abstractions, making them fundamental to programming in Clojure.

In the context of programming, **abstractions** refer to the ability to hide complex details and provide a simplified and higher-level interface for working with those details. Abstractions help manage complexity, improve code organization, and promote code reuse.




## Reference

## Clojure Basics

### SICP Clojure

* [SICP Book PDF](https://web.mit.edu/6.001/6.037/sicp.pdf)
* [SICP Book](https://lfe.io/books/sicp/ch1/building-abstractions-with-functions.html)
* [SICP 1.1 Clojure](https://bernhardwenzel.com/articles/sicp-chapter-1-1-in-clojure/)
* [SICP Distilled](https://www.sicpdistilled.com/)
* [Why and how to start your SICP trek](https://archive.is/uTOol#selection-839.0-880.0)

## DDD Basics

* [Domain-Driven Design in Clojure](https://www.fbeyer.com/posts/clojure-ddd/)
* [Domain Driven Design (DDD) in Clojure, an example implementation](https://clojureverse.org/t/domain-driven-design-ddd-in-clojure-an-example-implementation/8802/5)
* [Domain-Driven Design with Clojure](https://www.infoq.com/presentations/DDD-Clojure/)
* [Data Driven RAD with Malli](https://www.youtube.com/watch?v=ww9yR_rbgQs)


### Calva

ALT+Shift+P Calva

### Leinegan

```bash
lein -h
```

### Mermaid

I have added the Mermaid Markdown extention to render diagramms in the .md files.


