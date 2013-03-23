(defproject cljs-intro "1.0.0-SNAPSHOT"
      :description "FIXME: write description"
      :dependencies [[org.clojure/clojure "1.4.0"]
                     [domina "1.0.0"]
                     [hiccup "1.0.3"]
                     [hiccups "0.1.1"]
                     [org.clojure/java.jdbc "0.2.3"]
                     [sqlitejdbc "0.5.6"]
                     [compojure "1.1.5"]
                     [lib-noir "0.4.6"]]
      :plugins [[lein-cljsbuild "0.2.7"]]
      :source-paths ["src/clj"]
      :cljsbuild {
                     :builds [{
                        :source-path "src/cljs"
                        :compiler {
                             :output-to "resources/public/hockey.js"
                             :optimization :whitespace
                             :pretty-print true
                             }
                        }]
                  }
      :main cljs-intro.core
    )
