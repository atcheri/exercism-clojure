(ns exercism.numbers.perfect-numbers)

(defn classify [n]
  (when
   (neg-int? n) (throw (IllegalArgumentException.)))
  (let [sum (->> (range 1 n)
                 (filter #(zero? (mod n %)))
                 (apply +))]
    (cond
      (= sum n) :perfect
      (> sum n) :abundant
      (< sum n) :deficient)))