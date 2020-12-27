(ns advent-of-code.1
  (:require [clojure.math.combinatorics :as combo]
            [clojure.string :as str]))

(defn sum [list] (reduce + list))

(def input
  (as->
   (slurp "./resources/1") v
    (str/split v #"\n")
    (map #(Integer/parseInt %) v)))

;; PART 1
(as-> input v
  (combo/combinations v 2)
  (filter #(= (sum %) 2020) v)
  (first v)
  (reduce * v))

;; PART 2
(as-> input v
  (combo/combinations v 3)
  (filter #(= (sum %) 2020) v)
  (first v)
  (reduce * v))
