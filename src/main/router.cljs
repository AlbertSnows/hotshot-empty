(ns router (:require
            [hotshot :refer [calc-hotshot-results]]
            [utility :refer [convert-json-to-clj-data]]))

(enable-console-print!)

(defn get-hotshot-score [hotshot-data]
  (let [parsed-json (convert-json-to-clj-data hotshot-data)
        rounds (:body parsed-json)
        number-of-rounds (count rounds)
        output (if (> number-of-rounds 0) 
                 (:final-scores (calc-hotshot-results (:body parsed-json)))
                 [0])
        ]
    (prn output)
    output))

(comment 
  (get-hotshot-score
   "{'body':
       [ {
            'made_shots': ['green1', 'yellow1', 'gray1', 'blue2', 'red2'],
            'attempted_shots': ['green1', 'yellow1', 'gray1', 'blue2', 'red2']}]}"
   )
  )