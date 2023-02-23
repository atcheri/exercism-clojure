(ns exercism.strings.log-levels (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (-> s
      (str/split #"\[[^\]]*\]:")
      (last)
      (str/trim)))


(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (->> s
       (re-find #"\[(.*?)\]")
       (last)
       (str/lower-case)))


(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str/join "" [(message s)  " (" (log-level s) ")"]))

(reformat "[INFO]: Operation completed")