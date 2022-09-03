package _self

import jetbrains.buildServer.configs.kotlin.Project

object HelloWorldProject : Project({
    name = "Hello Project"
    buildType(_self.buildTypes.EchoHelloWorld)
    vcsRoot(_self.vcsRoots.HomeTestTiki)
    vcsRoot(_self.vcsRoots.DockerDemo)
    vcsRoot(_self.vcsRoots.KotlinTeamcity)
})