import sbt._
import Keys._

object $name;format="Camel"$Build extends Build {
  val Organization = "$organization$"
  val Name = "$name$"
  val Version = "$version$"
  val ScalaVersion = "$scala_version$"

  lazy val project = Project (
    "$name;format="norm"$",
    file("."),
    settings = Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      scalacOptions ++= Seq("-deprecation", "-feature"),
      resolvers ++= Seq(Resolver.url("nexus-ivy", url("http://cq01-rdqa-pool106.cq01.baidu.com:8081/nexus/content/groups/public/"))(Resolver.ivyStylePatterns),
            "nexus-m2" at "http://cq01-rdqa-pool106.cq01.baidu.com:8081/nexus/content/groups/public/"),
      // resolvers ++= Seq(Resolver.url("nexus-ivy", url("http://cq01-rdqa-pool106.cq01.baidu.com:8081/nexus/content/groups/public/"))(Resolver.ivyStylePatterns),
      //      "nexus-m2" at "http://cq01-rdqa-pool106.cq01.baidu.com:8081/nexus/content/groups/public/",
      //      Classpaths.typesafeReleases),
      externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false),
      //      publishTo := {
      //        val nexus = "http://cq01-rdqa-pool106.cq01.baidu.com:8081/nexus/content/repositories/"
      //        if (isSnapshot.value)
      //          Some("snapshots" at nexus + "baidu-snapshot")
      //        else
      //          Some("releases" at nexus + "baidu")
      //      },
      //      credentials += Credentials("Sonatype Nexus Repository Manager", "cq01-rdqa-pool106.cq01.baidu.com", "admin", "!@34QWer"),
      libraryDependencies ++= Seq(
        "ch.qos.logback" % "logback-classic" % "1.1.2"
      )
    )
  )
}
