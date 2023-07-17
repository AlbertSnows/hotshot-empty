(ns prototyping
  (:require [cljs.core :as core]))

;; Calva dev instructions
; == You Control what is Evaluated ==
;; Please note that Calva never evaluates your code
;; unless you explicitly ask for it. So, except for
;; this file, you will have to load files you open
;; yourself. Make it a habit to do this, because
;; sometimes things don't work, and they fail in
;; peculiar ways, when your file is not loaded.

;; Try it with this file: `Ctrl+Alt+C Enter`.
;; The result of loading a file is whatever is the
;; last top level form in the file.

(comment
  (let [parse #(.parse js/JSON %)
        incoming-json-example "{[{
                                             'made_shots': ['green1', 'gray2', 'red2'],
                                             'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']
                                         }, {
                                             'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
                                             'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
                                         }]}"
        simple-json "{'made_shots': ['green1', 'yellow1', 'gray2', 'blue1']}"
        simpler-json (parse "{\"foo\": 1}")
        parsed-json (js->clj simpler-json :keywordize-keys true)
        output
        parsed-json
        ;; (first parsed-json)
        ]
    output)
  (js->clj "{\"foo\": 1}")
  ;; (require '[cljs.core :refer [js->clj]])
  +
  js->clj
  (vec '("green1", "gray2", "red2"))
  (+ 1 1)
  :rtf
  )