(ns advent-of-code.2
  (:require [clojure.string :as str]))

(def input
  (as-> (slurp "./resources/2") v
    (str/split v #"\n")
    (map #(str/split % #" ") v)))

(defn parse-range
  [string]
  "Parse range, example: 5-6"
  (map #(Integer/parseInt %)(str/split string #"-")))

(defn check
  "Check if a string contains char within range"
  [string, char, range]
  (<=
   (nth range 0)
   (count (filter #(= % (str char)) (str/split string #"")))
   (nth range 1)
   ))

(defn check-positions
  "Check if a chars are in positions"
  [string, char, range]
  (let [start (- (nth range 0) 1)
        end (- (nth range 1) 1)]
    (= 1 (count (filter #(= % char) [(nth string start) (nth string end)])))
    ))

(count(filter
 #(let [range (parse-range (nth % 0))
        char (first (nth % 1))
        string (nth % 2)]
    (check string char range))
 input))

(count(filter
 #(let [range (parse-range (nth % 0))
        char (first (nth % 1))
        string (nth % 2)]
    (check-positions string char range))
 input))
