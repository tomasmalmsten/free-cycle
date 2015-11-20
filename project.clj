(defproject free-cycle "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "GNU General Public Licens 3.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot free-cycle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
