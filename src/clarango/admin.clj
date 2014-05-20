(ns clarango.admin
  (:require [clarango.utilities.http-utility :as http])
  (:use [clarango.utilities.core-utility :only [get-safe-connection-url]]
        [clarango.utilities.uri-utility :only [connect-url-parts]]))

(defn flush []
  "The call flushes the modules cache on the server.
  See JSModulesCache for details about this cache.
  No Arguments can be passed.
  This REST call should return '{error false, code 200}'
  with the 200 indicating that the module cache was flushed successfully."
  (http/post-uri [:body] (connect-url-parts (get-safe-connection-url) "_admin/modules/flush")))

; (http/post-uri [:body] (build-resource-uri "database" nil nil "_system")
; {:name database-name :users users}))

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemLog
; GET /_api/log -> reads logging for a specific level

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemRoutingReloads
; POST /_admin/routing/reload -> Reloads the routing information from the collection routing.

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminStatistics
; GET /_admin/statistics -> read statistics as page fault, resident size, clientConnections, etc.

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminStatisticsDescription
; GET /_admin/statistics-description

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminServerRole
; GET /_admin/server/role PRIMARY, SECONDARY, COORDINATOR, UNKNOWN
