(ns exercism.maps.grade-school)

(defn grade [school grade]
  (into [] (get school grade)))

(defn add [s n g]
  (assoc s g (into [] (conj (grade s g) n))))

(defn sorted [school]
  (->> school
       (map (fn [[k v]] [k (sort v)]))
       (into (sorted-map))))

(-> {}
    (add "Jennifer" 4)
    (add "Kareem" 6)
    (add "Christopher" 4)
    (add "Kyle" 3)
    (sorted))