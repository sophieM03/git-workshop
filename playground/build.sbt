lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "playground",
    scalaJSUseMainModuleInitializer := true,
    artifactPath in (Compile, fastOptJS) :=
      ((crossTarget in (Compile, fastOptJS)).value / ((moduleName in fastOptJS).value + "-opt.js")),
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalacss" %%% "core"         % "0.5.3",
      "in.nvilla"                    %%% "monadic-html" % "0.4.0-RC1"
    )
  )

lazy val commonSettings = Seq(
  scalaVersion := "2.12.4",
  scalacOptions := Seq(
    "-deprecation",
    "-encoding",
    "utf-8",
    "-explaintypes",
    "-feature",
    "-language:existentials",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xcheckinit",
    "-Xfatal-warnings",
    "-Xfuture",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ypartial-unification",
    "-Ywarn-dead-code",
    "-Ywarn-extra-implicit",
    "-Ywarn-inaccessible",
    "-Ywarn-infer-any",
    "-Ywarn-nullary-override",
    "-Ywarn-nullary-unit",
    "-Ywarn-numeric-widen",
    "-Ywarn-unused",
    "-Ywarn-value-discard"
  ),
  scalacOptions in (Compile, console) ~= {
    _.filterNot { opt =>
      opt.startsWith("-X") || opt.startsWith("-Y")
    }
  },
  scalacOptions in (Test, console) ~= {
    _.filterNot { opt =>
      opt.startsWith("-X") || opt.startsWith("-Y")
    }
  }
)

scalafmtOnCompile in ThisBuild := true
scalafmtTestOnCompile in ThisBuild := true
