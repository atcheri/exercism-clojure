(ns exercism.numbers.armstrong-test
  (:require
   [clojure.test :refer [deftest testing is]]
   [exercism.numbers.armstrong :refer :all]))

(deftest armstrong-test
  (testing "0 is an armstrong"
    (is (= true (armstrong? 0))))
  (testing "9 is an armstrong"
    (is (= true (armstrong? 9))))
  (testing "10 is not an armstrong"
    (is (= false (armstrong? 10))))
  (testing "21897142587612075 is not an armstrong"
    (is (= false (armstrong? 21897142587612075)))))

(deftest orderOfMagnitude-test
  (testing "1 for 9"
    (is (= 1 (orderOfMagnitude 9))))
  (testing "2 for 12"
    (is (= 2 (orderOfMagnitude 12))))
  (testing "3 for 123"
    (is (= 3 (orderOfMagnitude 123)))))

(deftest powerOf-test
  (testing "1 for 1 and 1"
    (powerOf 1 1))
  (testing "25 for 5 and 2"
    (powerOf 5 2)))