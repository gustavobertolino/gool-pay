(ns backend.model.payment
  (:require [schema.core :as sch]))

(def PaymentSchema
  {:user_id sch/Int
   :store_id sch/Int
   :payment_method sch/Str
   :card_brand sch/Str})

(defn validate_schema [object]
  (sch/validate PaymentSchema object))