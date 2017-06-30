(defproject graphql-playground "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.5.1"]
                 [metosin/compojure-api "1.1.10"]
                 [clojure-future-spec "1.9.0-alpha14"]
                 [migratus "0.9.3"]
                 [org.clojure/java.jdbc "0.7.0-alpha2"]
                 [org.postgresql/postgresql "9.4.1212"]
                 [korma "0.4.3"]]
  :plugins [[lein-ring "0.11.0"]
            [migratus-lein "0.4.1"]]
  :ring {:handler graphql-playground.handler/app}
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "org.postgresql.Driver"
                  :subprotocol "postgresql"
                  :subname ~(format "//%s/%s"
                              (get (System/getenv) "DATABASE_URL") (get (System/getenv) "DATABASE_DB"))
                  :user ~(get (System/getenv) "DATABASE_USER")
                  :password ~(get (System/getenv) "DATABASE_PASSWORD")}}
  :uberjar-name "server.jar")
