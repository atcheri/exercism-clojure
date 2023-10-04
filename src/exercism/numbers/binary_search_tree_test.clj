(ns exercism.numbers.binary-search-tree-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.numbers.binary-search-tree :refer [from-list value singleton left right to-list insert]]))


(deftest data-is-retained
  (is (= 4 (value (singleton 4)))))

(deftest inserting-less
  (let [t (insert 2 (singleton 4))]
    (is (= 4 (value t)))
    (is (= 2 (value (left t))))))

(deftest inserting-same
  (let [t (insert 4 (singleton 4))]
    (is (= 4 (value t)))
    (is (= 4 (value (left t))))))

(deftest inserting-right
  (let [t (insert 5 (singleton 4))]
    (is (= 4 (value t)))
    (is (= 5 (value (right t))))))

(deftest complex-tree
  (let [t (from-list [4 2 6 1 3 7 5])]
    (is (= 4 (value t)))
    (is (= 2 (value (left t))))
    (is (= 1 (value (left (left t)))))
    (is (= 3 (value (right (left t)))))
    (is (= 6 (value (right t))))
    (is (= 5 (value (left (right t)))))
    (is (= 7 (value (right (right t)))))))

(deftest iterating-one-element
  (is (= [4] (to-list (singleton 4)))))

(deftest iterating-over-smaller-element
  (is (= [2 4] (to-list (from-list [4 2])))))

(deftest iterating-over-larger-element
  (is (= [4 5] (to-list (from-list [4 5])))))

(deftest iterating-over-complex-tree
  (is (= (range 1 8) (to-list (from-list [4 2 1 3 6 7 5])))))

