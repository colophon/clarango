(ns clarango.admin
  (:require [clarango.utilities.http-utility :as http])
  (:use [clarango.utilities.uri-utility :only [build-resource-uri connect-url-parts]]))

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemLog
; GET /_api/log -> reads logging for a specific level

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemFlushServerModules
; POST /_admin/modules/flush -> flushes the modules cache on the server
; curl http://localhost:8529/_admin/modules/flush -> {"error":false,"code":200}

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemRoutingReloads
; POST /_admin/routing/reload -> Reloads the routing information from the collection routing.

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminStatistics
; GET /_admin/statistics -> read statistics as page fault, resident size, clientConnections, etc.

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminStatisticsDescription
; GET /_admin/statistics-description

; https://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminServerRole
; GET /_admin/server/role PRIMARY, SECONDARY, COORDINATOR, UNKNOWN
