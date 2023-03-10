(ns exercism.strings.robot
  (:require [clojure.string :as str]))

(defn two-random-letters
  []
  (str/upper-case (apply str (repeatedly 2 #(rand-nth "abcdefghijklmnopqrstuvwxyz")))))

(defn three-random-numbers
  []
  (str/upper-case (apply str (repeatedly 3 #(rand-nth "012456789")))))

(defn create-robot-name
  []
  (str (two-random-letters) (three-random-numbers)))

(defn robot
  []
  (atom {:name (create-robot-name)}))

(defn robot-name
  [robot]
  (:name @robot))

(defn reset-name
  [robot]
  (swap! robot assoc :name (create-robot-name)))
