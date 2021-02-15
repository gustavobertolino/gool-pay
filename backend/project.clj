(defproject backend "0.1.0-SNAPSHOT"
  :description "gool-pay: payment gateway in clojure"
  :url "http://github.com/gustavobertolino/gool-pay"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.5.0"]
                 [ring/ring-jetty-adapter "1.8.1"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [prismatic/schema "1.1.12"]
                 [com.taoensso/timbre "4.10.0"]
                 [proto-repl "0.3.1"]]

  :main ^:skip-aot backend.payment-handler
  :plugins [[lein-ring "0.12.5"]]

  :ring {:handler backend.payment-handler/app
         :nrepl {:start? true
                 :port 3030}
         :port 8090}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]]}})
