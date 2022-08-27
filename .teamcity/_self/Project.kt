package _Self

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object HelloWorldProject : Project({
    buildType(_Self.buildTypes.EchoHelloWorld)
})