(ns charts.payment_charts
  (:require [proto-repl-charts.charts :as pr_charts]
            [proto-repl-charts.table :as pr_tables]
            [proto-repl-charts.graph :as pr_graphs]))

(pr_charts/line-chart
 "Trigonometry"
 {"sin" (map #(Math/sin %) (range 0.0 6.0 0.2))
  "cos" (map #(Math/cos %) (range 0.0 6.0 0.2))})

(let [tlr (java.util.concurrent.ThreadLocalRandom/current)]
  (pr_charts/scatter-chart
   "Randoms"
   {:gaussian (repeatedly 200 #(.nextGaussian tlr))
    :uniform  (repeatedly 200 #(.nextDouble tlr))}))

(pr_charts/bar-chart
  "GDP_By_Year"
  {"2013" [16768 9469 4919 3731]
   "2014" [17418 10380 4616 3859]}
  {:labels ["US" "China" "Japan" "Germany"]})

(pr_charts/custom-chart
  "Custom"
  {:data {:columns
          [["data1" 30 20 50 40 60 50]
           ["data2" 200 130 90 240 130 220]
           ["data3" 300 200 160 400 250 250]
           ["data4" 200 130 90 240 130 220]
           ["data5" 130 120 150 140 160 150]
           ["data6" 90 70 20 50 60 120]]
          :type "bar"
          :types {:data3 "spline"
                  :data4 "line"
                  :data6 "area"}
          :groups [["data1" "data2"]]}})

(pr_tables/table
  "Users"
  [{:name "Jane" :age 24 :favorite-color :blue}
   {:name "Matt" :age 28 :favorite-color :red}
   {:name "Austin" :age 56 :favorite-color :green}
   {:name "Lisa" :age 32 :favorite-color :green}
   {:name "Peter" :age 32 :favorite-color :green}])

(pr_graphs/graph
  "A Graph from a map"
  {:nodes [:a :b :c :d :e :f :g]
   :edges [[:d :b] [:d :c] [:e :f] [:f :g]
           [:d :a] [:f :c] [:f :f] [:a :c]]})
