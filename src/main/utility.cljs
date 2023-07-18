(ns utility (:require 
             [cljs.core :as core]
             [clojure.string :refer [replace]]))

(defn update-values [map func & args]
  (let [update-value (fn [updated-map [key value]]
                       (assoc updated-map key (apply func value args)))
        map-with-updated-values (reduce update-value {} map)]
    map-with-updated-values))

(defn parse [json] (.parse js/JSON json))

;; Extremely rudementary, replaces *ALL* single quotes
(defn preprocess-json [json-str]
  (-> json-str
      (replace #"'(.*?)'" "\"$1\"")))

(defn convert-json-to-clj-data [json-data] 
  (js->clj (parse (preprocess-json json-data)) :keywordize-keys true))
