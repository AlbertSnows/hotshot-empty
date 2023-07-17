(ns prototyping
  (:require [cljs.core :as core]
            [clojure.string :refer [replace]]))

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

(def possible-shots #{"green1"
                      "gray1"
                      "gray2"
                      "yellow1"
                      "blue1"
                      "blue2"
                      "red1"
                      "red2"})

(def shot-values {"green1" 5
                  "yellow1" 4
                  "grey1" 3
                  "grey2" 3
                  "blue1" 2
                  "blue2" 2
                  "red1" 1
                  "red2" 1})

(def forfeit-shots #{"red1" "red2"})

;; Extremely rudementary, replaces *ALL* single quotes
(defn preprocess-json [json-str]
  (-> json-str
      (replace #"'(.*?)'" "\"$1\"")))

(defn strip-ends [s]
  (subs s 1 (dec (count s))))

(defn get-hotshot-score [{:keys [made_shots attempted_shots made_bonus_shots]}]
  (let [
        output 0]
    output))

(defn calc-hotshot-results [results round] 
  (let [final-score (get-hotshot-score round)
        output (conj results final-score)]
    output))

(comment
  ;; you can only earn 2 points max from red, 
  ;; any more and you forfeit
  ;; A round is forfeited and given a 0 score if you forget this rule 
  ;; and make more than 2 layups in a round.
  ;; if points >= 45 heatcheck applies
  ;; if shot from all spots GOAT applies
  ;; for rounds 1-9
  ;; heatcheck gives you 3 attempts at x3 multiplier
  ;; goat  gives you 4 bonus shots 
  ;; for round 10
  ;; for every round with >= 30 points (b4 bonus)
  ;; heatmode applies
  ;; at x2 point value
  ;; you get 2 bonus shots per round 
  ;; goat final round, when applies?
  ;; one bonus shot from each of the 8 spots
  ;; -2 points for missed, red, non-bonus shots


  (let [parse #(.parse js/JSON %)
        really-weird-json
        "{[{'made_shots': ['green1', 'gray2', 'red2'],
            'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']}, 
                           {'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
                           'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']}]}"
        parsed-json (js->clj
                     (parse
                      (preprocess-json 
                       (strip-ends really-weird-json)))
                     :keywordize-keys true)
        output 
        ;; parsed-json 
        (reduce calc-hotshot-results [] parsed-json)
        ]
    output)
  



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
  (def parse #(.parse js/JSON %))
  (parse (preprocess-json "{'made_shots': ['green1', 'yellow1', 'gray2', 'blue1']}"))
  (parse (preprocess-json "{'foo': 1}"))
  (js->clj "{\"foo\": 1}")
  ;; (require '[cljs.core :refer [js->clj]])
  +
  js->clj
  (vec '("green1", "gray2", "red2"))
  (+ 1 1)
  :rtf)