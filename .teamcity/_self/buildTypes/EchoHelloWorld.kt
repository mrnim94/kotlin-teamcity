package _self.buildTypes

import _self.vcsRoots.DockerDemo
import _self.vcsRoots.HomeTestTiki
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object EchoHelloWorld : BuildType ({
    id("HelloWorld")
    name = "Hello world"

    params {
        param("workload", "all")
    }

    vcs {
        root(HomeTestTiki, "+:. => ./home-test-tiki")
        root(DockerDemo, "+:. => ./docker-demo")
        root(DslContext.settingsRoot, "kotlin-teamcity")
    }

    steps {
        script {
            conditions {
                equals("workload", "thang")
            }
            scriptContent = """
                echo 'Hello world!'
                docker -v
                ls -la
                pwd
                echo 'Run python script'
                bash ./kotlin-teamcity/resources/bash-script/install_python3.sh
                python ./kotlin-teamcity/main.py
            """.trimIndent()
        }
    }
})