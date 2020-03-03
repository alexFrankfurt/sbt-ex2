name := "initial"

scalaVersion := "2.12.10"

lazy val changeName = taskKey[StateTransform]("Changes project name")

lazy val changeScalaVersion = taskKey[StateTransform]("Changes scala version")

changeName := {
  StateTransform((s: State) => {
    val extracted = Project.extract(s)
    extracted.appendWithSession(Seq(name := "changed-name"), s)
  })
}

changeScalaVersion := {
  StateTransform((s: State) => {
    val extracted = Project.extract(s)
    extracted.appendWithSession(Seq(scalaVersion := "2.13.1"), s)
  })
}
