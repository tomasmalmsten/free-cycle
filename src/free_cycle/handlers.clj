(ns free-cycle.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :refer :all]))

(defroutes app-routes
  (GET "/" root-page)
  (route/not-found "Not here mate, some were else."))

(defn root-page []
  (html
   [:h1 "Free-cycle"]
   [:p "Hello there, this is free-cycling. Here you can give stuff away to other that needs it."]
   [:p "What do you want to do?" [:br] 
    [:a [:href "products/add"] "Add product to give away"] [:br]
    [:a [:href "products/search"] "Find product"]]))

(def app
  (wrap-defaults app-routes site-defaults))
