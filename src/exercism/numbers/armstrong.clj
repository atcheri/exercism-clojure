(ns exercism.numbers.armstrong
  (:require
   [clojure.math :refer [log10 ceil pow]]
   [clojure.string :as str]))

(defn orderOfMagnitude
  [num]
  (int (ceil (log10 num))))

(defn powerOf
  [num p]
  (pow p num))

(defn powerOfP
  [p]
  (fn [num] (pow num p)))

(defn numToIntSlice
  [num]
  (vec (map read-string
            (-> num
                (str)
                (str/split #"")))))


(defn armstrong
  [num]
  (cond
    (= 0 num) 0
    :else
    (let [mag (orderOfMagnitude num)]
      (->> num
           (numToIntSlice)
           (map (powerOfP mag))
          ;;  (reduce +)
          ;;  (bigint)
           ))))

;; (defn armstrong?
;;   [num]
;;   (= num (armstrong num)))

(defn armstrong?
  [n]
  (->> (str n)
       seq
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str n)) %)))
       (reduce +)
       (= n)))

(armstrong 21897142587612075)
(armstrong 153)


((powerOfP 2) 10)