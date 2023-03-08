(ns exercism.strings.rna-transcription-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.strings.rna-transcription :refer [to-rna]]))


(deftest transcribes-cytosine-to-guanine
  (is (= "G" (to-rna "C"))))

(deftest transcribes-guanine-to-cytosine
  (is (= "C" (to-rna "G"))))

(deftest transcribes-adenine-to-uracil
  (is (= "U" (to-rna "A"))))

(deftest it-transcribes-thymine-to-adenine
  (is (= "A" (to-rna "T"))))

(deftest it-transcribes-all-nucleotides
  (is (= "UGCACCAGAAUU" (to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (to-rna "XCGFGGTDTTAA"))))


