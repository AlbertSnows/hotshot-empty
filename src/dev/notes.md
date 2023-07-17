 <!-- how to connect to a working cljs repl with shadow-cljs + calva -->

connect to a running repl
shadow-cljs
node-js
alt+enter namespace
it should "just work"
<!-- PS E:\Programming\assessments\hotshot> shadow-cljs node-repl
cljs.user=> shadow-cljs - #4 ready!
+
#object[cljs$core$_PLUS_]
cljs.user=> (+ 1 1)
2
cljs.user=> (require '[cljs.core :refer [js->clj]])
nil
cljs.user=> (require 'cljs.core)
nil
cljs.user=> cljs.core/+
#object[cljs$core$_PLUS_]
cljs.user=> cljs.core/js->clj
#object[cljs$core$js__GT_clj]
cljs.user=> js->clj
#object[cljs$core$js__GT_clj]
cljs.user=> (js->clj
     "{[{
               'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']
           }, {
               'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
               'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
           }]}"
)
"{[{\n               'made_shots': ['green1', 'gray2', 'red2'],\n               'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']\n        
   }, {\n               'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],\n               'attempted_shots': ['green1', 'yellow1', 'gray2',    }, {\n               'made_s
'blue1', 'red2']\n           }]}"                                                                                                                }"
cljs.user=> -->