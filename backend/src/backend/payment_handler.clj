(ns backend.payment-handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [clojure.tools.namespace.repl :refer [refresh]]
            [backend.service.payment-service :as payment_service])
  (:gen-class))

(defn hello-world []
  {:status 200
   :body (str "Hello World DEVS. Clojure/CLJS is Powerful!")})

(defroutes api-routes
  (GET "/" [] (hello-world))
  (GET "/payments" [] (payment_service/get_payments))
  (POST "/payments" req (payment_service/create_payment req))
  (route/not-found "Not Found"))

(def app (-> api-routes
             wrap-json-body
             wrap-json-response))

(defn -main [& args]
  (str "The app server should be started!"))

(comment
 (defonce app-server (atom nil))

 (defn start []
   (reset! app-server
           (run-jetty #'app {:port 3011 :join? false})))

 (defn stop []
   (when @app-server
     (.stop @app-server))
   (reset! app-server nil))

 (defn restart []
   (stop)
   (start))

 (restart))
