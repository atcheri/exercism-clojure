(ns exercism.numbers.interest-is-interesting)

(defn interest-rate
  [balance]
  (cond
    (>= balance 5000) 2.475
    (>= balance 1000) 1.621
    (>= balance 0) 0.5
    :else -3.213))

(defn annual-balance-update
  [balance]
  (let [interest (bigdec (interest-rate balance))
        result (* balance (if (> interest 0M)
                            (+ 1M (/ interest 100M))
                            (- 1M (/ interest 100M))))]
    (bigdec result)))


(defn amount-to-donate
  [balance tax-free-percentage]
  (if (< (int balance) 0)
    (int 0)
    (int (* 2 (* (/ tax-free-percentage 100) balance)))))