(ns backend.payment_handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [backend.service.payment_service :as payment_service]))

(defroutes api-routes
  (GET "/" [] "Hello World")
  (GET "/payments" [] (payment_service/get_payments))
  (POST "/payments" req (payment_service/create_payment req))

  (route/not-found "Not Found"))

(def app (-> api-routes
             (wrap-json-body :keywords? true)
             wrap-json-response))

(defn -main [] 
  (run-jetty app {:port 3000}))
