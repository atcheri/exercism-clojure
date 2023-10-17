(ns exercism.numbers.pascals-triangle)

(def triangle
  (iterate #(concat [1] (map +' % (rest %)) [1]) [1]))

(defn row [size]
  (nth triangle (dec size)))

(rest '[1 2 1])
(map +' '[3 2 1] (rest '[1 2 1]))