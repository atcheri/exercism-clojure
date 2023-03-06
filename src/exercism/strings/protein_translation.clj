(ns exercism.strings.protein-translation
  (:require [clojure.string :as str]))


(def acids {"AUG"   "Methionine"
            "UUU"    "Phenylalanine"
            "UUC" "Phenylalanine"
            "UUA" "Leucine"
            "UUG"   "Leucine"
            "UCU" "Serine"
            "UCC" "Serine"
            "UCA" "Serine"
            "UCG"   "Serine"
            "UAU" "Tyrosine"
            "UAC"   "Tyrosine"
            "UGU" "Cysteine"
            "UGC"   "Cysteine"
            "UGG"   "Tryptophan"
            "UAA" "STOP"
            "UAG" "STOP"
            "UGA"   "STOP"})



(defn translate-codon
  [codon]
  (get acids codon))

(defn translate-rna
  [rna]
  (->> rna
       (#(str/split % #"(UAA|UAG|UGA)"))
       (first)
       (partition 3)
       (map #(str/join "" %))
       (map translate-codon)
       (filter #(not= % "STOP"))
       (distinct)))



(translate-rna "AUGUUUUGG")
(translate-rna "AUGUUUUAA")
(translate-rna "UGGUGUUAUUAAUGGUUU")
