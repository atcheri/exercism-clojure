(ns exercism.misc.raindrops)

(defn divisibleByN
  [n a]
  (zero? (mod a n)))

(def divisibleBy3 (partial divisibleByN 3))
(def divisibleBy5 (partial divisibleByN 5))
(def divisibleBy7 (partial divisibleByN 7))

(defn convert [integer]
  (cond-> nil
    (divisibleBy3 integer) (str "Pling")
    (divisibleBy5 integer) (str "Plang")
    (divisibleBy7 integer) (str "Plong")
    :else (or (str integer))))