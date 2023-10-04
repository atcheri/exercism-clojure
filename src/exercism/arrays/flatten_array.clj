(ns exercism.arrays.flatten-array)

(defn flatten [arr] ;; <- arglist goes here
  (remove nil? (clojure.core/flatten arr)))
