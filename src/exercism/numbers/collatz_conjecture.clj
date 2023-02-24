(ns exercism.numbers.collatz-conjecture)


;; (defn collatz-double
;;   [num]
;; ;;   (println (double (/ num 2)))
;;   (double (/ num 2)))

;; (defn collatz-triple
;;   [num]
;;   (println num)
;;   (println (inc (* 3 (double (/ num 2)))))
;;   (inc (* 3 (double (/ num 2)))))



(defn collatz [n]
  (if (< n 1)
    (throw (IllegalArgumentException. (str "invalid n: " n)))
    (reduce (fn [n i]

              (cond
                (= n 1) (reduced i)
                (odd? n) (inc (* n 3))
                :else (/ n 2)))
            n
            (range))))


(collatz 1)
(collatz 16)