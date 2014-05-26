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

(defn reload []
  "Realods the routing information from the collection routing.
  No Arguments can be passed.
  This REST call should return '{error false, code 200}'
  with the 200 indicating that the routing information was reloaded successfully."
  (http/post-uri [:body] (connect-url-parts (get-safe-connection-url) "_admin/modules/reload")))

(defn statistics []
 "Returns a huge Json doc with statistics information.
 Please look up http://www.arangodb.org/manuals/current/HttpSystem#HttpSystemAdminStatistics"
 (http/post-uri [:body] (connect-url-parts (get-safe-connection-url) "_admin/statistics")))

(defn stat-desc []
 "Returns a description of the statistics returned by /_admin/statistics. The returned objects contains a list of statistics groups in the attribute groups and a list of statistics figures in the attribute figures. For a detailed description please refer to 
http://www.arangodb.org/manuals/current/HttpSystem.html#HttpSystemAdminStatisticsDescription"
  (http/post-uri [:body] (connect-url-parts
                           (get-safe-connection-url)
                           "_admin/statistics-description")) )

(defn role [] ; GET, unknown path
 "Description")

(defn log [params] ; GET, unknown path
  "Description")
