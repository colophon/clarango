(ns clarango.main
  (:require [clarango.core :as clacore]
            [clarango.admin :as admin]))

(defn -main []
  (println "------------Los geht's...")
  (clacore/set-connection!)
  (println "Connection gesetzt!")
  (def res (admin/flush))
  (println "Type=" (type res))
  (println "Result=" res)
  (println "------------Ende."))
