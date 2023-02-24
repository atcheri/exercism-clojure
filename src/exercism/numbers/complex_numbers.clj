(ns exercism.numbers.complex-numbers
  (:require
   [clojure.math :refer [pow sqrt]]))

(defn div [[x y] [u v]]
  [(/ (+ (float (* x u)) (* y v)) (+ (* u u) (* v v)))
   (/ (+ (float (* (- x) v)) (* y u)) (+ (* u u) (* v v)))])

(defn imaginary
  [a]
  (last a))

(defn real
  [a]
  (first a))

(defn mul
  [a b]
  (vector
   (- (* (real a) (real b)) (* (imaginary a) (imaginary b)))
   (+ (* (imaginary a) (real b)) (* (real a) (imaginary b)))))

(defn add
  [a b]
  (vector (+ (real a) (real b)) (+ (imaginary a) (imaginary b))))

(defn sub
  [a b]
  (vector (- (real a) (real b)) (- (imaginary a) (imaginary b))))

(defn abs
  [a]
  (sqrt (+ (pow (real a) 2) (pow (imaginary a) 2))))

(defn conjugate
  [a]
  (conj [(real a)] (* -1 (imaginary a))))