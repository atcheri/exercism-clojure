(ns exercism.numbers.nth-prime-test
  (:require [clojure.test :refer [deftest testing is]]
            [exercism.numbers.nth-prime :refer [nth-prime]]))

(deftest first-prime
  (testing "the first prime is 2"
    (is (= 2 (nth-prime 1)))))

(deftest second-prime
  (testing "the second prime is 3"
    (is (= 3 (nth-prime 2)))))

(deftest third-prime
  (testing "the third prime is 5"
    (is (= 5 (nth-prime 3)))))

(deftest fourth-prime
  (testing "the fourth prime is 7"
    (is (= 7 (nth-prime 4)))))

(deftest sixth-prime
  (testing "the sixth prime is 13"
    (is (= 13 (nth-prime 6)))))

(deftest ten-thousand-first-prime
  (testing "the ten thousand and first prime is 104743"
    (is (= 104743 (nth-prime 10001)))))

(deftest zeroth-prime
  (testing "there is no zeroth prime"
    (is (thrown? IllegalArgumentException (nth-prime 0)))))



