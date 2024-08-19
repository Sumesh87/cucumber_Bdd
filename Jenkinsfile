pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
                withMaven {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Testing Stage') {
            steps {
                withMaven {
                    bat 'mvn test'
                }
            }
        }

        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE", {
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'   
                }
            }
        }
    }
}
