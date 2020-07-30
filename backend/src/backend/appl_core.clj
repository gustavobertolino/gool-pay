(ns backend.appl_core
  (:require [toucan.db :as db]
            [toucan.models :as models])
  (:gen-class))

(def db_connection_config {:classname "com.mysql.jdbc.Driver"
                :subprotocol "mysql"
                :subname "//localhost:3306/gool-pay"
                :user "root"
                :password "myuser"})

(defn -main  [& args]
  (println "Appl backend running...!")
  (db/set-default-db-connection! db_connection_config)
  (models/set-root-namespace! 'backend.models))
