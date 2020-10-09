(defproject backend "0.1.0-SNAPSHOT"
  :description "gool-pay: payment gateway in clojure"
  :url "http://github.com/gustavobertolino/gool-pay"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.5.0"]
                 [ring/ring-jetty-adapter "1.8.1"]
                 [migratus "1.2.8"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [honeysql "1.0.444"]
                 [toucan "1.15.1"]
                 [prismatic/schema "1.1.12"]
                 [cljfmt "0.6.8"]
                 [com.taoensso/timbre "4.10.0"]]

  :main backend.payment_handler
  :aot [backend.payment_handler]
  :plugins [
            [lein-ring "0.12.5"]
            [migratus-lein "0.7.3"]
            [lein-cljfmt "0.6.8"]]

  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "com.mysql.jdbc.Driver"
                  :subprotocol "mysql"
                  :subname "//localhost:3306/gool-pay"
                  :user "root"
                  :password "myuser"}}
  :ring {:handler backend.payment_handler/app}

  :profiles {
             :dev {
                   :dependencies [
                                  [javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]]}})
