pipeline {
    agent {
        docker {
            image 'gradle:jdk17'
        }
    }
    
    stages {
        stage('build') {
            steps {
                sh './gradlew build --no-daemon'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying'
            }
        }
    }
}
