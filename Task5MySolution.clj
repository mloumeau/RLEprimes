(def RLEPRIMES '(1,1,0,1,0,1,3,1,0,1,3,1,0,1,3,1,5,1,0,1,5,1,3,1,0,1,3,1,5,1,5,1,0,1,5,1,3,1,0,1,5,1,3,1,5,1,7,1,3))

(defn if-one-get-sum [rle i]
  (if (#(= 1 %) (nth rle (- i 1)))
    (inc (apply + (replace {0 1} (take i rle))))
    0))

(defn get-primes [rle i primes]
    (if (> (count rle) i)
       (get-primes rle (inc i) (cons (if-one-get-sum rle i) primes))
       (reverse (remove #{0} primes))))

(get-primes RLEPRIMES 1 '())


;; (def RLEPRIMES '(1,1,0,1,0,1,3,1,0,1,3,1,0,1,3,1,5,1,0,1,5,1,3,1,0,1,3,1,5,1,5,1,0,1,5,1,3,1,0,1,5,1,3,1,5,1,7,1,3))

;; (defn get-primes [rle counter]
;;     (cond (#(= 1 %) (nth rle (- counter 1)))
;;        (println(inc (apply + (replace {0 1} (take counter rle))))))
;;     (cond (> (count rle) counter)
;;        (get-primes rle (inc counter))))

;; (get-primes RLEPRIMES 1)
