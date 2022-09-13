package _self.buildTypes

import _self.vcsRoots.DockerDemo
import _self.vcsRoots.HomeTestTiki
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.buildSteps.python

object EchoHelloWorld : BuildType ({
    id("HelloWorld")
    name = "Hello world"

    params {
        param("workload", "all")
        param("parameter-nim", "ahihi")
        param("env.parameter-nim-env", "ahihi")
    }

    vcs {
        root(HomeTestTiki, "+:. => ./home-test-tiki")
        root(DockerDemo, "+:. => ./docker-demo")
        root(DslContext.settingsRoot, "+:. => ./kotlin-teamcity")
    }

    steps {
        script {
            scriptContent = """
                echo 'Hello world!'
                docker -v
                ls -la
                pwd
                echo 'Run python script'
                #bash ./kotlin-teamcity/resources/bash-script/install_python3.sh
                python3 ./kotlin-teamcity/main.py
                bash ./home-test-tiki/parameter-tc.sh
                echo %parameter-nim%
            """.trimIndent()
        }
        python {
            name = "Run Python3 Script"
            command = file {
                filename = "kotlin-teamcity/main.py"
            }
        }
    }
})