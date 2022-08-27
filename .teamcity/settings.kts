import jetbrains.buildServer.configs.kotlin.*

version = "2022.04"
project {
    description = "MetaDefender Cloud"

    subProject(_self.HelloWorldProject)
}
  