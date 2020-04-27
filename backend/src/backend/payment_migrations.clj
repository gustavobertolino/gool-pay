(ns backend.payment_migrations
 (:require [migratus.core :as migratus]))

(def config {:store :database
            :migration-dir "migrations"
            :db {:classname "com.mysql.jdbc.Driver"
                :subprotocol "mysql"
                :subname "//localhost:3306/gool-pay"
                :user "root"
                :password "myuser"}})

;apply pending migrations
(migratus/migrate config)

;rollback the last migration applied
(migratus/rollback config)

;bring up migrations matching the ids
(migratus/up config 20111206154000)

;bring down migrations matching the ids
(migratus/down config 20111206154000)