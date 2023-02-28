(ns exercism.strings.hamming-test
  (:require
   [clojure.test :refer [deftest is]]
   [exercism.strings.hamming :refer [distance]]))

(deftest no-difference-between-empty-strands
  (is (= 0 (distance "" ""))))

(deftest no-difference-between-identical-strands
  (is (= 0 (distance "GGACTGA" "GGACTGA"))))

(deftest complete-distance-in-small-strand
  (is (= 3 (distance "ACT" "GGA"))))

(deftest small-distance-in-middle-somewhere
  (is (= 1 (distance "GGACG" "GGTCG"))))

(deftest larger-distance
  (is (= 2 (distance "ACCAGGG" "ACTATGG"))))

(deftest undefined-when-lengths-are-different
  (is (= nil (distance "AAAC" "TAGGGGAGGCTAGCGGTAGGAC")))

  (is (= nil (distance "GACTACGGACAGGGTAACATAG" "GACA"))))