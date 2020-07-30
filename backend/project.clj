(defproject backend "0.1.0-SNAPSHOT"
  :description "gool-pay: payment gateway in clojure"
  :url "http://github.com/gustavobertolino/gool-pay"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [migratus "1.2.8"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [honeysql "1.0.444"]
                 [toucan "1.15.1"]
                 [com.taoensso/timbre "4.10.0"]]
  
  :main backend.appl_core
  :plugins [
    [lein-ring "0.12.5"]
    [migratus-lein "0.7.3"]]

  :migratus {:store :database
           :migration-dir "migrations"
           :db {:classname "com.mysql.jdbc.Driver"
                :subprotocol "mysql"
                :subname "//localhost:3306/gool-pay"
                :user "root"
                :password "myuser"}}
  :ring {:handler backend.handler/app}
  
  :profiles {
    :dev {
      :dependencies [
        [javax.servlet/servlet-api "2.5"]
        [ring/ring-mock "0.3.2"]]}}
)
