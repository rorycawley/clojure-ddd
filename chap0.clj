; FP
; functional programming is a style of programming that emphasizes the evaluation of expressions, rather than execution of commands.
; Functional programming concerns and facilitates the application and composition of functions.
; Further, for a language to be considered functional, its notion of function must be first-class.First-class functions can be stored, passed, and returned just like any other piece of data.

; Clojure further supports a style of functional programming that includes such topics as purity, immutability, recursion, laziness, and referential transparency

; OO vs FP
; Object-oriented programmers and functional programmers often see and solve a problem in different ways. Whereas an object-oriented mindset fosters the approach of defining an application domain as a set of nouns (classes), the functional mind sees the solution as the composition or verbs (functions) .

; Although both programmers may generate equivalent results, the functional solution will be more succinct, understandable, and reusable.

; It takes a shift in mindset to go from thinking in nouns to thinking in verbs,

; Elegance and familiarity are orthogonal.
; Elegance and familiarity are orthogonal concepts, meaning that they are independent of each other. 
; The elegance of a solution refers to its simplicity, efficiency, and aesthetic appeal, while familiarity relates to how well-known or understood something is. 
; A solution can be elegant but unfamiliar, requiring a learning curve to grasp, while a familiar approach may lack elegance and be less efficient. 
; It is important to recognize that a solution can possess elegance without being immediately familiar, and a familiar solution may not necessarily be the most elegant or effective. 
; Evaluating and designing solutions should consider both elegance and familiarity separately, taking into account the specific requirements and trade-offs of the problem at hand.

; Clojure was born out of frustration provoked in large part by the complexities of concurrent programming, complicated by the weaknesses of object-oriented programming in facilitating it.

; time
; Simply put, time refers to the relative moments when events occur. Over time, the properties associated with an entity—both static and changing, singular or composite - will form a concrescence, or, in other words, its identity.
; It follows that at any given time, a snapshot can be taken of an entity’s properties, defining its state.
; This notion of state is an immutable one because it’s not defined as a mutation in the entity itself, but only as a manifestation of its properties at a given moment in time.

; In simple terms, the statement explains that time is a measure of when events happen in relation to each other. 
; As time progresses, an entity develops certain properties, which can be either unchanging or subject to change. These properties, whether they are individual or a combination of multiple aspects, come together to form the identity or essence of that entity. 
; This process of properties shaping an entity's identity is referred to as concrescence. Essentially, the statement highlights the role of time in the development and formation of an entity's identity through the accumulation of its properties.

; Think of time as a way of marking the moments when events happen. It helps us understand the sequence of events and how they relate to each other. As time progresses, things can change or remain the same. When it comes to an entity, like a person, their identity is formed through the combination of various properties and characteristics. These properties can be static (unchanging) or dynamic (changing) . For example, a person's identity is shaped by their physical appearance, personality traits, skills, experiences, and relationships. Over time, as they go through different experiences and acquire new qualities, their identity becomes more defined and solidified. This process of the properties coming together to form an individual's unique identity is what we call concrescence. In essence, time plays a significant role in the development and shaping of an individual's identity.

; "Concrescence" is a term coined by the philosopher Alfred North Whitehead to describe the process of things coming together or merging to form a unified whole

; Clojure embraces the idea of combining and transforming data using various functions like map, reduce, filter, and so on. These functions enable the transformation and aggregation of data, which can be seen as a form of combining or merging data elements to create new values or structures.

;  in  object-oriented programming (OOP), there’s no clear distinction between state and identity. In other words, these two ideas are conflated into what’s commonly referred to as mutable state.
; The classical object-oriented model allows unrestrained mutation of object properties without a willingness to preserve historical states.

; Clojure’s implementation attempts to draw a clear separation between an object’s state and identity as they relate to time.
; Immutability lies at the cornerstone of Clojure, and much of the implementation ensures that immutability is supported efficiently

; By focusing on immutability, Clojure eliminates the notion of mutable state (which is an oxymoron) and instead expounds that most of what’s meant by objects are instead values.
; Value by definition refers to an object’s constant representative amount, magnitude, or epoch

; by adhering to a strict model of immutability, concurrency suddenly becomes a simpler (although not simple) problem, meaning if you have no fear that an object’s state will change, then you can promiscuously share it without fear of concurrent modification.

; Clojure instead isolates value change to its reference types. Clojure’s reference types provide a level of indirection to an identity that can be used to obtain consistent, if not always current, states.

; Clojure instead focuses on functional programming, immutability, and the distinction between state, time, and identity

; OO in Clojure
; There are powerful aspects of OOP and they’re adopted and, in some cases, improved by Clojure
; Clojure’s flavor of polymorphism, expressed via its protocol feature
; Protocols are somewhat related to Java interfaces and a distillation of what are commonly known as mix-ins.


; Polymorphism in Clojure
; Polymorphism is the ability of a function or method to perform different actions depending on the type of its arguments or a target object. Clojure provides polymorphism via protocols,
; let you attach a set of behaviors to any number of existing types and classes; they’re similar to what are sometimes called mix-ins, traits, or interfaces in other languages and are more open and extensible than polymorphism in many languages.
; you can define a protocol that groups a set of behaviours expressed with functions and any object that satisfies the protocol will have these behaviours and their implementations can be substituted for each other. Dependency injection. We can extend an existing type to satisfy a protocol, or we can define a new type that satisfies a protocol. This is similar to the concept of dependency injection, where we can inject a dependency into a class by implementing an interface.
; because they are like mix-ins you can have an existing object, then define a new protocol and attach it to the existing object. This is similar to the concept of open classes in Ruby, where you can open an existing class and add new methods to it.

; Clojure provides a form of subtyping by allowing the creation of ad hoc hierarchies: inheritance relationships you can define among data types or even among symbols, which let you easily use the principles of polymorphism
; By defining a logically grouped set of functions, you can begin to define protocols to which data-type abstractions must adhere. This abstraction-oriented programming model is key in building largescale applications

; Encapsulation in Clojure
; If Clojure isn’t oriented around classes, then how does it provide encapsulation?
; Clojure has closures, and closures are an excellent way to group functions with their supporting data.
; Clojure’s namespace encapsulation is the most prevalent form of encapsulation that you’ll encounter in Clojure code. But the use of lexical closures provides another option for encapsulation: block-level encapsulation and local encapsulation, both of which effectively aggregate implementation details within a smaller scope.

; When possible, it’s a good idea to aggregate relevant data, functions, and macros at their most specific scope. high cohesion.

; Within this body, we then define the lookup function, thus limiting the client exposure to the chessboard API and hiding the implementation-specific functions and forms. But we can further limit the scope of the encapsulation

; Another downside to OOP is the tight coupling between function and data. Java and C# force you to build applications entirely from class hierarchies, restricting all functionality to containing methods in a highly restrictive “Kingdom of Nouns”

; This environment is so restrictive that programmers are often forced to turn a blind eye to awkward attachments of inappropriately grouped methods and classes. It’s because of the proliferation of this stringent object-centric viewpoint that Java code tends toward being verbose and complex

; Many of what programmers perceive to be classes are data tables that Clojure provides via maps and records

; The final strike against viewing everything as an object is that mathematicians view little (if anything) as objects. Instead, mathematics is built on the relationships between one set of elements and another through the application of functions.

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
