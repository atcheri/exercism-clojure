(ns exercism.strings.atbash-cipher-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.strings.atbash-cipher :refer [encode]]))

(deftest encode-no
  (is (= "ml" (encode "no"))))

(deftest encode-yes
  (is (= "bvh" (encode "yes"))))

(deftest encode-OMG
  (is (= "lnt" (encode "OMG"))))

(deftest encode-O-M-G
  (is (= "lnt" (encode "O M G"))))

(deftest encode-long-word
  (is (= "nrmwy oldrm tob" (encode "mindblowingly"))))

(deftest encode-numbers
  (is (= "gvhgr mt123 gvhgr mt"
         (encode "Testing, 1 2 3, testing."))))

(deftest encode-sentence
  (is (= "gifgs rhurx grlm" (encode "Truth is fiction."))))

(deftest encode-all-the-things
  (let [plaintext "The quick brown fox jumps over the lazy dog."
        cipher    "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"]
    (is (= cipher (encode plaintext)))))

