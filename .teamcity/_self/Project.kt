package _self

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object HelloWorldProject : Project({
    buildType(_self.buildTypes.EchoHelloWorld)
})