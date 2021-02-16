(ns backend.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure.tools.namespace.repl :refer [refresh]]
            [backend.payment-handler :as handler]))

(comment
 (defonce state (atom nil))

 (defn start []
    (.start handler/app-server)
    (reset! state handler/app-server))

 (defn stop []
    (when @state
      (.stop handler/app-server))
    (reset! state nil))

 (defn restart []
    (stop)
    (start))

 (defn reload-all []
  (stop)
  (refresh)))
