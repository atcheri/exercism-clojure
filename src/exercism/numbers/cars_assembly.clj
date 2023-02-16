(ns exercism.numbers.cars-assembly)

(def produced-cars-per-hour 221)

(defn rate-by-speed [speed]
  (cond
    (>= speed 10) 77
    (= speed 9) 80
    (>= speed 5) 90
    :else 100))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (-> speed
      (rate-by-speed)
      (/ 100)
      (* produced-cars-per-hour)
      (* speed)
      (double)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
