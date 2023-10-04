(ns exercism.numbers.binary-search)

(defn middle
  [numbers]
  (quot (count numbers) 2))

(defn search-for
  ([num numbers] (search-for num numbers 0))
  ([num numbers acc]
   (if (empty? numbers) (throw (Exception. "not found"))
       (let [mid (middle numbers)
             guess (nth numbers mid)]
         (cond
           (= guess num) (+ acc mid)
           (> guess num) (recur num (take mid numbers) acc)
           :else (recur num (drop (inc mid) numbers) (+ acc (inc mid))))))))