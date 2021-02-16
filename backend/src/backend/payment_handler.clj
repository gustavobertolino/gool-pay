(ns backend.payment-handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [backend.service.payment-service :as payment_service])
  (:gen-class))

(defn hello-world [] (prn "Hello World DEVS Node!"))

(defroutes api-routes
  (GET "/" [] (hello-world))
  (GET "/payments" [] (payment_service/get_payments))
  (POST "/payments" req (payment_service/create_payment req))
  (route/not-found "Not Found"))

(def app (-> api-routes
             wrap-json-body
             wrap-json-response))

(defn -main [& args]
  (run-jetty app {:port 3010}))
