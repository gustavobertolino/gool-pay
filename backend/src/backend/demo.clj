(ns backend.demo
  (:require [clojure.string :as string]
            [taoensso.timbre :as log]))

(defn capitalizing [some_string] (string/capitalize some_string))

(defn greet [name] (str "Hello, " name))

(defn dividing [x y] (try
                       (/ x y) ;; <-- dividing by zero works bad.
                       (catch Exception e

                         (log/error e "Dividing failed!"))))

(dividing 10 0)
(dividing 10 22)

(range 10)

(defn my_new_func [num1 num2]
 (* num1 num2))

(defn reducing [list]
  (reduce + list))

(def nested-map {:a 1 :b {:c 100 :d 200}})

(defn get-object [nested-map] (get-in nested-map [:b :d]))