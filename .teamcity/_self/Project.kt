package _self

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object HelloWorldProject : Project({
    buildType(_self.buildTypes.EchoHelloWorld)
})