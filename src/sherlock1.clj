(ns sherlock1
  (:require [clojure.string :as string]))

(def namespace-name "Sherlock1")

;; problem-sets are defined by tag and name
(def tag-names
  {::all "All"
   ::string "String"
   ::math "Math"
   ::logic "Logic"})

(def problems
  [{:name- "sandwich letters"
    :args ["string" "string"]
    :function (fn [a b]
                (str (first a) b (last a)))
    :verifications [["hello" "X"]
                    ["code" "Y"]]
    :output-type "string"
    :tags #{::all ::string}}
   
   {:name- "difference of closest pair"
    :args ["integer" "integer" "integer"]
    :function (fn [n1 n2 n3]
                (let [pairs [[n1 n2] [n1 n3] [n2 n3]]
                      diffs (map #(Math/abs (- (first %) (second %))) pairs)]
                  (apply min diffs)))
    :verifications [[2 5 3]
                    [10 7 16]
                    [1 3 11]]
    :output-type "integer"
    :tags #{::all ::math}}

   {:name- "all odd or even"
    :args ["integer" "integer" "integer"]
    :function (fn [a b c]
                (or (every? even? [a b c]) 
                    (every? odd? [a b c])))
    :verifications [[1 2 3]
                    [2 4 8]
                    [1 3 5]]
    :output-type "boolean"
    :tags #{::all ::logic}}

   {:name- "add biggest and smallest"
    :args ["integer" "integer" "integer"]
    :function (fn [n1 n2 n3]
                (+ (max n1 n2 n3) (min n1 n2 n3)))
    :verifications [[1 5 3]
                    [7 2 9]]
    :output-type "integer"
    :tags #{::all ::math}}
   
   {:name- "even sum"
    :args ["integer" "integer"]
    :function (fn [a b]
                (even? (+ a b)))
    :verifications [[2 4]
                    [3 6]
                    [5 8]]
    :output-type "boolean"
    :tags #{::all ::math ::logic}}
   
   {:name- "can form triangle"
    :args ["integer" "integer" "integer"]
    :function (fn [a b c]
                (and (> (+ a b) c)
                     (> (+ a c) b)
                     (> (+ b c) a)))
    :verifications [[3 4 5]
                    [1 1 3]
                    [5 5 5]]
    :output-type "boolean"
    :tags #{::all ::math ::logic}}
   
   {:name- "odd length reverse"
    :args ["string"]
    :function (fn [s]
                (if (odd? (count s))
                  (string/reverse s)
                  s))
    :verifications [["hello"]
                    ["code"]
                    ["ape"]]
    :output-type "string"
    :tags #{::all ::string}}
   
   {:name- "ignore two args"
    :args ["integer" "integer" "integer"]
    :function (fn [n1 n2 n3]
                (+ n2 3))
    :verifications [[1 5 3]
                    [7 2 9]
                    [4 4 4]]
    :output-type "integer"
    :tags #{::all ::math}}

   {:name- "count consonants"
    :args ["string"]
    :function (fn [s]
                (count (filter #(and (Character/isLetter %) 
                                     (not (#{\a \e \i \o \u \A \E \I \O \U} %))) s)))

    :verifications [["absolute"], ["bag"], ["lemon"]]
    :output-type "integer"
    :test-limit 20
    :tags #{::all ::string}}

   {:name- "subtract half"
    :args ["integer" "integer"]
    :function (fn [a b]
                (- a (quot b 2)))
    :verifications [[3, 2], [5, 5], [2, 9]]
    :output-type "integer"
    :test-limit 20
    :tags #{::all ::math}}

   {:name- "set heading"
    :args ["integer" "integer"]
    :function (fn [a b]
                (let [lat  36
                      long 140
                      vdiff (- lat a)
                      hdiff (- long b)]
                  (cond
                    (and (zero? vdiff) (zero? hdiff))
                    "secret921"

                    (> (Math/abs vdiff) (Math/abs hdiff))
                    (if (pos? vdiff) "North" "South")

                    :else
                    (if (pos? hdiff) "East" "West"))))
    :verifications [[36, 140]
                    [54, 144]
                    [30, 150]]
    :output-type "string"
    :test-limit 30
    :tags #{::all ::investigation}}

   {:name- "crack lock"
    :args ["integer" "integer" "integer"]
    :function (fn [a b c]
                (let [code [5 3 8]
                      attempts [a b c]
                      acc (reduce + (map #(Math/abs (- %1 %2)) code attempts))]
                  (if (zero? acc)
                    "secret479"
                    acc)))
    :verifications [[5 3 8]]
    :output-type "string"
    :test-limit 20
    :tags #{::all ::investigation}}])

