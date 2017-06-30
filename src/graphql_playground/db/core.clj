(ns graphql-playground.db.core
  (:require [korma.core :as k]
            [korma.db :as db]))

(defn- env-with-name [env-name]
  (get (System/getenv) env-name))

(def subname (format "//%s/%s" (env-with-name "DATABASE_URL") (env-with-name "DATABASE_DB")))

(def user (env-with-name "DATABASE_USER"))

(def password (env-with-name "DATABASE_PASSWORD"))

(db/defdb health-db {:classname "org.postgresql.Driver"
                     :subprotocol "postgresql"
                     :subname subname
                     :user user
                     :password password})

(k/defentity counter)

(defn get-count []
  (k/select counter
   (k/fields :count)
   (k/where {:counter_id 1})))

(defn increment []
  (k/update counter
    (k/set-fields {:count (k/raw "count + 1")})
    (k/where {:counter_id 1})))
