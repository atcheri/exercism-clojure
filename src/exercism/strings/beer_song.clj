(ns exercism.strings.beer-song
  (:require  [clojure.string :as str]))

(defn bottles [n]
  (str (if (zero? n) "no more" n) " bottle" (when (not= 1 n) "s") " of beer"))

(defn first-line [n]
  (str (str/capitalize (bottles n)) " on the wall, " (bottles n) ".\n"))

(defn second-line [n]
  (if (neg? n)
    "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    (str "Take " (if (zero? n) "it" "one") " down and pass it around, " (bottles n) " on the wall.\n")))

(defn verse [n]
  (str (first-line n) (second-line (dec n))))

(defn sing
  ([n] (sing n 0))
  ([n k]
   (->> (range n (dec k) -1)
        (map verse)
        (str/join "\n"))))

(def no-more-bottles "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")
(def one-bottle "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")
(def two-bottles "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n")

(defn verse-more-than-one
  [num]
  (str num " bottles of beer on the wall, " num " bottles of beer.\nTake one down and pass it around, " (- num 1) " bottles of beer on the wall.\n"))

(defn verse-o
  "Returns the nth verse of the song."
  [num]
  (cond
    (zero? num) no-more-bottles
    (= 1 num) one-bottle
    (= 2 num) two-bottles
    :else (verse-more-than-one num)))

(defn sing-o
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (let [bottles (atom start)]
     (while (> @bottles 0)
       (do
         (verse @bottles)
         (swap! bottles dec)))))
  ([start end]
   (let [bottles (atom start)]
     (while (> @bottles end)
       (do
         (verse @bottles)
         (swap! bottles dec))))))