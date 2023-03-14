(ns exercism.numbers.space-age)

(def year-in-seconds 31557600)
(def orbital-years {:mercury 0.2408467
                    :venus 0.61519726
                    :earth 1
                    :mars 1.8808158
                    :jupiter 11.862615
                    :saturn 29.447498
                    :uranus 84.016846
                    :neptune 164.79132})

(defn round-age
  [age-seconds]
  (/ (Math/round (* 100.0 age-seconds)) 100.0))

(defn on-earth-raw
  [age]
  (-> age
      (/ year-in-seconds)))

(defn on-earth
  [age]
  (-> age
      (on-earth-raw)
      (round-age)))

(defn on-mercury
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :mercury))
      (round-age)))

(defn on-venus
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :venus))
      (round-age)))


(defn on-mars
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :mars))
      (round-age)))

(defn on-jupiter
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :jupiter))
      (round-age)))

(defn on-saturn
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :saturn))
      (round-age)))

(defn on-uranus
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :uranus))
      (round-age)))

(defn on-neptune
  [age]
  (-> age
      (on-earth-raw)
      (/ (get orbital-years :neptune))
      (round-age)))


(on-earth 1000000000)

(on-mercury 2134835688)
(on-earth 189839836)
(on-venus 189839836)