(ns exercism.numbers.binary)

(def not-nil? (complement nil?))

(defn is-decimal-string?
  [num]
  (not-nil? (re-matches #"^[0-9]*$" num)))

(defn add-value
  [total i val]
  (+ total (* (Math/pow 2 i) (read-string (str val)))))

(defn convert-to-decimal
  [num]
  (reduce-kv add-value
             0
             (into '[] (seq num))))


(defn to-decimal-o
  [num]
  (cond
    (is-decimal-string? num) (convert-to-decimal num)
    :else 0))

(to-decimal-o "101")

(defn to-decimal [num]
  (reduce
   (fn [acum digit]
     (+ (* 2 acum) (if (= digit \1) 1 0)))
   0
   num))