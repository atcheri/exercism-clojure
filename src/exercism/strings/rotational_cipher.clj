(ns exercism.strings.rotational-cipher
  (:require [clojure.string :as str]))

(def alphabet ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])
(def capitals ["A" "B" "C" "D" "E" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z"])

(defn letter-pos
  [letter base]
  (str/index-of (str/join base) letter))

(defn rotate-letter
  [letter rank base]
  (base (+ (mod (+ rank (letter-pos letter base)) 26))))

(defn rotate-word
  [word rank]
  (->> word
       (#(str/split % #""))
       (map (fn [letter]
              (cond
                (re-matches #"[^a-zA-Z]" letter) letter
                (= (str/upper-case letter) letter) (rotate-letter letter rank capitals)
                :else (rotate-letter letter rank alphabet))))
       (str/join "")))

(defn rotate
  [sentence rank]
  (->> sentence
       (re-seq #"[a-zA-Z \d.,!?\\'\\-]")
       (map (fn [l]
              (rotate-word l rank)))
       (str/join "")))


(rotate "A" 0)
(rotate "m" 13)
(rotate "OMG" 5)
(rotate "O M G" 5)
(rotate "abc" 6)
;; "Xiwxmrk 1 2 3 xiwxmrk"
(rotate "Testing 1 2 3 testing" 4)
;; "Gzo'n zvo, Bmviyhv!"
(rotate "Let's eat, Grandma!" 21)
;; (drop-while #(not= "b" %) alphabet)
;; (take-while #(not= "b" %) alphabet)
;; (flatten (conj (take-while #(not= letter %) alphabet) (drop-while #(not= letter %) alphabet)))