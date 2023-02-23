(ns exercism.sequential-destructuring.elyses-destructured-enchantments)


(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (second deck))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (into (vector (second-card deck) (first-card deck)) (vec (drop 2 deck))))


(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (cond
    (= 1 (count deck)) (vector (first-card deck) nil)
    :else (vector (first-card deck) (vec (drop 1 deck)))))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (vec (flatten (vector (first-card deck) face-cards (vec (drop 1 deck))))))

(insert-face-cards [3 10 7])