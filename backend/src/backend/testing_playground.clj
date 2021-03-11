(ns backend.testing-playground
  (:require
   [clojure.string :as string]
   [taoensso.timbre :as log]))

(defn capitalizing [some_string] (string/capitalize some_string))

(defn greet [name] (str "Hello, " name))

(def nome-richard "Richard")

(defn dividing [x y]
  (try
    (/ x y) ;; <-- dividing by zero works bad.
    (catch Exception e
      (log/error e "Dividing failed!"))))

(dividing 10 0)

(+ 1 2)

(comment
;; Calculate primes until 1000
  (reduce
   (fn [primes number]
     (if (some zero? (map (partial mod number) primes))
       primes
       (conj primes number)))
   [2]
   (take 100 (iterate inc 3)))

  (map (partial mod 5) [2 3])

;; Generate the first 100 Fibonacci numbers
;; (size of (range) + 2):
  (reduce
   (fn [a _] (conj a (+' (last a)
                         (last (butlast a)))))
   [0 1]
   (range 100))

  (take 10 (iterate (fn [[a b]] [b (+' a b)]) [0 1]))

  (conj [1]
        (+ (last [1]) (last (butlast [1]))))

  (some even? [1])

  ; Create a list from 0 to 10
  (loop [x 0
         result []]
    (if (< x 10)
      (recur (inc x)
             (conj result x))
      result))

  ; A loop that sums the numbers 10 + 9 + 8 + ...
  ; Set initial values count (cnt) from 10 and down
  (loop [sum 0
         cnt 10]
    ; If count reaches 0 then exit the loop and return sum
    (if (= cnt 0)
      sum
    ; Otherwise add count to sum, decrease count and 
    ; use recur to feed the new values back into the loop
      (recur (+ cnt sum) (dec cnt)))))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(defn my-func [args]
  (let [[element & remaining] args] element))

(my-func [1 2 3 8])

(loop [initial 0 list-acc []]
  (if (> initial 10)
    (print list-acc)
    (recur (+ 1 initial) (conj list-acc initial))))

(defn my-reduce-fn
  ([func initial collection]
   (loop [final-result initial
          remaining collection]
     (if (empty? remaining)
       final-result
       (recur (func final-result (first remaining)) (rest remaining)))))
  ([func [head & tail]]
   (my-reduce-fn func head tail)))

(my-reduce-fn + 2 [1 2 3])

(defn my-map-fn [func coll]
  (into #{} (map func coll)))

(my-map-fn inc [1 1 2 2])

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts
                  (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining
               (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)
