(ns router (:require
            [hotshot :refer [calc-hotshot-results]]
            [utility :refer [convert-json-to-clj-data]]))

(defn get-hotshot-score [hotshot-data]
  (let [parsed-json (convert-json-to-clj-data hotshot-data)
        output (:final-scores (calc-hotshot-results (:body parsed-json)))]
    output))
