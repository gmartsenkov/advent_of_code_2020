(ns advent-of-code.3
  (:require [clojure.string :as str]))

(def example "..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#")

(defn input->map
  [input]
  (-> input
      (str/replace #"\n" "")
      (str/split #"")
      (->> (map #(if (= % "#") true false)))))

(input->map example)
