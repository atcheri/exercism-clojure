(ns exercism.strings.pig-latin
  (:require
   [clojure.set :refer [difference]]
   [clojure.string :as str]))

(def alphabet #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})
(def vowels #{\a \e \i \o \u})
(def vowels-regex (re-pattern (str "^(yt|xr|[" (apply str vowels) "])(.*)")))

(def consonants (difference alphabet vowels))
(def consonants-regex (re-pattern (str "^(sch|ch|qu|thr|th|rh|[" (apply str consonants) "](?:qu)?)(.*)")))

(defn word->piglatin [word]
  (let [[_ vowel _] (re-matches vowels-regex word)
        [_ consonant rest] (re-matches consonants-regex word)]
    (cond
      (some? vowel) (str word "ay")
      (some? consonant) (str rest consonant "ay")
      :else word)))

(defn translate [sentence]
  (str/join " " (map word->piglatin (str/split sentence #" "))))

(def vowels (set '("a" "b" "c" "d")))
(def startsWithVowelRegExp #"(?i)\b[aeiou]\w*")
(def startsWithNonVowelRegExp #"(?i)\b[^aeiou]\w*")
(def startsWithVowelAndQURegExp #"(?i)\b[aeiou]qu\w*")

(re-matches #"(?i)\bch\w*" "chair")

(defn moveConsonentToEnd
  [word]
  (str (str/join "" (rest word)) (first word)))

(defn translate-old
  [word]
  (cond
    (re-matches #"(?i)^ch\w*" word) (str (str/join "" (drop 2 word)) (subs word 0 2) "ay")
    (re-matches startsWithNonVowelRegExp word) (str (moveConsonentToEnd word) "ay")
    (re-matches startsWithVowelRegExp word) (str word "ay")
    :else ""))


(translate "apple")
(translate "ear")
(translate "igloo")
(translate "object")
(translate "under")
(translate "equal")
(translate "pig")
(translate "koala")
(translate "yellow")
(translate "xenon")
(translate "chair")
(translate "queen")
(translate "square")
(translate "therapy")
(translate "thrush")
(translate "school")
(translate "yttria")
(translate "xray")
(translate "rhythm")
(translate "my")
(translate "quick fast run")