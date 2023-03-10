(ns exercism.sequential-destructuring.run-length-encoding
  (:require [clojure.string :as str]))

(defn run-length-encode-mapcat
  [s]
  (->> s
       (partition-by identity)
       (mapcat #(if (= 1 (count %))
                  [(first %)]
                  [(count %) (first %)]))
       (apply str)))


(defn run-length-decode-mapcat
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"[1-9]*[a-zA-Z ]")
       (mapcat #(if (= 1 (count %))
                  %
                  (repeat (->> % drop-last (apply str) Integer.) (last %))))
       (apply str)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (str/replace plain-text #"(\D)\1+"
               (fn [[a b]] (str (count a) b))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (str/replace cipher-text #"(\d+)(\D)"
               (fn [[_ c l]] (apply str (repeat (read-string c) l)))))
