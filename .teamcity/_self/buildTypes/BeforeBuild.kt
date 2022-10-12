package _self.buildTypes

import _self.vcsRoots.HomeTestTiki
import jetbrains.buildServer.configs.kotlin.BuildType

object BeforeBuild : BuildType({
    id("BeforeBuild")
    name = "Before Build"

    vcs {
        root(HomeTestTiki, "+:. => ./home-test-tiki")
    }
})