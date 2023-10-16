(ns exercism.strings.isogram
  (:require [clojure.string :as str]))

(defn isogram? [word]
  (->> word
       (str/lower-case)
       (filter #(Character/isLetter %))
       (frequencies)
       (vals)
       (every? #(= % 1))))
