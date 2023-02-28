(ns exercism.numbers.nth-prime)

(defn divisible
  [num]
  (reduce (fn [a i]
            (cond
              (or (= 0 (mod num i)) (= 0 (mod num (+ 2 i)))) (reduced false)
              :else true))
          0
          (range 5 (* num num) 6)))

(defn prime-old?
  [num]
  (cond
    (<= num 1) false
    (<= num 3) true
    (or (= 0 (mod num 2)) (= 0 (mod num 3))) false
    (divisible num) false
    :else true))

(defn prime? [n]
  (->> (range 2 (Math/sqrt (inc n)))
       (map #(mod n %))
       (every? pos?)))

(defn increment
  [n c]
  (println "the accumulator is:" n "and the number tested is" c)
  (inc n))

(defn nth-prime-old
  [num]
  ;; (when (zero? n) (throw (IllegalArgumentException.)))
  (if (= 0 num) (throw (IllegalArgumentException.))
      (cond
        (= 1 num) 2
        (= 2 num) 3
        (= 3 num) 5
        :else (reduce (fn [a c]
                        (cond
                          (prime? c) (inc a)
                          (= a num) (reduced (dec c))
                          ;; (= a 100) (reduced -5)
                          :else a))
                      3
          ;; (range 5 num 6)
                      (iterate (partial inc) 6)))))
(defn nth-prime [n]
  (when (zero? n) (throw (IllegalArgumentException.)))
  (nth (filter prime? (iterate inc 2)) (dec n)))

(iterate (partial inc) 3)
(nth-prime 10001)
;; (nth-prime 7)
