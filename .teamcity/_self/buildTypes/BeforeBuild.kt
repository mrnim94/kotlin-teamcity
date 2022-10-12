package _self.buildTypes

import _self.vcsRoots.HomeTestTiki
import jetbrains.buildServer.configs.kotlin.BuildType

object BeforeBuild : BuildType({
    id("HelloWorld")
    name = "Hello world"

    vcs {
        root(HomeTestTiki, "+:. => ./home-test-tiki")
    }
})