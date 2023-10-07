(ns exercism.strings.isbn-verifier
  (:require [clojure.string :as str]))

;; (defn- ends-with-x-or-number [isbn]
;;   (or (= (last isbn) \X) (re-find #"\d" isbn)))

;; (def isbn-length 10)

;; (defn- get-value [ch]
;;   (if (= ch \X)
;;     10
;;     (Character/digit ^char ch 10)))

;; (defn- clean-isbn [isbn]
;;   (str/replace isbn #"(\s|\-)" ""))

;; (defn- valid-isbn-format? [isbn]
;;   (let [cleaned (clean-isbn isbn)]
;;     (cond
;;       (and
;;        (re-matches #"^\d{9}(X|\d)" cleaned)
;;        (= (count cleaned) isbn-length)) true
;;       :else false)))

;; (defn- valid-isbn? [isbn]
;;   (zero? (mod isbn 11)))

;; (defn- compute-isbn [isbn]
;;   (->> (clean-isbn isbn)
;;        (map get-value)
;;        (map * (range 10 0 -1))
;;        (reduce +)))

;; (defn isbn? [isbn]
;;   (and
;;    (not (valid-isbn-format? isbn))
;;    (valid-isbn? (compute-isbn isbn))))


(defn- get-value
  [ch]
  (if (= ch \X)
    10
    (Character/digit ^char ch 10)))

(defn- isbn-value
  [s]
  (->> (remove #{\-} s)
       (map get-value)
       (map * (range 10 0 -1))
       (reduce +)))

(defn- valid-isbn-value?
  [val]
  (zero? (mod val 11)))

(defn valid-isbn-pattern?
  [s]
  (boolean (re-matches #"\d{9}(X|\d)|\d-\d{3}-\d{5}-(X|\d)" s)))

(defn isbn?
  [s]
  (and (valid-isbn-pattern? s) (valid-isbn-value? (isbn-value s))))

