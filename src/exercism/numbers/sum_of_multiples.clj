(ns exercism.numbers.sum-of-multiples)

(defn is-multiple?
  [base multiplier]
  (zero? (mod base multiplier)))

(defn are-multiple?
  [base multipliers]
  (some #(is-multiple? base %) multipliers))

(defn sum-of-multiples
  [multipliers n]
  (->> (range 1 n)
       (filter #(are-multiple? % multipliers))
       (reduce +)))


(defn sum-of-multiples+
  [multipliers n]
  (->> multipliers
       (mapcat #(range 0 n %))
       set
       (reduce +)))

(sum-of-multiples '(3 5) 4)