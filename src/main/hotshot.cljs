(ns hotshot)
;; additional work consideratinos
;; SUGGESTION: remove invalid types

(def possible-non-duplicate-shots
  #{"green1" "yellow1" "blue1" "blue2" "red1" "red2"})

(def point-values {"green1" 5
                   "yellow1" 4
                   "gray1" 3 ;; I just want to point out that I  didn't realize until working
                   "gray2" 3 ;; on this assessment there were multiple
                   "grey1" 3 ;; spellings of gr(a/e)y and now I'm having an existential crisis
                   "grey2" 3
                   "blue1" 2
                   "blue2" 2
                   "red1" 1
                   "red2" 1})

(def possible-duplicate-shots #{"grey1" "grey2" "gray1" "gray2"})

(def duplicate-shots [#{"grey1" "gray1"} #{"grey2" "gray2"}])

(def deductible-shots #{"red1" "red2"})

(def forfeit-shots #{"red1" "red2"})


;; Extremely rudementary, replaces *ALL* single quotes


(defn update-values [map func & args]
  (let [update-value (fn [updated-map [key value]]
                       (assoc updated-map key (apply func value args)))
        map-with-updated-values (reduce update-value {} map)]
    map-with-updated-values))

(defn calc-regular-shots [made_shots] (reduce #(+ %1 (get point-values %2)) 0 made_shots))

(defn qualified-for-GOAT-mode? [made_shots]
  (let [made-shots-that-cant-have-duplicates (filter #(not (contains? possible-duplicate-shots %)) made_shots)
        made-shots-that-may-be-duplicate-spots (filter #(contains? possible-duplicate-shots %) made_shots)
        unique-non-dup-shots-made (set made-shots-that-cant-have-duplicates)
        unique-versions-of-duplicate-shots (set made-shots-that-may-be-duplicate-spots)
        is-duplicate-shot? (some #(= % unique-versions-of-duplicate-shots) duplicate-shots)
        unique-possible-duplicate-shots-made (count unique-versions-of-duplicate-shots)
        made-both-gray-shots? (or (>= unique-possible-duplicate-shots-made 3)
                                  (and (= unique-possible-duplicate-shots-made 2)
                                       (not is-duplicate-shot?)))

        qualified-for-GOAT-mode? (and made-both-gray-shots?
                                      (= (count unique-non-dup-shots-made)
                                         (count possible-non-duplicate-shots)))]
    qualified-for-GOAT-mode?))

(defn calc-deductible-points [attempted_shots made_shots]
  (let [deductible-attempted-shots (filter #(contains? deductible-shots %) attempted_shots)
        non-deuctible-made-shots (filter #(contains? deductible-shots %) made_shots)
        total-non-deductible-shots-made-per-type (frequencies non-deuctible-made-shots)
        total-deductible-shots-attempted-per-type (frequencies deductible-attempted-shots)
        calc-shots-missed-for-type (fn [shots-missed-per-spot deductible-shot shots-attempted]
                                     (let [possible-shots-made-for-spot (get total-non-deductible-shots-made-per-type deductible-shot)
                                           shots-made-for-spot (if (nil? possible-shots-made-for-spot) 0 possible-shots-made-for-spot)
                                           shots-missed (- shots-attempted shots-made-for-spot)
                                           updated-map (assoc shots-missed-per-spot deductible-shot shots-missed)]
                                       updated-map))
        amount-missed-for-each-shot (reduce-kv calc-shots-missed-for-type {}
                                               total-deductible-shots-attempted-per-type)
        missed-red-shots (reduce + 0 (vals amount-missed-for-each-shot))]
    missed-red-shots))

(defn calc-heatcheck-points [heatcheck-point-values heatcheck_shots]
  (reduce #(+ %1 (get heatcheck-point-values %2)) 0 heatcheck_shots))

(defn handle-heatcheck-calculation [multiplier heatcheck_shots]
  (let [heatcheck-point-values (update-values point-values #(* % multiplier))
        heatcheck-points (calc-heatcheck-points heatcheck-point-values heatcheck_shots)]
    heatcheck-points))

(defn calc-hotshot-score [multiplier]
  (fn [{:keys [made_shots attempted_shots heatcheck_shots goat_shots]}]
    (let [points-for-round (calc-regular-shots made_shots)
          heatcheck-points (handle-heatcheck-calculation multiplier heatcheck_shots)
          goat-points (if (qualified-for-GOAT-mode? made_shots) (calc-regular-shots goat_shots) 0)
          bonus-points (+ heatcheck-points goat-points)
          missed-red-shots (calc-deductible-points attempted_shots made_shots)
          final-score-for-round (+ points-for-round bonus-points (- (* missed-red-shots 2)))]
      final-score-for-round)))

(def calc-hotshot-score-for-final-round (fn [round] ((calc-hotshot-score 2) round)))
(def calc-hotshot-score-for-normal-round (fn [round] ((calc-hotshot-score 3) round)))

(defn get-hotshot-score [{:keys [made_shots] :as round}]
  (let [made-forefeit-worthy-shots (filter #(contains? forfeit-shots %) made_shots)
        exceeded-allowed-forefeit-worthy-shots? (> (count made-forefeit-worthy-shots) 2)
        points (if exceeded-allowed-forefeit-worthy-shots? 0 (calc-hotshot-score-for-normal-round round))]
    points))

(defn calc-hotshot-results [rounds]
  (let [first-nine-rounds (take 9 rounds)
        tenth-round (nth rounds 9)
        normal-rounds-final-scores (reduce #(conj %1 (get-hotshot-score %2)) [] first-nine-rounds)
        scores-for-each-round (conj normal-rounds-final-scores (calc-hotshot-score-for-final-round tenth-round))
        final-scores (reduce (fn [{:keys [total final-scores]} score]
                               (let [updated-total (+ total score)]
                                 {:total updated-total :final-scores (conj final-scores updated-total)}))
                             {:total 0 :final-scores []} scores-for-each-round)
        output {:scores-per-round scores-for-each-round
                :final-scores (:final-scores final-scores)}]
    output))

