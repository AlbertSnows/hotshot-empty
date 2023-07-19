(ns deprecated)

(defn strip-ends [s]
  (subs s 1 (dec (count s))))