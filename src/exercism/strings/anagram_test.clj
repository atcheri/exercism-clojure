(ns exercism.strings.anagram-test
  (:require [clojure.test :refer [deftest is]])
  (:require [exercism.strings.anagram :refer [anagrams-for]]))

(deftest no-matches
  (is (= []
         (anagrams-for "diaper" ["hello" "world" "zombies" "pants"]))))

(deftest detect-simple-anagram
  (is (= ["tan"] (anagrams-for "ant" ["tan" "stand" "at"]))))

(deftest does-not-confuse-different-duplicates
  (is (= [] (anagrams-for "galea" ["eagle"]))))

(deftest eliminate-anagram-subsets
  (is (= [] (anagrams-for "good" ["dog" "goody"]))))

(deftest detect-anagram
  (is (= ["inlets"]
         (let [coll ["enlists" "google" "inlets" "banana"]]
           (anagrams-for "listen" coll)))))

(deftest multiple-anagrams
  (is (= ["gallery" "regally" "largely"]
         (let [coll ["gallery" "ballerina" "regally"
                     "clergy"  "largely"   "leading"]]
           (anagrams-for "allergy" coll)))))

(deftest case-insensitive-anagrams
  (is (= ["Carthorse"]
         (let [coll ["cashregister" "Carthorse" "radishes"]]
           (anagrams-for "Orchestra" coll)))))

(deftest word-is-not-own-anagram
  (is (= [] (anagrams-for "banana" ["banana"]))))

(deftest capital-word-is-not-own-anagram
  (is (= [] (anagrams-for "BANANA" ["banana"]))))

