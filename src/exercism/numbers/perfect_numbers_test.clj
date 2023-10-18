(ns exercism.numbers.perfect-numbers-test
  (:require
   [clojure.test :refer [deftest testing is]]
   [exercism.numbers.perfect-numbers :refer [classify]]))

(deftest test-initialize-perfect-number
  (testing "Negative numbers throw an exception"
    (is (thrown? IllegalArgumentException (classify -1)))))

(deftest test-classify-deficient
  (testing "13 is a deficient number"
    (is (= :deficient (classify 13)))))

(deftest test-classify-perfect
  (testing "28 is a perfect number"
    (is (= :perfect (classify 28)))))

(deftest test-classify-abundant
  (testing "12 is an abundant number"
    (is (= :abundant (classify 12)))))