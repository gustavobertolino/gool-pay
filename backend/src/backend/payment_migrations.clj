(ns backend.payment_migrations
 (:require [migratus.core :as migratus]
           [backend.appl_core :as appl_core]))

(def db_config {:store :database
            :migration-dir "migrations"
            :db @appl_core/db_connection_config})

;apply pending migrations
;(migratus/migrate db_config)

;rollback the last migration applied
;(migratus/rollback db_config)

;bring up migrations matching the ids
;(migratus/up db_config 20111206154000)

;bring down migrations matching the ids
;(migratus/down db_config 20111206154000)
