(ns exercism.numbers.word-count
  (:require [clojure.string :as str]))

(defn word-count
  [s]
  (->> s
       (re-seq #"\w+")
       (map #(str/lower-case %))
       frequencies))

(word-count
 "That's the password: 'PASSWORD 123'!, cried the Special Agent.\nSo I fled.")