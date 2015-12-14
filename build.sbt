name := "webapp"

version := "1.0"

lazy val `webapp` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.2.20.Final" ,
  "javax.inject" % "javax.inject" % "1",
  "mysql" % "mysql-connector-java" % "5.1.37",
  "org.jasypt" % "jasypt" % "1.9.2"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  