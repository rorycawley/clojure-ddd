# Codespaces Clojure template

## Chap 1

### Concepts from SICP

A programming language provides a set of tools, constructs, and abstractions that allow programmers to express and manipulate processes in a structured and coherent manner.

In this context, a process refers to the abstract notion of computation or the sequence of steps that transform data. The language serves as a **framework for thinking about, designing, and implementing processes**. It provides a vocabulary and syntax for expressing computations and **allows programmers to combine simple ideas to form more complex ideas**.

By providing means for combining simple ideas, a programming language offers a way to compose and structure processes hierarchically. This hierarchical composition enables programmers to **break down complex problems into smaller, more manageable subproblems**, and then **combine the solutions to those subproblems to solve the overall problem**.

The language's constructs, such as functions, conditionals, loops, and data structures, provide the **building blocks for organizing and structuring processes**. They allow programmers to **encapsulate common patterns, create abstractions, and express computations at different levels of abstraction**. These constructs facilitate the organization and manipulation of ideas about processes.

For example, in a language like Clojure, you have tools like procedures (functions), recursion, and higher-order functions, which allow you to abstract and manipulate processes. You can create reusable functions to encapsulate common computations, use recursion to express repetitive patterns, and apply higher-order functions to manipulate and transform processes themselves.

By providing a **framework for organizing ideas about processes**, a programming language **helps programmers think systematically and clearly about complex problems**. It encourages the **decomposition of problems into smaller, manageable parts** and provides the means to express those parts as coherent and reusable units. This framework allows programmers to reason about, analyze, and evolve processes effectively.

Overall, the framework provided by a programming language allows programmers to **organize their ideas about processes in a structured and systematic way, enabling them to express complex computations and solve problems efficiently**.

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

In the context of programming, **abstractions** refer to the ability to hide complex details and provide a simplified and higher-level interface for working with those details. Abstractions help manage **complexity**, improve code organization, and promote code reuse.

In the context of Clojure (and Lisp in general), functions are a powerful tool for creating abstractions. By **encapsulating a sequence of operations into a function**, you can **hide the implementation details** and **expose a clean interface* that allows users to perform a specific task **without needing to understand the inner workings**. This is **black box abstraction**.

Abstractions in Clojure enable you to think at a higher level of abstraction, **focusing on the problem domain** rather than the low-level details of implementation. They help **modularize** code by **breaking it down into smaller, more manageable units** that can be **composed** together to create more **complex behaviors**.

Here's a simple example to illustrate the concept of **abstraction in Clojure**. Suppose you have a list of numbers, and you want to find the sum of their squares. You could implement it as follows:

```clojure
(defn sum-of-squares [nums]
  (reduce + (map #(* % %) nums)))
```

In this code, the sum-of-squares function abstracts away the details of iterating over the list, squaring each number, and summing them up. The user of this function doesn't need to worry about these specific operations; they can simply call sum-of-squares and pass in the list of numbers.

**By encapsulating** the sequence of operations into a function, **you create an abstraction** that **allows users to work with the higher-level concept** of summing the squares, **without having to understand or duplicate the implementation details** each time.

Abstractions not only simplify code usage but also enable code reuse. Once you have defined a useful abstraction, you can use it in different parts of your codebase or share it with others. This promotes modularity and reduces the need for duplicating code.

Abstractions in Clojure allow you to **encapsulate complexity**, provide simplified interfaces, and promote code reuse. They **help manage complexity**, improve code organization, and **enable you to think at a higher level of abstraction when designing and implementing your programs**.

In Clojure, **primitive expressions** are the fundamental building blocks that form the basis of the language's syntax and semantics. These expressions represent the simplest entities that the language is concerned with and **can be directly evaluated by the Clojure interpreter**.

The primitive expressions in Clojure include:

1. **Literals**: These are direct representations of data values. Common literals in Clojure include numbers (e.g., integers, floats), strings, booleans (true and false), characters, and keywords.
2. **Symbols**: Symbols represent names or identifiers. They are used to refer to variables, functions, and other named entities in the program. Symbols in Clojure are denoted by their textual representation, such as foo, x, or my-function.
3. **Collections**: Clojure provides several built-in data structures, and the expressions to create and manipulate these collections are considered primitive expressions. Some common collections include lists (expressed with parentheses), vectors (expressed with square brackets), sets (expressed with curly braces), and maps (expressed with curly braces and key-value pairs).
4. **Function Calls**: Invoking a function is a primitive expression in Clojure. A function call is written by placing the function name or symbol followed by the arguments inside parentheses. For example, (inc 5) calls the inc function with the argument 5, which increments the value by one.
5. **Special Forms**: Special forms are expressions with unique syntax and evaluation rules in Clojure. They provide essential control structures and define the behavior of the language. Examples of special forms in Clojure include if, let, fn, do, defn, def, and many others.
6. **Macros**: Macros are a powerful feature in Clojure that allow for the creation of new syntactic forms. Macros transform code at compile-time, providing a way to extend the language's syntax. They are invoked using the macroexpand function or implicitly during compilation.

These are the foundational primitive expressions in Clojure. By combining and manipulating these expressions, you can build more complex and expressive programs.

It's worth noting that **Clojure's standard library** provides numerous functions and macros that operate on these primitive expressions, enabling you to perform various computations, data transformations, and control flow operations. Additionally, you can define your own functions and macros to create abstractions and extend the language further.

In Clojure, there are several **means of combination** available that allow you **to build compound elements from simpler ones**. These means of combination enable you to compose and manipulate data and functions to create more complex and expressive structures. Here are some of the primary means of combination in Clojure:

1. **Function Composition**: Clojure allows you to combine functions to create new functions. You can use the comp function or the threading macros (-> and ->>) to compose functions together. Function composition allows you to build more complex computations by chaining multiple functions, where the output of one function becomes the input for the next.
2. **Higher-Order Functions**: Clojure treats functions as first-class citizens, meaning you can pass functions as arguments to other functions and return them as results. This higher-order function capability allows you to build more expressive and reusable code by manipulating functions as data.
3. **Collection Functions**: Clojure provides a rich set of functions for working with collections, such as map, reduce, filter, and apply. These functions enable you to combine and transform collections based on specific criteria, allowing you to create more complex data structures and perform powerful data manipulation.
4. **Macros: Clojure's macro system provides a means of combination by allowing you to define new syntactic constructs. Macros transform code at compile-time, allowing you to extend the language's syntax and create new abstractions. Macros enable you to build compound expressions by manipulating and generating code.
5. **Data Structure Composition**: Clojure offers various built-in data structures like lists, vectors, sets, and maps. These structures can be combined and nested to represent more complex data hierarchies. For example, you can have a vector of maps, a set of vectors, or a map of maps.
6. **Namespace Composition**: Clojure uses namespaces to organize code. Namespaces can be combined and composed to structure and group related functionality. By using the require and use forms, you can bring in functions and macros from other namespaces, effectively combining different parts of your codebase.

**These means of combination** in Clojure provide the flexibility and expressiveness needed to **build complex systems**. They allow you to combine simpler elements, such as functions, data structures, and macros, to create compound elements that represent more sophisticated ideas and behaviors.

Clojure provides several **means of abstraction** that allow you **to name and manipulate compound elements as units**. These means of **abstraction enable you to encapsulate complexity, create reusable code, and manage the complexity of your programs**. Here are some of the primary means of abstraction in Clojure:

1. **Functions**: Functions in Clojure are a powerful means of abstraction. You can define functions using the defn special form and give them names. Functions allow you to encapsulate a sequence of operations into a reusable unit. By naming functions and providing parameters, you create abstractions that can be invoked and composed to perform specific tasks. Functions help you hide implementation details and provide a higher-level interface to interact with.
2. **Namespaces**: Clojure uses namespaces to organize code and provide a way to name and group related elements. Namespaces allow you to define a logical boundary for your code and provide a context in which you can define functions, data structures, and other constructs. Namespaces help you create modular code and prevent naming conflicts. They also enable you to selectively import and use specific elements from other namespaces, providing a mechanism for managing and manipulating compound elements across your codebase.
3. **Data Abstraction**: Clojure supports various data abstraction techniques. It provides immutable data structures, such as lists, vectors, sets, and maps, which can be used to encapsulate and represent complex data. By manipulating and accessing data through well-defined abstractions, you can hide internal details and provide a clear interface for working with data. Data abstraction helps manage complexity and enables you to reason about data structures at a higher level of abstraction.
4. **Macros**: Macros in Clojure are a means of abstraction that allow you to define new syntactic constructs. Macros operate on code at compile-time and provide a mechanism for transforming and generating code. By defining macros, you can create higher-level abstractions and domain-specific languages (DSLs) tailored to specific problem domains. Macros allow you to extend the language's syntax and create new ways of expressing ideas and computations.
5. **Protocols and Multimethods**: Clojure provides protocols and multimethods as mechanisms for abstraction and polymorphism. Protocols define sets of functions that can be implemented by different types, enabling you to define behavior for a particular abstraction. Multimethods allow you to define behavior based on the type or other characteristics of the arguments. These mechanisms provide a flexible and extensible way to define and manipulate compound elements based on their characteristics.

By utilizing these means of abstraction, Clojure allows you to create modular, reusable, and expressive code. They help you organize and manage complexity, provide clear interfaces, and enable you to work with compound elements as units, ultimately enhancing the maintainability and scalability of your programs.

A powerful programming language is **more than just a means for instructing a computer to perform tasks**. The language also **serves as a framework within which we organize our ideas about processes**. Thus, when we describe a language, we should pay particular attention to the means that the language provides for combining simple ideas to form more complex ideas. Every powerful language has **three mechanisms for accomplishing this**:

1. **primitive expressions**, which represent the simplest entities the language is concerned with,
2. **means of combination**, by which compound elements are built from simpler ones, and
3. **means of abstraction**, by which compound elements can be named and manipulated as units.

In "Structure and Interpretation of Computer Programs" (SICP), the distinction between procedures and data is **fundamental to understanding the nature of computation and programming**.

Procedures, also known as functions or operations, are abstractions that represent a series of steps or instructions to be executed. They encapsulate a sequence of operations that manipulate data or perform computations. Procedures take input arguments, operate on them, and produce results as output.

Data, on the other hand, refers to the information or values that are manipulated and processed by procedures. Data can represent various types of information, such as numbers, strings, lists, structures, or any other form of information that can be stored and operated upon.

**The distinction between procedures and data is central to the concept of higher-order programming**, which is a key theme in SICP. In SICP, the authors emphasize the idea that **procedures and data can be treated as interchangeable entities within a programming language**.

One of the key insights presented in SICP is that **procedures can be treated as first-class citizens in a programming language**. This means that procedures can be passed as arguments to other procedures, returned as results, and stored in data structures. **This ability to manipulate procedures as data enables powerful programming techniques such as higher-order functions and functional composition**.

By highlighting the distinction between procedures and data, SICP encourages programmers to **think of procedures not only as instructions to be executed but also as entities that can be manipulated and composed, just like data**. This perspective opens up a wide range of possibilities for **creating more flexible and expressive programs**.

Overall, **the distinction between procedures and data** in SICP helps establish a foundation for understanding the nature of computation, the manipulation of information, and **the power of abstraction in programming**.

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


