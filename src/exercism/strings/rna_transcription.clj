(ns exercism.strings.rna-transcription
  (:require [clojure.string :as str]))

(def dna->rna {"G" "C" "C" "G" "T" "A" "A" "U"})

(def dna-pattern
  (re-pattern (str "^[" (str/join (keys dna->rna)) "]+$")))

(defn valid-dna?
  [dna]
  (boolean (re-find dna-pattern dna)))

(defn to-rna-prev
  [dna]
  {:pre [valid-dna? dna]}
  (reduce (fn [acc curr]
            (str acc (get dna->rna curr)))
          ""
          (seq dna)))
(defn to-rna
  [dna]
  {:pre [(valid-dna? dna)]}
  (str/join (map dna->rna (str/split dna #""))))