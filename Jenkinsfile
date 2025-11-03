pipeline{
    agent any
    stages{
        stage("Build"){
            steps{
                echo("Build the project ")
            }
        }
        stage("Run Unit Test cases"){
            steps{
                echo("Running Unit Test cases")
            }
        }
        stage("Deploy to Dev"){
            steps{
                echo("Deploying the code to Dev environment")
            }
        }
        stage("Executing Sanity Test Cases"){
            steps{
               catchError(buildResult:'SUCCESS' , stageResult: 'FAILURE'){
                  git 'https://github.com/RaghavVinu/POMSERIES.git'
                  sh "mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/config/qa_config.properties"
               }
            }
        }
    }
}