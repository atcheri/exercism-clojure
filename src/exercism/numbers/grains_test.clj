(ns exercism.numbers.grains-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.numbers.grains :refer [square total]]))

(deftest square-1
  (is (= 1 (square 1))))

(deftest square-2
  (is (= 2 (square 2))))

(deftest square-3
  (is (= 4 (square 3))))

(deftest square-4
  (is (= 8 (square 4))))

(deftest square-16
  (is (= 32768 (square 16))))

(deftest square-32
  (is (= 2147483648 (square 32))))

(deftest square-64
  (is (= 9223372036854775808 (square 64))))

(deftest total-grains
  (is (= 18446744073709551615  (total))))


        