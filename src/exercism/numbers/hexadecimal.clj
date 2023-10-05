(ns exercism.numbers.hexadecimal
  (:require [clojure.math :refer [pow]]))

(def alphaNumericsMap (zipmap "0123456789abcdef" (range 16)))

(def alphaNumericsVect ["0" "1" "2" "3" "4" "5" "6" "7" "8" "9"
                        "a" "b" "c" "d" "e" "f"])
                    ;; "g" "h" "i" "j" "k" "l" "m"
                    ;; "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"

(defn char-to-int [c]
  (let [idx (.indexOf alphaNumericsVect c)]
    (cond
      (> idx -1) idx
      :else 0)))

(defn hex-to-int [colors]
  (if (not-every? #(contains? alphaNumericsMap %) colors) 0
      (->> colors
           reverse
           (map-indexed (fn [i c]
                          (* (char-to-int (str c)) (pow 16 i))))
           (apply +)
           (int))))


(contains? alphaNumericsMap "0")

(every? #(contains? alphaNumericsVect %) ["1"])


(hex-to-int "100")
(char-to-int (str "f"))
(hex-to-int "carrot")