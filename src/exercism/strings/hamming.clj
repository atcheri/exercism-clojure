(ns exercism.strings.hamming)

(defn distance
  [a b]
  (when (= (count a) (count b))
    (->>
     (map not= a b)
     (filter identity)
     count)))

(distance "ACT" "GGA")