(ns exercism.strings.bob
  (:require [clojure.string :as str]))

(defn response-for
  [question]
  (cond
    (= "?" (str (last question))) "Sure."
    (every? #(Character/isUpperCase %) question) "Whoa, chill out!"
    (and
     (= "!" (str (last question)))
     (every? #(Character/isUpperCase %) question)) "Whoa, chill out!"

    :else "Whatever."))

(def silence? str/blank?)
(def shouting? #(re-matches #"(?=.*[A-Z])[^a-z]+" %))
(def question? #(re-find #"\?\s*$" %))
(def shouting-question? (every-pred shouting? question?))
(defn response-for [s]
  (cond (silence?           s) "Fine. Be that way!"
        (shouting-question? s) "Calm down, I know what I'm doing!"
        (shouting?          s) "Whoa, chill out!"
        (question?          s) "Sure."
        :else                  "Whatever."))