(ns exercism.conditionals.triangle)

(defn is-valid?
  [a b c]
  (let [ordered (sort [a b c])]
    (and
     (not (some zero? ordered))
     (> (reduce + (take 2 (sort ordered))) (last (sort ordered))))))

(defn is-triangle-n?
  [a  b c n]
  (->> [a b c]
       set
       (#(= n (count %)))
       (and (is-valid? a b c))))

(defn equilateral?
  [a b c]
  (is-triangle-n? a b c 1))

(defn isosceles?
  [a b c]
  (and (is-valid? a b c) (or (= a b) (= a c) (= b c))))
  ;; (and (or (is-triangle-n? a b c 2) (is-triangle-n? a b c 3)) (or (= a b) (= a c) (= b c))))

(defn scalene?
  [a b c]
  (is-triangle-n? a b c 3))


;; (defn equilateral? [& sides]
;;   (and (apply is-valid? sides) (apply = sides)))

