(ns prototyping
  (:require [cljs.core :as core]
            [clojure.string :refer [replace]]
            [example :refer [example-hotshot-request test-data]]))

;; Calva dev instructions
; == You Control what is Evaluated ==
;; `Ctrl+Alt+C Enter`. load
;; `Ctrl+Enter` eval current form
;; `Alt+Enter` eval top level form
;; The result of loading a file is whatever is the
;; last top level form in the file.



(comment
 
    ;; ["green1" "yellow1" "blue2" "red1" "blue2" "gray2" "gray1" "red2" "blue1"]
  (calc-hotshot-score
   {:made_shots ["green1" "yellow1" "blue2" "red1" "blue2" "grey1" "gray1" "red2" "blue1"],
    :attempted_shots ["green1" "yellow1" "blue2" "red1" "blue2" "gray2" "gray1" "red2" "blue1"],
    :made_goat_shots ["green1" "yellow1" "gray2"]})
  ;; 5 4 3 -> 15 12 9 -> 
  ;; 12
  ;; c 23
  ;; e 35

  ;; answer: 9?
  (let [x 11 y 0 a 2 z (- a) f (+ x y z)] f)
  (+ 9 0 (- 2))


  (calc-hotshot-score
   {:made_shots ["red2" "blue1"],
    :attempted_shots ["red1" "red2" "red2" "blue1"],
    :made_bonus_shots ["green1" "yellow1" "gray2"]})

  [{:made_shots ["green1" "gray2" "red2"],
    :attempted_shots ["green1" "gray2" "blue2" "red2"]}
   {:made_shots ["green1" "yellow1" "gray2" "blue1"],
    :attempted_shots ["green1" "yellow1" "gray2" "blue1" "red2"]}
   {:made_shots ["green1" "yellow1" "blue2" "red1" "blue2" "gray2" "gray1" "red2" "blue1"],
    :attempted_shots ["green1" "yellow1" "blue2" "red1" "blue2" "gray2" "gray1" "red2" "blue1"],
    :made_goat_shots ["green1" "yellow1" "gray2"]}
   {:made_shots ["green1" "yellow1" "blue2" "red2"],
    :attempted_shots ["green1" "yellow1" "blue2" "red2"]}
   {:made_shots ["green1" "yellow1"],
    :attempted_shots ["green1" "yellow1" "gray2" "blue2" "red2"]}
   {:made_shots ["red2" "green1" "blue1" "red2" "red1"],
    :attempted_shots ["red2" "green1" "blue1" "red2" "red1" "green1"]}
   {:made_shots ["green1" "yellow1" "gray2" "blue1" "red1"],
    :attempted_shots ["green1" "yellow1" "gray2" "blue1" "red1"]}
   {:made_shots ["green1" "yellow1" "gray2"],
    :attempted_shots ["green1" "yellow1" "gray2" "blue1" "red2"]}
   {:made_shots ["green1" "yellow1" "gray2" "blue2"],
    :attempted_shots ["green1" "yellow1" "gray2" "blue2"]}
   {:made_shots ["green1" "yellow1" "gray1" "blue2" "red2"],
    :attempted_shots ["green1" "yellow1" "gray1" "blue2" "red2"]}]
  [11 18 30 15 11 0 19 15 18 0]

  (def parsed-json (js->clj
                    (parse
                     (preprocess-json example-hotshot-request))
                    :keywordize-keys true))

  (def really-weird-json
    "{[{'made_shots': ['green1', 'gray2', 'red2'],
                   'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']},
                   {'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
                   'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']}]}")
  (def weird-json "[{'made_shots': ['green1', 'gray2', 'red2'],
                   'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']},
                   {'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
                   'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']}]")
  (def simple-json "{'made_shots': ['green1', 'yellow1', 'gray2', 'blue1']}")
  (def         incoming-json-example "{[{
                                                    'made_shots': ['green1', 'gray2', 'red2'],
                                                    'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']
                                                }, {
                                                    'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
                                                    'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
                                                }]}")
  (preprocess-json "{'foo': 1}")
  (parse (preprocess-json "{'made_shots': ['green1', 'yellow1', 'gray2', 'blue1']}"))
  (parse (preprocess-json "{'foo': 1}"))
  (js->clj "{\"foo\": 1}")
  ;; (require '[cljs.core :refer [js->clj]])
  +
  js->clj
  (vec '("green1", "gray2", "red2"))
  (+ 1 1)
  :rcf)