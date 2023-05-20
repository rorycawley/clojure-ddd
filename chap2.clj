; clojure spec an attempt to apply some validation to data and functions, without compromising Clojure’s dynamism and data-is-data philosophy

; this is a keyword:  :a-keyword
; this is a namespce-qualified keyword:  :a-namespace/a-keyword
; this is a short form of a namespaced keyword:  ::a-keyword, see below:
; (ns my-namespace) ::a-keyword ; namespaced keyword ::my-namespace/a-keyword

; creating a spec for the domain model creates useful documentation
