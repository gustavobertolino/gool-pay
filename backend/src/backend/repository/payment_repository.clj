(ns backend.repository.payment-repository
  (:require [backend.model.payment-model :as payment_model]
            [backend.appl-core :as appl_core]
            [clojure.java.jdbc :as db]))

(defn get_payments []
  (db/query appl_core/db_connection_config ["select * from payment"]))


(defn create_payment [req]
  (let [req_map (into {} (for [[k v] (:body req)] [(keyword k) v]))]
    (payment_model/validate_schema req_map)
    (db/insert! appl_core/db_connection_config :payment
                {:user_id (get req_map :user_id)
                 :store_id (get req_map :store_id)
                 :payment_method (get req_map :payment_method)
                 :card_brand (get req_map :card_brand)})))
