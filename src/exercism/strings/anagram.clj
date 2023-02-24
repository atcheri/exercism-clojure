(ns exercism.strings.anagram
  (:require [clojure.string :as str]))


(defn clean
  [word]
  (-> word
      (str/replace #"/[^\w]/g" "")
      (str/lower-case)
      (str/split #"")
      (sort)
      (str/join)))

(defn anagrams?
  [w1 w2]
  (and
   (not= (str/lower-case w1) (str/lower-case w2))
   (= (clean w1) (clean w2))))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (filter (partial anagrams? word) prospect-list))


(clean "Test-Word")
;; (anagrams-for "lol" ["lol"])
;; function anagrams(stringA, stringB)
;;   // create helper function to clean up string
;;   // use function per string and compare them  return cleanString(stringA) === cleanString(stringB)
;; }

;; function cleanString(str){
;;   return str.replace(/[^\w]/g, '').toLowerCase().split('').sort().join('');
;; }