name := "FantasyDrafter"

version := "0.01"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

libraryDependencies += "org.apache.tomcat" % "tomcat-servlet-api" % "7.0.22"

libraryDependencies += "org.fusesource.scalate" % "scalate-core" % "1.5.2"

libraryDependencies += "net.databinder" %% "unfiltered-filter" % "0.5.1"