(ns hotshot-test (:require
                  [hotshot :as h]
                  [cljs.test :refer-macros
                   [deftest is testing run-tests]]))

(deftest qualified-for-GOAT-mode?-test []
  (testing "that goat mode procs in the appropriat circumstances"
    (is (= true 
           (h/qualified-for-GOAT-mode?
            ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2" "gray1" "gray2"])))
    (is (= false 
           (h/qualified-for-GOAT-mode?
            ["green1" "yellow1" "blue1" "blue2" "red1" "red2"])))
    (is (= false
           (h/qualified-for-GOAT-mode?
            ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "gray1"])))))

(deftest build-calc-shots-missed-for-type-test []
  (testing "that we get the correct ratio of type to misses"
    (is (= {"red1" 2 "red2" 1}
         ((h/build-calc-shots-missed-for-type
           (frequencies ["red1" "red1" "red2"]))
          {"red2" 1} "red1" 4)))))

(deftest calc-deductible-points-test []
  (testing "if we calculate the correct number of missed red shots"
    (is (= 2
           (h/calc-deductible-points
            ["red1" "red1" "red1" "red2" "red2"] 
            ["red1" "red2" "red2"])))))

(deftest handle-heatcheck-calculation-test []
  (testing "if heatcheck is calculated correctly"
    (is (= 8  (h/handle-heatcheck-calculation 4 ["red1" "red2"])))))

(deftest calc-hotshot-score-test []
  (testing "checking that the hotshot score is calculated correctly"
    (is (= 10
           ((h/calc-hotshot-score 6)
            {:made_shots ["red1" "green1" "yellow1"] 
             :attempted_shots ["red1" "green1" "green1" "yellow1" "blue2"] 
             :heatcheck_shots [] 
             :goat_shots []})))
    (is (= 52
           ((h/calc-hotshot-score 6)
            {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
             :attempted_shots ["red2"]
             :heatcheck_shots ["green1"]
             :goat_shots ["red1"]})))))

(deftest get-hotshot-score-test []
  (testing "that the full hotshot score process"
    (is (= 0 ((h/get-hotshot-score 7)
              {:made_shots ["red1" "red1" "red2"]})))
    (is (= 57
           ((h/calc-hotshot-score 6)
            {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
             :attempted_shots ["red2"]
             :heatcheck_shots ["green1"]
             :goat_shots ["red1" "green1"]})))))

(deftest build-final-score-test []
  (testing "that we build the scores correctly"
    (is (= {:total 9 :final-scores [10 9]}
           (h/build-final-score {:total 0 :final-scores [10]} 9)))))

(deftest calc-hotshot-results-test []
  (testing "doing a full calc on some rounds"
    (is (= {:scores-per-round [42 0 27 12 -10 27 36 42 42 37] 
            :final-scores [42 42 69 81 71 98 134 176 218 255]}
           (h/calc-hotshot-results
              [{:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots ["green1"]
                :goat_shots ["red1" "green1"]}
               {:made_shots ["red1" "red1" "red1"]
                :attempted_shots []
                :heatcheck_shots []
                :goat_shots []}
               {:made_shots ["green1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots ["green1"]
                :goat_shots ["red1" "green1"]}
               {:made_shots ["grey1" "grey2" "gray1" "gray2"]
                :attempted_shots ["grey1" "grey2" "gray1" "gray2"]
                :heatcheck_shots []
                :goat_shots []}
               {:made_shots []
                :attempted_shots ["red1" "red1" "red1" "red2" "red2"]
                :heatcheck_shots []
                :goat_shots []}
               {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots []
                :goat_shots ["red1" "green1"]}
               {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots ["green1"]
                :goat_shots []}
               {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots ["green1"]
                :goat_shots ["red1" "green1"]}
               {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots ["green1"]
                :goat_shots ["red1" "green1"]}
               {:made_shots ["green1" "yellow1" "blue1" "blue2" "red1" "red2" "grey1" "grey2"]
                :attempted_shots ["red2"]
                :heatcheck_shots ["green1"]
                :goat_shots ["red1" "green1"]}])))))
(enable-console-print!)
(run-tests)