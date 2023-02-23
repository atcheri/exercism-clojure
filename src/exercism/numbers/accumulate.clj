(ns exercism.numbers.accumulate)

;; (defn accumulate [nums]
;;   (->> nums
;;        (map (fn [n] (* n n)))
;;        (vec)))

(defn square [x]
  (* x x))

(defn accumulate [operation nums]
  (vec (for [x nums]
         (operation x))))

(accumulate square [1,2,3])
(accumulate square [])