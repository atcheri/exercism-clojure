(ns exercism.numbers.all-your-base
  (:require [clojure.string :as str]))

(defn convertSeqToInt
  [seq]
  (read-string (str/join (map str seq))))

(defn convert
  [a b c]
  (let [rest (atom (convertSeqToInt b))
        nums (atom '[])]
    (while (> @rest 0)
      ;; (println @rest)
      (reset! nums (conj @nums (rem @rest c)))
      (reset! rest (quot @rest c))
      (println @nums))
    (read-string (str/join #"" @nums))))


(defn- ->decimal [base i digit]
  (* digit (apply * (repeat i base))))

(defn- ->base [base decimal & results]
  (if (zero? decimal)
    (or results '(0))
    (recur base (quot decimal base) (conj results (rem decimal base)))))

(defn convert [from-base value to-base]
  (when (and (> from-base 1)
             (> to-base 1)
             (not-any? neg? value)
             (not-any? #(>= % from-base) value))
    (if (empty? value)
      ()
      (->> value
           (reverse)
           (map-indexed (partial ->decimal from-base))
           (apply +)
           (->base to-base)))))



