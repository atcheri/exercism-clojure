(ns exercism.strings.reverse
  (:require [clojure.string :as str]))

(defn reverse-string [s]
  (-> s
      (reverse)
      (str/join)))

(reverse-string "ab")