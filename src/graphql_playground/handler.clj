(ns graphql-playground.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [graphql-playground.services.counter :as counter]))

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Backend"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}

    (context "/api" []
      :tags ["api"]

      (GET "/get-count" []
        :return {:result Long}
        :summary "return the most up to date count value"
        (counter/get-count))

      (POST "/increment" []
        :summary "increment the app counter"
        (counter/increment)))))
