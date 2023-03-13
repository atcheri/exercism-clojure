(ns exercism.strings.scrable-score-test
  (:require
   [clojure.test :refer [deftest is]]
   [exercism.strings.scrable-score :refer [score-letter score-word]]))

(deftest lower-case-letter
  (is (= 1 (score-letter "a"))))

(deftest upper-case-letter
  (is (= 1 (score-letter "A"))))

(deftest two-letter-word
  (is (= 2 (score-word "at"))))

(deftest bigger-word-1
  (is (= 6 (score-word "street"))))

(deftest bigger-word-2
  (is (= 22 (score-word "quirky"))))

(deftest all-upper-case-word
  (is (= 41 (score-word "OXYPHENBUTAZONE"))))

