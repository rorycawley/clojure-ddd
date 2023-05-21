; Those are mechanisms for defining abstractions in Clojure

; Polymorphism
; Polymorphism is primarily used to create an abstraction that can be implemented in several ways.

; Polymorphism is a property of a function. When a function is polymorphic, its behavior will depend on the arguments you give to it.

; The most common type of polymorphism is type-based. In a language like Java, you call methods on objects. The object on which you call a method is an implicit first argument to the method, and the code that runs will depend on the type of that object.

; dispatch
; The decision about which code to run is called dispatch. Aside from type-based dispatch on the first argument, dispatch could also consider the number of arguments, the type of each of the arguments, and so on.

; In Clojure, polymorphism refers to a function's behavior being dependent on the arguments it receives. Polymorphic functions can exhibit different behaviors based on the types of the arguments provided. This is similar to how object-oriented languages like Java use type-based dispatch, where the method to execute depends on the type of the object on which the method is called. In Clojure, dispatch can also consider factors such as the number and types of arguments. Dispatch determines the specific code to execute based on these factors.

; defmulti
; defmulti is a way to define a function with multiple behaviors based on its arguments, making your code more flexible and concise. A multimethod is the most general type of dispatch. You can decide how the dispatch will be performed by providing a dispatch function, and this dispatch function can run arbitrary Clojure code.

; When you use defmulti, you're telling Clojure that you want to define a function that can do different things based on the value of its arguments. Instead of writing separate functions for each case, you can define a single function and specify different behaviors for different values or types of arguments. Clojure will automatically figure out which implementation to use based on the dispatch value you provide when calling the function.

; Here are a few scenarios where defmulti can be useful:
; Polymorphic Behavior: When you want a single function to exhibit different behaviors based on the value or type of its arguments, defmulti provides a clean and concise way to achieve polymorphism. It allows you to define multiple implementations for different cases without having to write separate functions.

; Domain-Specific Dispatch: If you are working on a domain-specific problem where dispatching behavior based on certain characteristics or properties is essential, defmulti can be helpful. It allows you to encapsulate the dispatch logic within the function itself, making the code more cohesive and easier to understand.

; Extensibility: defmulti can enhance the extensibility of your code. It allows other developers to add new implementations or extend the behavior of your function by providing their own dispatch values and associated implementations. This can facilitate modular and flexible code design.

; Code Organization: By using defmulti, you can group related functions and their corresponding implementations in a structured manner. This can improve code organization and make it easier to navigate and maintain.

; However, it's worth noting that defmulti introduces some additional complexity, especially if you are not familiar with the concept of multimethods or the dispatch mechanisms in Clojure. If simpler approaches like conditional branching or higher-order functions can meet your requirements, you may not need to use defmulti.

; Consider factors such as extensibility, readability, and maintainability when determining whether to use defmulti in your Clojure projects.

; defprotocol
; A protocol function is a very specific (but common) dispatch. A protocol function will dispatch on the type of its first argument

; defprotocol is a special keyword in Clojure used to define a protocol, which is a way to declare a set of related functions that define a common behavior or interface.

; When you use defprotocol, you're defining a blueprint or contract for a group of functions. It specifies the names and argument signatures of the functions that should be implemented by any type or data structure that wants to adhere to the protocol. Essentially, you're defining what methods or behaviors an object should have.

; Think of a protocol as a set of guidelines or requirements that different objects can follow. It allows you to define a common behavior that can be implemented by different types or structures, making your code more modular and reusable.

; By defining a protocol, you can create polymorphic code where different objects can respond to the same functions but with their own specific implementations. This enables you to write more flexible and generic code that can work with a variety of data structures or types.

; defprotocol is used to declare a set of functions that define a common behavior, allowing different objects to adhere to the protocol and provide their own implementations. It promotes code reuse and modularity by defining a clear contract for objects to follow.

; Whether or not to use defprotocol in your Clojure code depends on the specific needs and design of your application. Here are a few considerations to help you decide:

; Common Behavior: If you have a group of related functions that should be implemented by different types or structures to exhibit a common behavior, defprotocol can be beneficial. It allows you to define a clear contract or interface that ensures consistency among implementations.

; Polymorphism: If you want to write polymorphic code where different objects can respond to the same functions but with their own specific implementations, using defprotocol can be a good choice. It enables you to write generic code that works with multiple types or structures that adhere to the protocol.

; Modularity and Code Organization: defprotocol helps in organizing your code by separating the protocol definition from the actual implementations. It promotes modularity, making it easier to understand and maintain your codebase.

; Reusability: If you anticipate the need for code reuse across different types or structures, using defprotocol can be advantageous. It provides a reusable blueprint or contract for implementing common behaviors across various parts of your application.

; However, it's important to note that protocols introduce some additional complexity to your code. If you have a simple scenario where conditional branching or higher-order functions can meet your requirements, using protocols might be overkill. Consider the trade-offs, the complexity of your application, and the likelihood of future extensibility when deciding whether to use defprotocol.

; In summary, consider using defprotocol when you need to define a common behavior across multiple types or structures, promote polymorphism, improve code modularity, and enable code reuse. Evaluate whether these benefits outweigh the added complexity and overhead in your specific use case.


; You also have a few options for implementing abstractions

; reify
; Using reify, you can implement protocols and interfaces as an anonymous class. You cannot define fields, but the reified class is a closure and you can capture an atom or something appropriate from the context.

; In Clojure, reify is a special form used to create anonymous implementations of protocols or interfaces. It allows you to define and instantiate an object with specific behavior without explicitly defining a named type or structure.

; Here's a simple explanation:
; When you use reify, you're creating an anonymous object that implements one or more protocols or interfaces. It provides a way to define the required functions directly within the reify block. This allows you to have fine-grained control over the behavior of the object without the need to define a separate named type.

; reify is commonly used in situations where you need to implement a protocol or interface for a specific context or to fulfill a particular need, without the intention of reusing the implementation elsewhere. It's particularly useful for short-lived or one-off implementations.

; An example usage of reify would be implementing a protocol within a specific function scope, where the implementation is tightly coupled with that function's logic.

; In summary, reify provides a way to create anonymous objects that implement protocols or interfaces. It allows you to define the required behavior inline, without the need for a named type. It is useful for cases where you need a specific implementation within a limited context or for short-lived objects.

; deftype
; deftype generates a class that implements several protocols and interfaces. A deftype is not a closure, but it can have fields (including mutable fields)

; When you use deftype, you're defining a new named type or structure with specific fields and associated functions. It lets you create your own custom data type that can hold data and perform operations on that data.

; The deftype form allows you to specify the fields of the type along with their types. You can also define methods or functions that operate on instances of the type. These methods can be defined using the defmethod or defmulti special forms.

; Once defined, you can create instances of the defined type using the constructor function that is automatically generated. You can access and manipulate the fields of an instance using the dot notation.

; Using deftype provides you with more control and flexibility compared to using the built-in data structures like maps or vectors. It allows you to create custom data structures with their own behaviors and operations tailored to your specific needs.

; defrecord
; defrecord defrecord generates a new immutable, "map-like" data structure.

; A defrecord is also not a closure, but you can define immutable fields, and implement several protocols and interfaces. A defrecord can be used as a map, destructured like a map, have additional keys associated with it, and so on.

; defrecord is a special form used to define a new named type or structure, similar to deftype. However, defrecord is specifically designed for creating immutable data structures with a predefined set of fields.

; When you use defrecord, you're defining a new named type or structure with a fixed set of fields. The fields of a record are immutable, meaning their values cannot be changed once the record is created. This immutability is a distinguishing feature of defrecord compared to deftype, which allows mutable fields.

; Similar to deftype, defrecord lets you specify the fields of the record along with their types. It automatically generates constructor functions, getter functions for accessing the fields, and implements various protocols like clojure.lang.IObj, clojure.lang.IPersistentMap, and others.

; Records in Clojure are typically used to represent data entities or stateful objects in a functional and immutable manner. They provide a convenient way to define structured data and carry associated metadata or behavior.

; Instances of a record can be created using the constructor function generated by defrecord. You can access the fields of a record using the provided getter functions, which follow a naming convention of ->field or field.

; In summary, defrecord is used to define a new named type or structure with immutable fields. It is suitable for creating data entities or stateful objects in a functional and immutable manner. Records provide convenient accessors and protocols to work with the data.

; This collection of features, common to both Clojure and ClojureScript, is a very flexible way to define and implement abstractions.

; Service Abstraction
; Polymorphism is primarily used to create an abstraction that can be implemented in several ways. An abstraction that I have created many times is a service abstraction. 

; For instance, you may want to define a storage service abstraction modeled as a key-value store for binary objects. You could then implement it for S3, CloudFiles, and Azure. For use in tests, you could even implement a local filesystem backend.

; My abstraction will consist of five functions: connect, get, put, delete, and close. You call connect to construct a service object. The service object will be used with get to fetch an object from the store, put to store an object in the store, delete to delete an object from the store, and close to clean up the service object.

; plain functions could be used
; An abstraction can be defined and implemented using only plain functions. In this case, the abstraction is not explicit in the code, but is based on using conventional names for definitions.

; A variation on using plain functions would be to return a map that contains the implementation functions

; You could define the abstraction with multimethods

; You could use protocol to define the abstraction

; You could use a protocol to define the abstraction, except connect, which is a multimethod

; These approaches can be analyzed along a few different dimensions:
;   code elasticity
;   separation of concerns
;   dynamism
