(ns clarango.test.database
  (:use clojure.test clarango.core)
  (:require [clarango.database :as db]))

(deftest database-test
  (testing "Testing if the database management works.")
  (set-connection!) ;; use default address 
  (is (> (count (db/get-info-list)) 0) "At least one db should exist!") 

  (def testdb "clatest")
  (db/create testdb []) ;; Take care: any errors might leave the created db
  (is (> (count (db/get-info-list)) 1) "One more db must exist!")
  (println "*** Database List: " (db/get-info-list))

  (set-default-db! testdb)
  (println "*** Info Current <" (db/get-info-current) ">")
  ;; even if I set another db, I get info about the _system db??

  ;; error 400 "bad parameter!!"
;  (println "*** User Access DBs: <" (db/get-info-user) ">") 

  ;; Both methods get:
  ;; Wrong number of args (4) passed to: http-utility$get-uri
;  (println "Collections in the default DB: <" (db/get-collection-info-list) ">")
;  (println "Collections in the testDB: <" (db/get-collection-info-list testdb) ">")

  (db/delete testdb)
  (is (> (count (db/get-info-list)) 0) "The systen must be in the original state!") 
)
