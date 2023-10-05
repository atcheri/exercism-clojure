(ns exercism.arrays.gigasecond-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.arrays.gigasecond :refer [from]]))


(deftest from-apr-25-2011
  (is (= [2043 1 1] (from 2011 4 25))))

(deftest from-jun-13-1977
  (is (= [2009 2 19] (from 1977 6 13))))

(deftest from-jul-19-1959
  (is (= [1991 3 27] (from 1959 7 19))))

;; customize this to test your birthday and find your gigasecond date:
;; (deftest your-birthday
;;   (is (= [year2 month2 day2] (from year1 month1 day1))))