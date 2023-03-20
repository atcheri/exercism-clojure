(ns exercism.strings.atbash-cipher
  (:require [clojure.string]))

(defn- subsitute [c]
  (if (and (>= (int c) 97) (<= (int c) 122))
    (char (- 122 (- (int c) 97)))
    c))

(defn- remove-punctuation [s]
  (filter #(or (Character/isDigit %) (Character/isLetter %)) s))

(defn- group-by-5 [s]
  (clojure.string/join
   " "
   (map (partial apply str) (partition-all 5 s))))

(defn encode [s]
  (->> s
       clojure.string/lower-case
       remove-punctuation
       (map subsitute)
       group-by-5))

(def alphabet ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])
;; (def alphabet #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})

(defn prev-encode-word
  [word]
  (let [reversed-alphabet (into '[] (reverse (sort alphabet)))]
    (->> word
         seq
         (map (fn [l]
                (get reversed-alphabet (.indexOf alphabet l))
            ;;   (get (into '[] (reverse (sort alphabet))) (.indexOf alphabet l))
                )))))

(prev-encode-word "the")

(def reversed-alphabet (into '[] (reverse (sort alphabet))))

(map (fn [l]
       (get reversed-alphabet (.indexOf alphabet l)))
     (seq ["w" "o" "r" "d"])
    ;;  (into '[] (seq "word"))
     )

