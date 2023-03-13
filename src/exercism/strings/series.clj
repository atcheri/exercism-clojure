(ns exercism.strings.series
  (:require [clojure.string :as str]))

(defn slices
  [string length]
  (if (zero? length) (identity [""])
      (->> string
           (partition length 1)
           (map #(str/join "" %))
           (filter not-empty)
           (vec))))

(slices "49142" 3)