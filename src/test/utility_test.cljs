(ns utility-test (:require
                  [utility :refer [update-values parse preprocess-json convert-json-to-clj-data]]
                  [cljs.core :as core :refer [enable-console-print!]]
                  [cljs.test :refer-macros [deftest is testing run-tests]]))

(defn update-values-test []
  (testing "that mapping across data works"
    (= {:foo 1 :bar 2 :biz -1}
       (update-values {:foo 0 :bar 1 :biz -2} inc))))

(deftest parse-test [] 
  (testing "that parsing works"
    (is (= 
         (js->clj #js{:body #js ["hello" "world"]})
         (js->clj (parse  "{\"body\": [\"hello\", \"world\"]}"))))))

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