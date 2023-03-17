(ns exercism.conditionals.triangle-test
  (:require
   [clojure.test :refer [deftest is]]
   [exercism.conditionals.triangle :refer [equilateral? isosceles? scalene?]]))

(deftest equilateral-all-sides-equal
  (is (true? (equilateral? 2 2 2))))

(deftest equilateral-any-side-is-unequal
  (is (false? (equilateral? 2 3 2))))

(deftest equilateral-no-sides-are-equal
  (is (false? (equilateral? 5 4 6))))

(deftest equilateral-all-zero-sides
  (is (false? (equilateral? 0 0 0))))

(deftest equilateral-sides-may-be-floats
  (is (true? (equilateral? 0.5 0.5 0.5))))

(deftest isosceles-last-two-sides-equal
  (is (true? (isosceles? 3 4 4))))

(deftest isosceles-first-two-sides-equal
  (is (true? (isosceles? 4 4 3))))

(deftest isosceles-first-last-sides-equal
  (is (true? (isosceles? 4 3 4))))

(deftest isosceles-equilateral-triangles-also-isosceles
  (is (true? (isosceles? 4 4 4))))

(deftest isosceles-no-sides-equal
  (is (false? (isosceles? 2 3 4))))

(deftest isosceles-first-triangle-inequality-violation
  (is (false? (isosceles? 1 1 3))))

(deftest isosceles-second-triangle-inequality-violation
  (is (false? (isosceles? 1 3 1))))

(deftest isosceles-third-triangle-inequality-violation
  (is (false? (isosceles? 3 1 1))))

(deftest isosceles-sides-may-be-floats
  (is (true? (isosceles? 0.5 0.4 0.5))))

(deftest scalene-no-sides-are-equal
  (is (true? (scalene? 5 4 6))))

(deftest scalene-all-sides-equal
  (is (false? (scalene? 4 4 4))))

(deftest scalene-two-sides-equal
  (is (false? (scalene? 4 4 3))))

(deftest scalene-may-not-violate-triangle-inequality
  (is (false? (scalene? 7 3 2))))

(deftest scalene-sides-may-be-floats
  (is (true? (scalene? 0.5 0.4 0.6))))

