(ns backend.service.payment-service
  (:require [backend.repository.payment-repository
             :as payment_repository]))

(defn get_payments []
  (payment_repository/get_payments))

(defn create_payment [req]
  (def req_raw_format (:body req))
  (payment_repository/create_payment req))
