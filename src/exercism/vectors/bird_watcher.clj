(ns exercism.vectors.bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (peek birds))

(defn inc-bird [birds]
  (conj (into [] (drop-last 1 birds)) (inc (last birds))))

(defn day-without-birds? [birds]
  (if (some zero? birds) true false))


(defn n-days-count [birds n]
  ;; (reduce + (into [] (take n birds)))
  (->> birds
       (take n)
       (reduce +)))

(defn busy-days [birds]
  (->> birds
       (filter (fn [x]
                 (>= x 5)))
       (count)))

(defn odd-week? [birds]
  (= birds [1 0 1 0 1 0 1]))

