(ns backend.models.payment
  (:require [toucan.models :refer [defmodel]]
            [schema.core :as schema]))

(defmodel Payment :payment)
(def payment_attributes {:amount (schema/constrained schema/Str), 
                         :currency (schema/constrained schema/Str), 
                         :from (schema/constrained schema/Str), 
                         :to (schema/constrained schema/Str)})

(schema/defschema PaymentSchema payment_attributes)
