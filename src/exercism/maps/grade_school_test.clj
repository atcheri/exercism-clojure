(ns exercism.maps.grade-school-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.maps.grade-school :refer [add grade sorted]]))

(def db {})

(deftest add-student
  (is (= {2 ["Aimee"]} (add db "Aimee" 2))))

(deftest add-more-students-in-same-class
  (is (= {2 ["James", "Blair", "Paul"]}
         (-> db
             (add "James" 2)
             (add "Blair" 2)
             (add "Paul" 2)))))

(deftest add-students-to-different-grades
  (is (= {3 ["Chelsea"] 7 ["Logan"]}
         (-> db
             (add "Chelsea" 3)
             (add "Logan" 7)))))

(deftest get-students-in-a-grade
  (is (= ["Franklin", "Bradley"]
         (-> db
             (add "Franklin" 5)
             (add "Bradley" 5)
             (add "Jeff" 1)
             (grade 5)))))

(deftest get-students-in-a-non-existent-grade
  (is (= [] (grade db 1))))

(deftest sorted-grade-school
  (is (= (sorted-map 3 ["Kyle"]
                     4 ["Christopher" "Jennifer"]
                     6 ["Kareem"])
         (-> db
             (add "Jennifer" 4)
             (add "Kareem" 6)
             (add "Christopher" 4)
             (add "Kyle" 3)
             (sorted)))))

(deftest sorted-grade_school-keys-sorted
  (is (= [3 4 6]
         (-> db
             (add "Jennifer" 4)
             (add "Kareem" 6)
             (add "Christopher" 4)
             (add "Kyle" 3)
             (sorted)
             (keys)))))