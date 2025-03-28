(ns sherlock1-test
  (:require [clojure.test :refer [deftest is run-tests]]
            [sherlock1 :refer [problems]]))

;; we need some helper functions to extract the function and call it
(defn find-map-by-key-value [key value coll]
  (some #(when (= (key %) value) %) coll))

(defn eval-fn [fn-name & args]
  (apply (:function (find-map-by-key-value :name- fn-name problems)) args))

(deftest test-sandwich-letters
  (is (= "hXo" (eval-fn "sandwich letters" "hello" "X")))
  (is (= "cYe" (eval-fn "sandwich letters" "code" "Y")))
  (is (= "aorangee" (eval-fn "sandwich letters" "apple" "orange")))
  (is (= "cve" (eval-fn "sandwich letters" "cake" "v"))))

(deftest test-difference-of-closest-pair
  ;; The function finds the smallest absolute difference among pairs
  (is (= 1 (eval-fn "difference of closest pair" 2 5 3))) ; pairs => diffs => 3,1,2 => min=1
  (is (= 3 (eval-fn "difference of closest pair" 10 7 16))) ; diffs => 3,6,9 => min=3
  (is (= 2 (eval-fn "difference of closest pair" 1 3 11)))) ; diffs => 2,10,8 => min=2

(deftest test-all-odd-or-even
  (is (= false (eval-fn "all odd or even" 1 2 3)))
  (is (= true (eval-fn "all odd or even" 2 4 8)))
  (is (= true (eval-fn "all odd or even" 1 3 5))))

(deftest test-add-biggest-and-smallest
  (is (= 6 (eval-fn "add biggest and smallest" 1 5 3)))
  (is (= 11 (eval-fn "add biggest and smallest" 7 2 9))))

(deftest test-even-sum
  (is (= true (eval-fn "even sum" 2 4)))
  (is (= false (eval-fn "even sum" 3 6)))
  (is (= false (eval-fn "even sum" 5 8))))

(deftest test-can-form-triangle
  (is (= true (eval-fn "can form triangle" 3 4 5)))
  (is (= false (eval-fn "can form triangle" 1 1 3)))
  (is (= true (eval-fn "can form triangle" 5 5 5))))

(deftest test-odd-length-reverse
  (is (= "olleh" (eval-fn "odd length reverse" "hello")))
  (is (= "code" (eval-fn "odd length reverse" "code")))
  (is (= "epa" (eval-fn "odd length reverse" "ape"))))

(deftest test-ignore-two-args
  (is (= 8 (eval-fn "ignore two args" 1 5 3)))
  (is (= 5 (eval-fn "ignore two args" 7 2 9)))
  (is (= 7 (eval-fn "ignore two args" 4 4 4))))

(deftest test-set-heading
  (is (= "secret921" (eval-fn "set heading" 36 140)))
  (is (= "South" (eval-fn "set heading" 54 144)))
  (is (= "West" (eval-fn "set heading" 30 150))))

(deftest test-crack-lock
  (is (= "secret479" (eval-fn "crack lock" 5 3 8)))
  (is (= 1 (eval-fn "crack lock" 4 3 8)))
  (is (= 9 (eval-fn "crack lock" 10 5 10))))

(comment
  (run-tests)
  )
