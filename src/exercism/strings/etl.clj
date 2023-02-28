(ns exercism.strings.etl
  (:require [clojure.string :as str]))

(defn transform
  [source]
  (reduce (fn [acc [points words]]
            (into acc
                  (map vector
                       (map str/lower-case words)
                       (repeat points))))
          {}
          source))

(keys {"world" 1})
(keys {"apple" 1 "artichoke" 1 "boat" 2 "ballerina" 2})
(vals {"apple" 1 "artichoke" 1 "boat" 2 "ballerina" 2})
(keys (take 2 {"apple" 1 "artichoke" 1 "boat" 2 "ballerina" 2}))
(transform {1 ["WORLD"]})
;; (zipmap 
;;  (keys {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]}) 
;;  (vals {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]})
;;  )
;; (= {"world" 1}
;;    (transform {1 ["WORLD"]}))

;; (map (fn [[k v]] 
;;        (println k v)
;;        (hash-map k v)
;;        ) 
;;      {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]})


(reduce (fn [acc [points words]]
          (into acc
                (map vector
                     (map str/lower-case words)
                     (repeat points))))
        {}
        {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]})

