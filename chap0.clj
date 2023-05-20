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

