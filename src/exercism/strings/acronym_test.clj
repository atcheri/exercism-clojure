(ns exercism.strings.acronym-test
  (:require
   [clojure.test :refer [deftest is]]
   [exercism.strings.acronym :refer [acronym]]))

(deftest test-acronym-empty-string
  (is (= "" (acronym ""))))

(deftest test-acronym-png
  (is (= "PNG" (acronym "Portable Network Graphics"))))

(deftest test-acronym-ror
  (is (= "ROR" (acronym "Ruby on Rails"))))

(deftest test-acronym-html
  (is (= "HTML" (acronym "HyperText Markup Language"))))

(deftest test-acronym-fifo
  (is (= "FIFO" (acronym "First In, First Out"))))

(deftest test-acronym-php
  (is (= "PHP" (acronym "PHP: Hypertext Preprocessor"))))

(deftest test-acronym-cmos
  (is (= "CMOS" (acronym "Complementary metal-oxide semiconductor"))))