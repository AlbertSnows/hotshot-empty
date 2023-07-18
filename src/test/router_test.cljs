(ns router-test (:require
                 [router :refer [get-hotshot-score]]
                 [data.example :refer [example-hotshot-request]]
                 [cljs.core :refer [enable-console-print!]]
                 [cljs.test
                  :refer-macros [deftest is testing run-tests]]))
(def expected-response [9 21 56 68 75 75 90 100 114 129])

(deftest entry-test [] 
  (testing "if the provided example and expected output match our implemnetation"
        (is (= expected-response (get-hotshot-score example-hotshot-request)))))

(deftest sanity-test []
  (is (= 1 1)))

(enable-console-print!)
(run-tests)
