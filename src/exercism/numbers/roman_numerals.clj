(ns exercism.numbers.roman-numerals
  (:require [clojure.math :as math]))

(def r-ones ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"])
(def r-tens ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"])
(def r-hundreds ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"])
(def r-thousands ["", "M", "MM", "MMM"])

(defn thousands
  [num]
  (get r-thousands (int (math/floor (/ num 1000)))))

(defn hundreds
  [num]
  (get r-hundreds (int (/ (math/floor (mod num 1000)) 100))))

(defn tens
  [num]
  (-> num
      (mod 100)
      (math/floor)
      (/ 10)
      (int)
      (#(get r-tens %))))

(defn ones
  [num]
  (-> num
      (mod 10)
      (int)
      (#(get r-ones %))))

(defn numerals [num]
  (str (thousands num) (hundreds num) (tens num) (ones num)))

(numerals 1)

