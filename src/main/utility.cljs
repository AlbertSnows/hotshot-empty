(ns utility (:require 
             [cljs.core :as core]
             [clojure.string :refer [replace]]))

(defn parse [json] (.parse js/JSON json))

;; Extremely rudementary, replaces *ALL* single quotes
(defn preprocess-json [json-str]
  (-> json-str
      (replace #"'(.*?)'" "\"$1\"")))

(defn convert-json-to-clj-data [json-data] 
  (js->clj (parse (preprocess-json json-data)) :keywordize-keys true))
