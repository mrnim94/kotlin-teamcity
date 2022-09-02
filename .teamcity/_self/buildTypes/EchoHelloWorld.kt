package _self.buildTypes

import _self.vcsRoots.DockerDemo
import _self.vcsRoots.HomeTestTiki
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object EchoHelloWorld : BuildType ({
    id("HelloWorld")
    name = "Hello world"

    vcs {
        root(HomeTestTiki, "+:. => ./home-test-tiki")
        root(DockerDemo, "+:. => ./docker-demo")
    }

    steps {
        script {
            scriptContent = """
                echo 'Hello world!'
                docker -v
                ls -la
                pwd
                echo 'Done'
            """.trimIndent()
        }
    }
})