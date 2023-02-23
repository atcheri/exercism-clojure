(ns exercism.strings.acronym
  (:require [clojure.string :as str]))

(defn acronym-t
  [text]
  (->> text
       (#(str/split % #"([\s,;:])"))
       (map str/capitalize)
       (map #(str/replace % #"[a-z]" ""))
       (str/join)
      ;;  (str/upper-case)
       ))

;; (mapv str/capitalize "PHP")
;; (sequential? "tre")

(defn acronym [text]
  (->> text
       (#(clojure.string/split % #" "))
       (mapcat #(clojure.string/split % #"(?<=[a-z])(?=[A-Z])"))
       (mapcat #(clojure.string/split % #"-"))
       (map first)
       (map #(if ((complement nil?) %) (Character/toUpperCase %) nil))
       (apply str)))


(acronym "Portable Network Graphics")
(acronym "HyperText Markup Language")
(acronym "First In, First Out")
(acronym "PHP: Hypertext Preprocessor")