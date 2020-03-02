name := "initial"

scalaVersion := "2.12.10"


lazy val changeName = taskKey[StateTransform]("Changes project name")

lazy val changeScalaVersion = taskKey[StateTransform]("Changes scala version")

changeName := {
  val st = state.value
  val extracted = Project.extract(st)
  new StateTransform(extracted.appendWithSession(Seq(name := "changed-name"), st))
}

changeScalaVersion := {
  val st = state.value
  val extracted = Project.extract(st)


  new StateTransform(extracted.appendWithSession(Seq(scalaVersion := "2.13.1"), st))
}
