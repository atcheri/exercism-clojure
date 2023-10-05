(ns exercism.arrays.gigasecond
  (:require [clojure.core])
  (:import [java.time LocalDateTime]))

(defn from [y m d]
  (let [d (.toLocalDate (.plusSeconds (LocalDateTime/of y m d 0 0) 1e9))]
    [(.getYear d) (.getMonthValue d) (.getDayOfMonth d)]))