(ns exercism.strings.secret-handshake)

(def actions {0 #(conj % "wink")
              1 #(conj % "double blink")
              2 #(conj % "close your eyes")
              3 #(conj % "jump")
              4 reverse})

(defn commands
  [num]
  (->> (range 5)
       (filter #(bit-test num %))
       (reduce (fn [acc curr]
                 ((get actions curr) acc))
               [])))
