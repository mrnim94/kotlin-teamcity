package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.dockerSupport
import jetbrains.buildServer.configs.kotlin.buildSteps.PythonBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.python
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'HelloWorld'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("HelloWorld")) {
    expectSteps {
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
    steps {
        update<ScriptBuildStep>(0) {
            enabled = false
            clearConditions()
            scriptContent = """
                echo 'Hello world!'
                docker -v
                
                docker pull docker pull docker.nimtechnology.com/nim/gusaul/grpcox:latest
                ls -la
                pwd
                echo 'Run python script'
                #bash ./kotlin-teamcity/resources/bash-script/install_python3.sh
                python3 ./kotlin-teamcity/main.py
                bash ./home-test-tiki/parameter-tc.sh
                echo %parameter-nim%
            """.trimIndent()
        }
        update<PythonBuildStep>(1) {
            enabled = false
            clearConditions()
        }
        insert(2) {
            script {
                name = "Run command inside Docker container"
                scriptContent = "ls -la"
                dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
                dockerPull = true
                dockerImage = "docker.nimtechnology.com/nim/gusaul/grpcox:latest"
            }
        }
    }

    features {
        add {
            dockerSupport {
                cleanupPushedImages = true
                loginToRegistry = on {
                    dockerRegistryId = "PROJECT_EXT_10"
                }
            }
        }
    }
}
