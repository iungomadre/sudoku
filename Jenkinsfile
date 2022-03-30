pipeline {
    agent {
        docker {
            image 'gradle:jdk17'
            label 'docker'
        }
    }
    
    stages {
        stage('build') {
            steps {
                sh ./gradlew build --no-daemon
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
}