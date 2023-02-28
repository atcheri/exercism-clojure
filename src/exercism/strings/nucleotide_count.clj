(ns exercism.strings.nucleotide-count
  (:require [clojure.string :as str]))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (empty? strand) (identity 0)
      (if (not (str/includes? "ACGT" (str nucleotide)))
        (throw "Invalid nucleotide")
        (->> strand
             (filter #(= nucleotide %))
             count))))

(defn nucleotide-counts
  [strand]
  {\A (count-of-nucleotide-in-strand \A strand),
   \T (count-of-nucleotide-in-strand \T strand),
   \C (count-of-nucleotide-in-strand \C strand),
   \G (count-of-nucleotide-in-strand \G strand)})
