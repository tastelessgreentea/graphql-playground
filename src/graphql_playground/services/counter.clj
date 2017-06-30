(ns graphql-playground.services.counter
  (:require [ring.util.http-response :as resp]
            [graphql-playground.db.core :as db]))

(defn get-count []
  (resp/ok {:result (:count (first (db/get-count)))}))

(defn increment []
  (if (= 1 (db/increment))
    (resp/ok)
    (resp/internal-server-error {:error "Unable to increment counter"})))
