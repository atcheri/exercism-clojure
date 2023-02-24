(ns exercism.strings.bob-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.strings.bob :refer [response-for]]))

(deftest responds-to-something
  (is (= "Whatever." (response-for "Tom-ay-to, tom-aaaah-to."))))

(deftest responds-to-shouts
  (is (= "Whoa, chill out!" (response-for "WATCH OUT!"))))

(deftest responds-to-shouting-gibberish
  (is (= "Whoa, chill out!" (response-for "FCECDFCAAB"))))

(deftest responds-to-questions
  (is (= "Sure."
         (response-for "Does this cryogenic chamber make me look fat?"))))

(deftest responds-to-numeric-question
  (is (= "Sure." (response-for "You are, what, like 15?"))))

(deftest responds-to-gibberish-question
  (is (= "Sure." (response-for "fffbbcbeab?"))))

(deftest responds-to-forceful-talking
  (is (= "Whatever." (response-for "Let's go make out behind the gym!"))))

(deftest responds-to-acronyms
  (is (= "Whatever."
         (response-for "It's OK if you don't want to go to the DMV."))))

(deftest responds-to-forceful-questions
  (is (= "Calm down, I know what I'm doing!"
         (response-for "WHAT THE HELL WERE YOU THINKING?"))))

(deftest responds-to-shouting-numbers
  (is (= "Whoa, chill out!" (response-for "1, 2, 3 GO!"))))

(deftest responds-to-no-letters
  (is (= "Whatever." (response-for "1, 2, 3"))))

(deftest responds-to-question-with-no-letters
  (is (= "Sure." (response-for "4?"))))

(deftest responds-to-shouting-with-special-characters
  (is (= "Whoa, chill out!"
         (response-for "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))))

(deftest responds-to-shouting-with-no-exclamation-mark
  (is (= "Whoa, chill out!" (response-for "I HATE THE DMV"))))

(deftest responds-to-statement-containing-question-mark
  (is (= "Whatever." (response-for "Ending with ? means a question."))))

(deftest responds-to-non-letters-with-question
  (is (= "Sure." (response-for ":) ?"))))

(deftest responds-to-prattling-on
  (is (= "Sure." (response-for "Wait! Hang on. Are you going to be OK?"))))

(deftest responds-to-silence
  (is (= "Fine. Be that way!" (response-for ""))))

(deftest responds-to-prolonged-silence
  (is (= "Fine. Be that way!" (response-for "    "))))

(deftest responds-to-alternate-silence
  (is (= "Fine. Be that way!" (response-for "\t\t\t\t\t\t\t\t\t\t"))))

(deftest responds-to-multiple-line-question
  (is (= "Whatever."
         (response-for "\nDoes this cryogenic chamber make me look fat?\nNo."))))

(deftest responds-to-starting-with-whitespace
  (is (= "Whatever." (response-for "         hmmmmmmm..."))))

(deftest responds-to-ending-with-whitespace
  (is (= "Sure." (response-for "Okay if like my  spacebar  quite a bit?   "))))

(deftest responds-to-other-whitespace
  (is (= "Fine. Be that way!" (response-for "\n\r \t"))))

(deftest responds-to-non-question-ending-with-whitespace
  (is (= "Whatever."
         (response-for "This is a statement ending with whitespace      "))))

