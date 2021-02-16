(ns backend.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [backend.payment-handler :as handler]))

(defonce app-server
  (run-jetty #'handler/app {:port 3011 :join? false}))
(defonce state (atom nil))

(defn start []
  (.start app-server)
  (reset! state 1))

(defn stop []
  (when @state
    (.stop app-server))
  (reset! state nil))

(defn restart []
  (stop)
  (start))
