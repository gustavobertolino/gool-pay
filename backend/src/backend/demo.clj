(ns backend.demo
    (:require [clojure.string :as string]
              [taoensso.timbre :as log]))

(defn capitalizing [some_string] (string/capitalize some_string))

(defn greet [name] (str "Hello, " name))

(defn dividing [x y] (try
                    (/ x y) ;; <-- dividing by zero works bad.
                       (catch Exception e
                         (log/error e "Dividing failed!")))
)

(dividing 10 0)