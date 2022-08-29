package _self.vcsRoots

import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HomeTestTiki : GitVcsRoot({
    name = "home-test-tiki"
    url = "https://github.com/mrnim94/home-test-tiki"
    branch = "master"
})