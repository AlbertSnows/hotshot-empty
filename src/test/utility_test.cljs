(ns utility-test (:require
                  [utility :refer [parse preprocess-json convert-json-to-clj-data]]
                  [cljs.core :as core :refer [enable-console-print!]]
                  [cljs.test
                   :refer-macros [deftest is testing run-tests]]))

(deftest parse-test [] 
  (testing "that parsing works"
    (is (= 
         (js->clj #js{:body #js ["hello" "world"]})
         (js->clj (parse  "{\"body\": [\"hello\", \"world\"]}"))))))

(= (js->clj #js[]) (js->clj #js[]))

(deftest preprocess-json-test []
  (testing "if it swaps out single quotes correctly"
    (is (= "{\"body\": [\"foo\", \"bar\"]}"
           (preprocess-json "{'body': ['foo', 'bar']}")))))

(deftest convert-json-to-clj-data-test [] 
  (testing "that the full parser system parses it into usable clojure data structures"
    (is (= (convert-json-to-clj-data "{'body': {'beep': ['boop']}}")
           {:body {:beep ["boop"]}}))))

(enable-console-print!)
(run-tests)