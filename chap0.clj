; functional programming is a style of programming that emphasizes the evaluation of expressions, rather than execution of commands.
; Functional programming concerns and facilitates the application and composition of functions.
; Further, for a language to be considered functional, its notion of function must be first-class.First-class functions can be stored, passed, and returned just like any other piece of data.

; Clojure further supports a style of functional programming that includes such topics as purity, immutability, recursion, laziness, and referential transparency

; Lisp
; By relieving the brain of all unnecessary work, a good notation sets it free to concentrate on more advanced problems.

; In Clojure, the evaluation ordering is always the same—from innermost to out, left to right

; The mathematical operators in Clojure are also functions.

; If all function calls look the same to Clojure, then it’s easy to call functions with any number of arguments, because the call and its arguments are bound by the parentheses.

; In Clojure, you can use the apply function to send a sequence of numbers to a function as if they were sent as arguments

(def numbers [1 2 3 4 5 6 7 8 9 10])
(apply + numbers)

; Clojure programs are composed of data structures

; There will always be things we wish to say in our programs that in all known languages can only be said poorly

; No existing programming language can express precisely those concepts and abstractions needed for your specific application. The only person who can design a language to solve your exact problem is you.

; A programming language is low level when its programs require attention to the irrelevant.

; Creating a little language to solve a specific problem is the most effective technique yet devised for reducing complexity in software

; Jon Bentley popularized the concept of little languages in his article “Programming Pearls: Little Languages,”

; By only including features relevant to the problem, a well-designed little language is inherently high level.

; A single little language can’t address the exact needs of a nontrivial application any more than can a single general-purpose language.

; For this reason, little languages work best in concert. The ideal technique for writing a complex program is to slice it into multiple problem-specific pieces and then define a language for each problem slice.

; If we slice the program vertically, the result is a “tower” of languages, layered atop one another. Regardless of how we slice the overall problem, we can use the right language, and the right paradigm, for each subproblem.

; When you understand Clojure’s nature and write code harmonious to this nature, a new perspective on the art of programming and systems construction is revealed

; We strongly feel that if we show you the “why” of the language, then you’ll be better prepared to take that knowledge and apply it to your real-world problems.

; Goals:
; * Simplicity
; * Freedom to focus on the problem at hand
; * Empowerment

; Concepts that underlie the Clojure philosophy include:
; * Pure functions (Simplicity)
; ** Concise
; - Clarity and consistency
; * Empowerment
; ** Separation of concerns
; ** Expressiveness
; ** Deep interoperability
; ** Practical

; Simplicity
; It’s hard to write simple solutions to complex problems. But every experienced programmer has also stumbled on areas where we’ve made things more complex than necessary—what you might call incidental complexity as opposed to complexity that’s essential to the task at hand

; Clojure is built on the premise of providing a key set of simple (consisting of few, orthogonal parts) abstractions and building blocks that you can use to form different and more powerful capabilities.

; One example of incidental complexity is the tendency of modern object-oriented languages to require that every piece of runnable code be packaged in layers of class definitions, inheritance, and type declarations. Clojure cuts through all this by championing the pure function, which takes a few arguments and produces a return value based solely on those arguments. This means there’s less to think about when you’re trying to solve the problem at hand.

; Freedome to focus
; Writing code is often a constant struggle against distraction, and every time a language requires you to think about syntax, operator precedence, or inheritance hierarchies, it exacerbates the problem.

; Clojure tries to stay out of your way by keeping things as simple as possible, not requiring you to go through a compile-and-run cycle to explore an idea, not requiring type declarations, and so on. It also gives you tools to mold the language itself so that the vocabulary and grammar available to you fit as well as possible to your problem domain.

; Clojure is expressive. It packs a punch, allowing you to perform highly complicated tasks succinctly without sacrificing comprehensibility

; One key to delivering this freedom is a commitment to dynamic systems. Almost everything defined in a Clojure program can be redefined, even while the program is running: functions, multimethods, types, type hierarchies, and even Java method implementations. Although redefining things on the fly might be scary on a production system, it opens a world of amazing possibilities in how you think about writing programs. It allows for more experimentation and exploration of unfamiliar APIs, and it adds an element of fun that can sometimes be impeded by more static languages and long compilation cycles.

; Empowerment
; Rich Hickey has said on numerous occasions that Clojure has value to the degree that it lets you build interesting and useful applications.

; Clarity
; Clojure provides immutable locals and persistent collections, which together eliminate most of the single- and multithreaded issues.

; You can find yourself in several other kinds of muddles when the language you’re using merges unrelated behavior into a single construct. Clojure fights this by being vigilant about separation of concerns. When things start off separated, it clarifies your thinking and allows you to recombine them only when and to the extent that doing so is useful for a particular problem.

; Examples are:
; Objects with mutable fields, instead Clojure separates values from identity
; Classes act as namespace for methods, instead Clojure separates function namespaces from type namespaces
; Inheritance hierarchy made up of classes, instead hierarchy of names from data and functions
; Data and methods bound lexically, instead data objects from functions
; Method implementations embedded throughout the class inheritance chain, instead inheritance declarations from function implementations

; It can be hard at times to tease apart these concepts in your mind, but accomplishing it can bring remarkable clarity and a sense of power and flexibility that’s worth the effort. With all these different concepts at your disposal, it’s important that the code and data you work with express this variety in a consistent way.

; Consistency
; Clojure works to provide consistency in two specific ways: consistency of syntax and of data structures.

; Consistency of syntax is about the similarity in form between related concepts. E.g. for and doseq use the same syntax for input and output - so are easily interchangable and understandable. The value of this similarity is having to learn only one basic syntax for both situations, as well as the ease with which you can convert any particular usage of one form to the other if necessary.

; Likewise, the consistency of data structures is the deliberate design of all of Clojure’s persistent collection types to provide interfaces as similar to each other as possible, as well as to make them as broadly useful as possible. This is an extension of the classic Lisp “code is data” philosophy.

; Clojure data structures aren’t used just for holding large amounts of application data, but also to hold the expression elements of the application itself. They’re used to describe destructuring forms and to provide named options to various built-in functions. Clojure encourages the use of compatible map-like objects.

; The benefit of this is that the same set of functions designed to work with Clojure data structures can be applied to all these contexts: large data stores, application code, and application data objects. You can use into to build any of these types, seq to get a lazy seq to walk through them, filter to select elements of any of them that satisfy a particular predicate, and so on.

; Simplicity, freedom to focus, empowerment, consistency, and clarity—nearly every element of the Clojure programming language is designed to promote these goals.
