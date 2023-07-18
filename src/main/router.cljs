(ns router (:require
            [hotshot :refer [calc-hotshot-results]]
            [utility :refer [convert-json-to-clj-data]]))

(defn entry [hotshot-data]
   (let [parsed-json (convert-json-to-clj-data hotshot-data)  
         output (calc-hotshot-results (:body parsed-json))]
    output))

(comment 
  
  )