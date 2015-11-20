(ns free-cycle.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.anti-forgery :refer :all]
            [ring.middleware.session.cookie :refer (cookie-store)]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.form :refer :all]))

(defn root-page []
  (html
   [:h1 "Free-cycle"]
   [:p "Hello there, this is free-cycling. Here you can give stuff away to other that needs it."]
   [:p "What do you want to do?" [:br] 
    [:a {:href "/products/add"} "Add product to give away"] [:br]
    [:a {:href "/products/search"} "Find product"]]))

(defn add-product-form []
  (form-to [:post "/products/add"]
           (label :title "Title") (text-field :title) [:br]
           (label :description "Description") (text-area :description)[:br]
           (label :upload-picture "Upload picture") (file-upload :upload-picture)[:br]
           (label :giver-name "Your name") (text-field :givers-name)[:br]
           (label :giver-email "Your e-mail") (email-field :givers-email)[:br]
           (label :givers-phone "Your phone number") (text-field :givers-phone)[:br]
           (label :givers-address-one "Your addres, line one") (text-field :givers-address-one)[:br]
           (label :giver-address-two "Your address, line two") (text-field :givers-address-two)[:br]
           (label :givers-address-three "Your addres, line three") (text-field :givers-address-trhee)[:br]
           (label :givers-postcode "Your post code") (text-field :givers-postcode)[:br]
           (label :givers-city "Your city") (text-field :givers-city)[:br]
           (label :givers-country "Your country") (text-field :givers-country)[:br]
           (submit-button "Save item")))

(defn add-product-html []
  (html5
   {:lang "en"}
   [:h1 "This is where we add something..."]
   [:div
    [:p "Complete the form and press save and you've just posted something"]
    (add-product-form)]))

(defn add-product [request]
  (str request))

(defroutes app-routes
  (GET "/" [] (root-page))
  (GET "/products/add" [] (add-product-html))
  (POST "/products/add" request (add-product request))
  (route/not-found "This part's probably not done yet. Perhaps it's not s'posed to every get done."))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (wrap-session {:cookie-attrs {:max-age 3600}
                     :store (cookie-store {:key "not-currenlty-th"})})))
