(ns cljs-intro.core
  (:use [compojure.core]
        [hiccup.core]
        [hiccup.form]
        [ring.middleware.params :only [wrap-params]])
  (:require [ring.adapter.jetty :as jetty]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [cljs-intro.db :as db]
            [noir.response :as response]))

(defn player [lastname]
  (response/json (db/get-player lastname)))

(defroutes app-routes 
;;  (GET "/" [] (message "home"))
  (GET "/player/:lastname" [lastname] (player lastname))
;;  (POST "/" [id message] (display-message id message))
  (route/resources "/")
  (route/not-found "Not Found"))
  
(defn -main []
  (jetty/run-jetty (wrap-params app-routes) {:port 8888}))
