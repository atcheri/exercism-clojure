(ns exercism.strings.pangram
  (:require [clojure.string :as str]))


(defn pangram?
  [sentence]
  (= 26 (count
         (set (str/lower-case (str/replace sentence #"[^a-zA-Z]" ""))))))

(pangram? "The quick brown fox jumps over the lazy dog.")
