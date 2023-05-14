# Codespaces Clojure template

## Chap 1

### Concepts from SICP

#### The main insight of the SICP

Reading SICP, readers will gain an understanding of how and why the code works. Moreover, readers will develop the ability to modify and create new programming languages to support innovative ideas and processes. This ability to invent new languages is presented as the ultimate benefit of the book's teachings.

You must do the exercises to get the most out of SICP. Reading will not suffice. Videos will not suffice. Putting on a wizard cape will not suffice. Only doing the exercises will bring lasting shifts to how you see and understand code.

#### Formally understanding a language

SICP is very careful to always refer to procedures in programs and reserves function for mathematical functions.

A formal language has just three concepts that combine and multiply fruitfully: primitive expressions (e.g. numbers), special forms (e.g. quoted expressions, assignments, logic, lambda), and combinations (i.e. procedures and applying them). Or as the SICP authors put it, **understanding any computer language just comes down to three questions**:

* What are the primitives?
* What are the means of abstraction?
* What are the means of combination?

Just asking those questions of your favorite language may spark new insights – a new mental framework to structure your understanding, instead of just memorizing language syntax and APIs.

The above highlights the key concepts in a formal programming language, emphasizing the importance of understanding these concepts to grasp any computer language effectively. The three concepts mentioned are primitive expressions, special forms, and combinations.

Primitive expressions: These are the foundational building blocks of a programming language. They represent the simplest entities or values that the language works with. Examples of primitive expressions include numbers, strings, and booleans. These basic elements serve as the starting point for constructing more complex expressions and computations.

Special forms: Special forms are specific language constructs that have special syntactic or semantic rules associated with them. They provide unique behaviors and enable advanced language features. Examples of special forms include quoted expressions, assignments, control flow constructs (such as conditionals and loops), and lambda expressions for defining functions. Special forms extend the language's capabilities beyond what can be achieved with primitive expressions.

Combinations: Combinations involve combining expressions together to create more complex expressions or computations. They typically involve applying procedures (functions or operations) to their arguments. Combinations allow for composition, abstraction, and the creation of higher-level ideas and behaviors. The ability to combine and manipulate expressions is a powerful feature that enables the expression of complex algorithms and problem-solving techniques.

The passage suggests that understanding any programming language essentially boils down to three fundamental questions: What are the primitives? What are the means of abstraction? What are the means of combination? By exploring these questions, you can gain a deeper understanding of a programming language beyond just memorizing its syntax or API. It encourages a conceptual understanding of the language's fundamental building blocks, the mechanisms for abstraction and composition, and the mental framework to structure your understanding of the language.

By examining these concepts in your favorite programming language, you can uncover new insights and develop a solid foundation for working with the language more effectively. Instead of solely relying on rote memorization, this approach promotes a deeper understanding of the language's core principles and empowers you to think and reason about programming problems in a more structured and insightful manner.

In a programming language, there are three important ideas: primitive expressions (like numbers), special forms (such as conditionals), and combinations (procedures and their use). 

In Clojure, there are three fundamental concepts: primitive expressions (e.g., numbers, strings), special forms (e.g., conditionals, loops), and combinations (functions and their application).

**By asking questions about the primitives, means of abstraction, and means of combination in your chosen language, you can gain new insights and develop a mental framework for understanding it, rather than simply memorizing syntax and APIs.** This approach fosters a deeper understanding and allows you to structure your knowledge of the language more effectively.

In Clojure, one important rule to understand is that the most common expression is a combination expression. It is represented as a list of expressions enclosed in parentheses. The first element of the list is the operator (typically a function), and the remaining elements are the operands (arguments) passed to that operator.

For example:

```clojure
(+ 1 2 3)       ; Combination expression: + is the operator, and 1, 2, 3 are operands
(str "Hello" "!")  ; Combination expression: str is the operator, and "Hello" and "!" are operands
(println "Hi")    ; Combination expression: println is the operator, and "Hi" is the operand
```

In the above examples, the operator + performs addition, the operator str concatenates strings, and the operator println prints a value to the console. The operands (arguments) are provided after the operator within the combination expression.

This simple and consistent prefix notation allows for great flexibility and power in Clojure. It enables the composition of complex expressions and makes it easier to manipulate and transform code using macros, which are advanced language constructs in Clojure.

By understanding the structure of combination expressions and the role of the operator and operands, you can start to appreciate the generality and expressive capabilities of Clojure's prefix notation.

The code below provides the implementation of an evaluator and an application procedure in a Lisp-like language. **It consists of two functions: eval and apply**.

The eval function takes an expression (exp) and an environment (env) as arguments. It evaluates the expression based on its type using a series of cond statements. The different expression types include self-evaluating expressions, variables, quoted expressions, assignments, definitions, conditionals (if statements), lambda expressions, sequences of actions (begin statements), cond statements, and application expressions. Each expression type is handled by a specific helper function or evaluated recursively using eval.

The apply function takes a procedure and a list of arguments. It applies the procedure to the arguments by checking the type of the procedure. If it is a primitive procedure, it is applied using the apply-primitive-procedure helper function. If it is a compound procedure (lambda), it evaluates the body of the procedure within an extended environment, where the parameters are bound to the argument values.

Here's an equivalent Clojure version of the code:

```clojure
(defn eval [exp env]
  (cond
    (self-evaluating? exp) exp
    (variable? exp) (lookup-variable-value exp env)
    (quoted? exp) (text-of-quotation exp)
    (assignment? exp) (eval-assignment exp env)
    (definition? exp) (eval-definition exp env)
    (if? exp) (eval-if exp env)
    (lambda? exp) (make-procedure (lambda-parameters exp)
                                  (lambda-body exp)
                                  env)
    (begin? exp) (eval-sequence (begin-actions exp) env)
    (cond? exp) (eval (cond->if exp) env)
    (application? exp) (apply (eval (operator exp) env)
                              (list-of-values (operands exp) env))
    :else (error "Unknown expression type -- EVAL" exp)))

(defn apply [procedure arguments]
  (cond
    (primitive-procedure? procedure) (apply-primitive-procedure procedure arguments)
    (compound-procedure? procedure) (eval-sequence
                                       (procedure-body procedure)
                                       (extend-environment
                                         (procedure-parameters procedure)
                                         arguments
                                         (procedure-environment procedure)))
    :else (error "Unknown procedure type -- APPLY" procedure)))

(defn self-evaluating? [exp]
  (or (number? exp)
      (string? exp)
      (boolean? exp)))

(defn variable? [exp]
  (symbol? exp))

(defn lookup-variable-value [var env]
  ; Implementation of variable lookup in the environment
  )

(defn quoted? [exp]
  (and (list? exp)
       (= (first exp) 'quote)))

(defn text-of-quotation [exp]
  (second exp))

(defn assignment? [exp]
  (and (list? exp)
       (= (first exp) 'set!)))

(defn eval-assignment [exp env]
  ; Implementation of assignment evaluation
  )

(defn definition? [exp]
  (and (list? exp)
       (= (first exp) 'define)))

(defn eval-definition [exp env]
  ; Implementation of definition evaluation
  )

(defn if? [exp]
  (and (list? exp)
       (= (first exp) 'if)))

(defn eval-if [exp env]
  ; Implementation of if statement evaluation
  )

(defn lambda? [exp]
  (and (list? exp)
       (= (first exp) 'lambda)))

(defn lambda-parameters [exp]
  (second exp))

(defn lambda-body [exp]
  (nthnext exp 2))

(defn make-procedure [params body env]
  ; Create and return a procedure object with given parameters, body, and environment
  )

(defn begin? [exp]
  (and (list? exp)
       (= (first exp) 'begin)))

(defn begin-actions [exp]
  (rest exp))

(defn cond? [exp]
  (and (list? exp)
       (= (first exp) 'cond)))

(defn cond->if [exp]
  ; Transform the cond expression into an equivalent if expression
  )

(defn application? [exp]
  (list? exp))

(defn operator [exp]
  (first exp))

(defn operands [exp]
  (rest exp))

(defn list-of-values [exps env]
  ; Evaluate a list of expressions in the given environment and return the values
  )

(defn primitive-procedure? [procedure]
  ; Check if the procedure is a primitive procedure
  )

(defn apply-primitive-procedure [procedure arguments]
  ; Apply the primitive procedure to the given arguments and return the result
  )

(defn compound-procedure? [procedure]
  ; Check if the procedure is a compound procedure (lambda)
  )

(defn eval-sequence [exps env]
  ; Evaluate a sequence of expressions in the given environment
  )

(defn extend-environment [params args env]
  ; Extend the environment with new bindings based on given parameters and arguments
  )

(defn procedure-parameters [procedure]
  ; Get the parameters of a procedure (lambda)
  )

(defn procedure-body [procedure]
  ; Get the body of a procedure (lambda)
  )

(defn procedure-environment [procedure]
  ; Get the environment of a procedure (lambda)
  )

(defn error [message exp]
  ; Handle error conditions
  )
```

Code is data is code is manifest above – a process that shapes and directs other processes, including itself.

#### Framework for organising ideas about processes

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

#### Abstractions

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

#### Primitive expressions

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

```clojure
3
"hello"
:foo 
true
false
\c
undefinedname ; this returns an error since its a name that doesn't exist
```

#### Means of combination

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

```clojure
(+ 2 4)
(/ 3 45 23)
(+ (/ 23 4) (* 3 2))
```

#### Expression

In Clojure, an **expression** refers to **a code construct that evaluates to a value**. It can be a **simple literal value**, a **function call**, a **combination of expressions**, or a **special form**. Expressions are the building blocks of Clojure code and **are evaluated by the Clojure interpreter or compiler to produce a result**.

Here are a few examples of expressions in Clojure:

Literal Expressions:

* Numbers: 42, 3.14, 0
* Strings: "Hello, world!", "Clojure is awesome"
* Booleans: true, false
* Keywords: :keyword, :name, :age

Function Call Expressions:

* Basic function call: (inc 5), (str "Hello, " "world!")
* Higher-order function call: (map inc [1 2 3]), (filter even? [1 2 3 4])

Special Form Expressions:

* if expression: (if condition then-expression else-expression)
* let expression: (let [x 42] (* x x))
* fn expression: (fn [x] (* x x))

Combination of Expressions:

* Nested expressions: (+ (* 2 3) 4)
* Composition of functions: (-> x (f) (g) (h))

In Clojure, expressions are typically enclosed in parentheses to denote their evaluation. The parentheses are not only used for grouping expressions but also indicate the function application and syntactic structure of the code.

It's important to note that Clojure follows a prefix notation (also known as Polish notation), where the operator or function name comes first, followed by its arguments or operands. This notation allows for straightforward expression manipulation and avoids the ambiguity of operator precedence.

In summary, expressions in Clojure encompass a wide range of constructs, including literals, function calls, special forms, and combinations thereof. They are the core elements of Clojure code that are evaluated to produce meaningful results.

A critical aspect of a programming language is the means it provides for using names to refer to computational objects. We say that the name identifies a variable whose value is the object. Once we give something a name, we can refer to it in expressions.

**def** is Clojures simplest means of abstraction, for it allows us to use simple names to refer to the results of compound operations.

In general, computational objects may have very complex structures, and it would be extremely inconvenient to have to remember and repeat their details each time we want to use them. Indeed, complex programs are constructed by building, step by step, computational objects of increasing complexity.

The **REPL** makes this step-by-step program construction particularly convenient because name-object associations can be created incrementally in successive interactions. This feature encourages the incremental development and testing of programs and is largely responsible for the fact that a Lisp program usually consists of a large number of relatively simple functions.

It should be clear that the possibility of associating values with symbols and later retrieving them means that the interpreter must maintain some sort of **memory** that keeps track of the **name-object pairs**. This memory is called the **environment** (more precisely the global environment, since we will see later that a computation may involve a number of different environments).

```clojure
(def a 2)
(* a 2)
(+ a a 3)
```

#### Eval / Apply

In evaluating combinations, the interpreter is itself following a procedure

* **Evaluate** the subexpressions of the combination
* **Apply** the function that is the value of the leftmost subexpression (the operator) to the arguments that are the values of the other subexpressions (the operands).

Note that the first step says that in order to accomplish the evaluation process for a combination we must first perform the evaluation process on each element of the combination. Thus, the evaluation rule is recursive (it needs to invoke itself)

We have to evaluate both of them, in order to evaluate the first we need to evaluate 2 and (* 4 6), which makes us have to recur again. You can think of the s-expressions as a tree with partial evaluations percolating upwards


```clojure
(* (+ 2 (* 4 6))
   (+ 3 5 7))
```

In programming, a program directs the evaluation process by instructing how expressions should be computed. When evaluating procedure expressions, the arguments are first evaluated before applying the procedure's operator, recursively following this process for each subexpression.

A process, in this context, refers to the execution of a program. It involves evaluating expressions within an environment, which consists of variables, functions, and other entities that the program can access.

In programming, the execution process of a program involves a recurring interplay between the operations of **eval** and **apply**. The eval operation evaluates expressions, which means it examines and computes the value of an expression. The apply operation, on the other hand, takes a procedure and applies it to a set of arguments, producing a result.

This interplay can happen in a recursive manner, where the eval operation may encounter new expressions to be evaluated within the original expression being evaluated. Similarly, the apply operation may involve the application of nested procedures that themselves require further evaluation through eval.

This recursive interplay of eval and apply, happening at different levels of expressions and procedures, forms the essence of the program's execution process. It creates a chain of evaluations and applications that extend "all the way down," illustrating the recursive nature of program execution.

**Understanding and internalizing this interplay between eval and apply is a key insight in programming**. It reveals how the program's behavior emerges from the recursive evaluation and application of expressions and procedures. Working through the concepts presented in SICP can provide a deeper appreciation and "Eureka!" moment where this interplay becomes more tangible and intuitive.

The operations used in programming, are not black boxes but can be understood and built up from a small set of fundamental operators. The passage lists these operators as:

* quote: This operator allows you to create a literal representation of an expression without evaluating it. It is denoted by the ' symbol in Clojure.
* atom: This operator checks whether an expression is an atomic value or not. An atomic value is a value that is indivisible or cannot be further decomposed.
* eq: This operator compares two expressions to check if they are equal.
* car: This operator extracts the first element (car) of a list or pair.
* cdr: This operator extracts the rest (cdr) of a list or pair, excluding the first element.
* cons: This operator constructs a new list or pair by combining an element with an existing list or pair.
* cond: This operator allows conditional evaluation by providing a series of expressions and associated conditions.

In addition to these operators, the passage mentions the use of the function notation, which is typically represented by the lambda symbol (fn in Clojure). The lambda operator allows you to define anonymous functions, which can be used to create more complex procedures and abstractions.

By combining these fundamental operators and utilizing function notation, one can build up the behavior and functionality of eval and apply. This insight demonstrates that the seemingly complex operations can be reduced to a small set of foundational elements, providing a deeper understanding of how they work.

Overall, the passage emphasizes that eval and apply are not mysterious black boxes but can be comprehended and constructed from a limited set of operators, leading to a clearer understanding of their inner workings in programming.

In Clojure, the equivalent operators and function notation mentioned in the passage are as follows:

quote: In Clojure, the ' (single quote) symbol is used to create a quoted expression. For example, (quote (+ 1 2)) returns the unevaluated expression (+ 1 2).

atom: The atom? function in Clojure checks whether an expression is an atomic value. For example, (atom? 42) returns true since 42 is an atomic value.

eq: Clojure provides the = function to compare the equality of two expressions. For example, (= 2 2) returns true.

car: In Clojure, the first function extracts the first element of a sequence. For example, (first '(1 2 3)) returns 1.

cdr: In Clojure, the rest function extracts the rest of a sequence, excluding the first element. For example, (rest '(1 2 3)) returns (2 3).

cons: Clojure uses the cons function to construct a new list by combining an element with an existing list. For example, (cons 1 '(2 3)) returns (1 2 3).

cond: In Clojure, you can use the cond macro to express conditional evaluation. It allows you to provide a series of clauses with associated conditions and expressions. For example:

```clojure
(cond
  (zero? x) "Zero"
  (pos? x) "Positive"
  :else "Negative")
```

Function notation (lambda) in Clojure is represented by the fn special form. It allows you to define anonymous functions. For example:

```clojure
((fn [x] (* x x)) 5)
```

These are the corresponding constructs in Clojure that parallel the operators and function notation mentioned in the passage. They provide similar functionality and can be used to build up the behavior and functionality of eval and apply in Clojure programs.

#### Combinations

In "Structure and Interpretation of Computer Programs" (SICP), the term "combination of expressions" refers to the composition of simpler expressions to create more complex expressions. It is the act of combining and manipulating expressions to form larger expressions.

The authors of SICP emphasize that programming languages provide means of combination, allowing programmers to build compound expressions from simpler ones. By combining expressions, programmers can express more intricate computations and represent higher-level concepts.

In SICP, the focus is on the combination of procedures (functions) and data, as these are the fundamental elements of computation. The book explores the power of combining simple procedures to build more complex ones, and how these combinations can be used to model and solve various computational problems.

Combinations of expressions are typically achieved through function calls, where the operator (function) is applied to its arguments (operands). Expressions can also be combined through the use of special forms, macros, or other language-specific constructs.

For example, consider the following expression in Clojure:

```clojure
(+ (* 2 3) 4)
```

In this expression, the combination (+) represents the addition operation, and it takes the combination (* 2 3) (multiplication) and the value 4 as its operands. By combining these simpler expressions, a more complex expression is formed that computes the result of multiplying 2 and 3, and then adding 4 to the product.

**The concept of combination of expressions allows programmers to build up complex computations from simpler components**, enabling the creation of more sophisticated algorithms and problem-solving techniques.

By understanding and harnessing the power of combining expressions, **programmers can create expressive and modular code that breaks down complex problems into manageable parts** and promotes code reuse and abstraction.

Expressions such as these, formed by delimiting a list of expressions within parentheses in order to denote procedure application, are called **combinations**. The leftmost element in the list is called the **operator**, and the other elements are called **operands**. **The value of a combination is obtained by applying the procedure specified by the operator to the arguments that are the values of the operands**.

Even with complex expressions, the interpreter always operates in the same basic cycle: It reads an expression from the terminal, evaluates the expression, and prints the result. This mode of operation is oen expressed by saying that the interpreter runs in a **read-eval-print loop or REPL**. Observe in particular that it is not necessary to explicitly instruct the interpreter to print the value of the expression.

#### names

In the context of Clojure, the statement from SICP regarding the use of **names** to refer to computational objects remains relevant. Clojure provides mechanisms for using names to identify and refer to various computational entities such as variables, functions, macros, and data structures. This allows programmers to work with and manipulate these entities in their programs.

Let's explore how this concept applies to different aspects of Clojure:

* Variables: Clojure allows you to define and bind values to variables using the def or let forms. By assigning a value to a variable, you associate a name with the value, allowing you to refer to and use the value later in your code. For example:

```clojure
(def x 42) ; Define a variable 'x' with the value 42
(println x) ; Access and print the value of 'x'
```

* Functions: Functions in Clojure can be defined and named using the defn form. The name of the function serves as a reference to the sequence of operations or behavior defined within the function. You can invoke functions by using their names, passing arguments as necessary. For example:

```clojure
(defn square [x]
  (* x x)) ; Define a function 'square' that computes the square of a number

(square 5) ; Invoke the 'square' function with argument 5
(square (+ 2 5))
(square (square 3))
```

* Data Structures: Clojure provides various data structures such as lists, vectors, sets, and maps. These structures can be bound to names using def or let, allowing you to refer to and manipulate them throughout your code. For example:

```clojure
(def my-list [1 2 3]) ; Define a list and associate it with the name 'my-list'
(count my-list) ; Use the 'my-list' name to access and perform operations on the list

(defn spread [x y z]
  (- (max x y z) (min x y z)))
(spread 10) ; causes an error, wrong number of arguments

; We can specify different arities for the same function
(defn spread
  ([x] x)
  ([x y] (- (max x y) (min x y)))
  ([x y z] (- (max x y z) (min x y z))))

; we can do variadic (ie a variable number of arguments)
; Here the arguments are collected as a sequence called nums.
(defn spread [& nums]
  (- (apply max nums) (apply min nums)))

; apply takes a function and a sequence and calls the function with the elements of the sequence as args, so
(apply max [5 1 7 4])
(max 5 1 7 4) ; same as above
```

* Macros: Macros in Clojure define new syntactic constructs. By naming and defining macros, you can create new ways of expressing computations or transformations. You can invoke macros using their names and pass them code forms to be expanded at compile-time. For example:

To apply a compound procedure to arguments, evaluate the body of the function with each formal parameter replaced by the corresponding argument.

```clojure
(defn square [x]
  (* x x))

(square 5)

; Take the body of the function (* x x)
; Replace formal parameter, x, with the value of the argument, 5
; evaluate it to get 25
(* 5 5)
```

```clojure
(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))

(defn sum-of-squares [x y]
  (+ (* x x) (* y y)))

; To evaluate:
(f 5)

; We first look up the body of f
(sum-of-squares (+ a 1) (* a 2))
; and replace the formal parameter a with the argument 5, getting
(sum-of-squares (+ 5 1) (* 5 2))
; Now we need to evaluate sum-of-squares in the same way, replacing x with the value of (+ 5 1) and replacing y with the value of (* 5 2), giving the following sequence of substitutions:
(+ (square 6) (square 10))
(+ (* 6 6) (* 10 10))
(+ 36 100) ; 136
```

Though this model gets us very far, it only works for 'pure' functions. We have seen that we can add names to the global environment with def, another way of describing the evaluation of (square 5) is to evaluate the body

```clojure
(* x x)
```

in an environment where x is bound to 5.

```clojure
(defmacro my-macro [x]
  `(* 2 ~x)) ; Define a macro 'my-macro' that doubles its argument

(my-macro 5) ; Invoke the 'my-macro' macro with argument 5
```

In Clojure, the concept of using names to refer to computational objects remains fundamental. The ability to assign names to variables, functions, macros, and data structures allows for abstraction, modularization, and code reuse. Names provide a way to identify and manipulate these objects, making code more readable, maintainable, and expressive.

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
