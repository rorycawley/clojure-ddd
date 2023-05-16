;; for Clojure, there are some principles and practices that can be followed for Clojure programming. Here are a few key principles:

;; Immutability: Clojure encourages immutability as a fundamental principle. Immutable data structures and values are preferred, which helps ensure code clarity, simplicity, and thread-safety. By default, Clojure data structures are immutable, and functional programming techniques are leveraged to perform transformations on immutable data.

;; Higher-order functions: Clojure emphasizes the use of higher-order functions, which are functions that can take other functions as arguments or return functions as results. This enables writing concise and expressive code by composing functions and promoting code reuse.

;; Polymorphism through protocols and multi-methods: Clojure provides mechanisms such as protocols and multi-methods to achieve polymorphism. Protocols allow you to define behaviors for different types, enabling polymorphic behavior. Multi-methods provide a way to define different behavior based on the runtime type of arguments.

;; Data-oriented design: Clojure encourages a data-oriented design approach, where data is structured and transformed using immutable data structures and functions. This promotes clarity, testability, and composability of code.

;; Composability and separation of concerns: Clojure promotes the composition of functions and the separation of concerns. By breaking down problems into smaller, composable functions, code becomes more modular and easier to understand and test.

; namespaces are used to group related functions
; conventions are:
; - namespaces are lowercase
; - namespaces are separated by periods
; - namespaces are the same as the directory structure
; - namespaces are the same as the file name
; lowercase
; hyphen separated words
; no underscores
; choose a name that accurate refects the domain or purpose of the code within the namespace
; ensure it's unique
(ns chap1)

; First setup the REPL
; REPL is the way to code in Clojure

; a form is a valid Clojure expression, expressions evaluate to a value
; a form can be a literal value

; a form can be a list, vector, map, set, or a symbol
; a symbol is a name that refers to something else
; a symbol can be a variable, function, or a namespace
; a symbol can be used as a function if it is followed by a list of arguments
; a symbol can be used as a variable if it is not followed by a list of arguments

; primatives
5
-5
3.14
1/5 ; fraction
true
false
\a ; character a
\n ; newline
\b ; backspace
\r ; character r
\" ; double quote
\t ; tab"
- ; minus
+ ; plus
"Rory" ; string
'hello' ; symbol
:good ; keyword
nil ; null
(+ 1 1)

; naming binds a name to a value
; bind is used rather than assign because the value is immutable
; naming a variable, immutable
(def wife "Penny")
wife ; "Penny"
(def wife "Rory") ;; this will throw an error


; list - ordered collections, immutable
'(1 2)
(list 1 2)
(def my-list '(1 2))
my-list ; (1 2)
'(2.3 "hell" 2 :fun 'helo')

; vector, lists with random index access, immutable
[1 2]
(def my-vec [1 2])
[2.3 "hell" 2 :fun 'helo']

; map, key value pairs (both keys and values can be any type), immutable
{:name "Rory" :age 30}

; set, unordered collection of unique values, immutable
; they use hash based data structures, so they are fast to search
; can contain any type of element
#{1 2 3 4 5}
(def my-set #{1 2 3 4 5})
my-set
#{1.2 "hello" :fun 'helo' '(123)}

; sequence, ordered collection of elements
; can be created from lists, vectors, maps, and sets
; can be created from strings
(seq "hello") ; ("h" "e" "l" "l" "o")
(seq [1 2 3]) ; (1 2 3)
(seq {:name "Rory" :age 30}) ; ([:name "Rory"] [:age 30])
(seq #{1 2 3}) ; (1 2 3)
(seq '(1 2 3 4 5)) ; (1 2 3 4 5)

; functions
(defn my-func [x y] (+ x y))
(my-func 1 2) ; 3

(defn greeting [name] (println "Hello " name))
(greeting "Rory") ; Hello Rory

; built-in functions
(println "Hello World") ; Hello World


; anonymous functions
(fn [x y] (+ x y))
((fn [x y] (+ x y)) 1 2) ; 3

((fn [a b] (* a b) 1 2)) ; 2
; vs
(defn my-func1 [a b] (* a b))
(my-func1 1 2) ; 2

(def my-func2 (fn [a b] (+ a b)))
(my-func2 1 2) ; 2

; string concatenation
(str "Hello" " " "Rory") ; Hello Rory

; conditional
(if true
  "Rory"
  "Penny")

(if false
  "Rory") ; nil

; put multiple forms together
(do
  (println "Hello")
  (println "Rory")
  "rory") ; Hello Rory

(if true
  (do
    (println "Hello")
    (println "Rory")
    "rory")) ; nil

; when is like if and do at the same time
; use it when you want to do multiple things when the condition is true
(when true
  (println "Hello")
  "Goodbye") ; nil

; nil
; nil is the absence of a value
; nil is falsey
; nil is not the same as false
; nil is not the same as an empty string
; nil is not the same as an empty list
; nil is not the same as an empty vector
; nil is not the same as an empty map
; nil is not the same as an empty set
; nil is not the same as zero
; nil is not the same as an empty sequence
; nil is not the same as an empty function
; nil is not the same as an empty symbol
; nil is not the same as an empty keyword
(nil? nil) ; true - only nil is nil
; in a conditional nil is falsey, so it will evaluate to false
(nil? 0) ; false
(if nil
  "Rory"
  "Penny") ; Penny

(def my-var nil)
(if my-var
  "Rory"
  "Penny") ; Penny


; equality
(= 1 1) ; true
(= nil nil) ; true
(= 1.0 1) ; true

; boolean operators, or returns last value if all are false or first true value
(or 1)
(or nil)
(or nil false) ; false
(or 1 2) ; 1
(or nil 1 false nil) ; 1
(or nil nil nil false nil) ; nil

(or (= 1 0) (= 1 1)) ; true

; and returns first false value or last true value
(and :free_wifi) ; :free_wifi
(and 1) ; 1
(and nil 1) ; nil
(and 1 2 3) ; 3

; maps
; hashmaps are the most common
; effeciency is O(log32 n) for lookup, assoc, dissoc, and contains?
; no order is guaranteed
{}; empty map
(def map1 {:first "one"})
(:first map1) ; one
(map1 :first) ; one
(:second map1) ; nil
(def foo1 {:rory "50" :penny 49})
(foo1 :rory)

{"string-key" +} ; map values can be any values
; map keys can be any values except nil
; map keys are unique
; map keys are not ordered
; map keys are not sorted
; map keys are not sorted by insertion order
; map keys are not sorted by value
; map keys are not sorted by key
; map keys are not sorted by key length
; map keys are not sorted by key type
; map keys are not sorted by key value
; map keys are not sorted by key hash


; apart from literals we can use hash-map to create maps
(hash-map :name "Rory" :age 30) ; {:age 30, :name "Rory"}
(get {:name "Rory" :age 30} :name) ; "Rory"
({:name "Rory" :age 30} :name)  ; "Rory" using the map as a function

(get {:name "Rory" :now {:age 30}} :age) ; nil (cannot do nested lookup with get)
(get-in {:name "Rory" :now {:age 30}} [:now :age]) ; 30 nested lookup

; default value
(get-in {:name "Rory" :now {:age 30}} [:now :poo] "Cannot find it") ; 30 nested lookup


; sorted maps
; effeciency is O(log32 n) for lookup, assoc, dissoc, and contains?
; sorted by keys
(sorted-map :name "Rory" :age 30) ; {:age 30, :name "Rory"}

; maps are immutable but you can transform them into new maps
; new maps can be created by merging maps with new key value pairs
(def my-map {:name "Rory" :age 30})

; Both of these forms retrieve the 
; value associated with the key :name from the map my-map.
(get my-map :name) ; "Rory"
(:name my-map) ; "Rory"

; default value
(get {:a 0 :b 1} :c "unicorns?") ; "unicorns?"

; Hash maps are typically used when the order of entries is not 
; important, and fast access by key is the primary concern. 
; Sorted maps are used when you need entries to be sorted based on 
; keys or when you require operations like range queries or ordered 
; traversal.

; keywords
; keywords are like strings but they are more efficient
; keywords are interned, meaning that there is only one copy of each keyword
; keywords are used as keys in maps
; keywords are used as functions to look up values in maps
; keywords are used as functions to look up values in vectors
; keywords are used as functions to look up values in sets
; keywords are used as functions to look up values in lists
; keywords are used as functions to look up values in sequences
:a
:34
:_?
(:a {:a 1}) ; 1
(get {:a 1} :a) ; 1


; vectors
; vectors are like lists but they are more efficient
; vectors are indexed by integers
; vectors are used as functions to look up values in maps
; vectors are used as functions to look up values in vectors
[1 2 3]
([1 2 3] 1)
(get [1 2 3] 1) ; 2
(get [2 {:foo "bar"}] 1) ; {:foo "bar"}
(vector 1 2 3) ; [1 2 3]
(conj [1 2 3] 4) ; [1 2 3 4]

; Vectors aren’t the only way to store sequences; Clojure also has lists.
; lists
; lists are like vectors but they are more efficient
; you cannot use get with lists
'(1 2 3) ; (1 2 3)
(nth '(1 2 3) 1) ; 2

; using nth to retrieve an element from a list is slower than using get to retrieve an element from a vector. This is because Clojure has to traverse all n elements of a list to get to the nth, whereas it only takes a few hops at most to access a vector element by its index.
(list 1 2 3) ; (1 2 3)
(list "hello" :bar 3) ; ("hello" :bar 3)

; conj adds to the front of a list
(conj '(1 2 3) 4) ; (4 1 2 3)

; if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list. Otherwise, you should use a vector.

; sets
; sets are like maps but they are more efficient
; sets are used to store unique values
#{1 2 3}
#{"hello" :bar 3}
(hash-set 1 2 3) ; #{1 2 3}
(conj #{1 2 3} 4) ; #{1 2 3 4}
(conj #{:a :b} :b) ; #{:a :b}
(set [1 2 2]) ; #{1 2 3}
(set '(1 2 3)) ; #{1 2 3}
(set {:a 1 :b 2}) ; #{[:a 1] [:b 2]}

(contains? #{:a :b} :a) ; true
(get #{:a :b} :a) ; :a
(get #{:a :b} :c "not found") ; :a
(get #{nil} nil)
; Notice that using get to test whether a set contains nil will always return nil, which is confusing. contains? may be the better option when you’re testing specifically for set membership.
(contains? #{nil} nil)
(contains? #{:a :b} 3)
(:a #{:a :b}) ; :a (using a keyword as a function to look up a value in a set)
(:c #{:a :b}) ; nil
(:c #{:a :b} :not-found) ; :not-found
(#{:a :b} :a) ; :a (using a set as a function to look up a value in a set)
(#{:a :b} :c) ; nil
(#{:a :b} :c :not-found) ; :not-found

; You may have noticed that the treatment of data structures so far doesn’t include a description of how to create new types or classes. The reason is that Clojure’s emphasis on simplicity encourages you to reach for the built-in data structures first.

; If you come from an object-oriented background, you might think that this approach is weird and backward. However, what you’ll find is that your data does not have to be tightly bundled with a class for it to be useful and intelligible.