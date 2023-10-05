(ns exercism.numbers.grains)

(defn square [n]
  (cond-> n
    (< 2 n) (->> dec (.pow (biginteger 2)))))

(defn total []
  (->> (range 1 65)
       (map square)
       (apply +)))


(square 4)
(square 32)
(= 9223372036854775808 (square 64))