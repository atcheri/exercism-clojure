(ns exercism.numbers.strain)

(defn retain [pred coll]
  (for [c coll :when (pred c)] c))

(defn discard [pred coll]
  (retain (complement pred) coll))
