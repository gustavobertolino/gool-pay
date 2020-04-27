(ns backend.demo
    (:require [clojure.string :as string]))

(defn capitalizing [some_string] (string/capitalize some_string))

(defn greet [name] (str "Hello, " name))