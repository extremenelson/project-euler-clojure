(ns project-euler.problem-187
  (:require [project-euler.utils :refer [sieve]]))

(defn semi-primes-count [upper-limit]
  (loop [cnt 0, p-seq (sieve (quot upper-limit 2))]
    (if (empty? p-seq)
      cnt
      (let [max-fact (quot upper-limit (first p-seq))
            next-p-seq (drop-while #(> % max-fact) (reverse p-seq))]
        (recur
          (+ cnt (count next-p-seq))
          (rest (reverse next-p-seq)))))))

(defn solution-187 []
  (semi-primes-count 1e8))
