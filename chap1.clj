; namespaces are used to group related functions
(ns clojure-ddd.chap1))

; primatives
5
-5
3.14
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


; naming a variable, immutable
(def wife "Penny")
wife ; "Penny"

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
;; ists, vectors, maps, and sets,