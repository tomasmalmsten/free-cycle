(defproject free-cycle "0.1.0-SNAPSHOT"
  :description "An application where people can enable re-use for free with ease."
  :url "https://github.com/tomasmalmsten"
  :min-lein-version "2.0.0"
  :license {:name "GNU General Public Licens 3.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler free-cycle.handlers/app}
  :main ^:skip-aot free-cycle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
            :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]}})
