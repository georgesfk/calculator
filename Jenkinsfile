pipeline {
    agent any

    stages {
       stage('Checkout') {
                   steps {
                       // Checkout the code from the repository
                       git branch: 'main', url:'https://github.com/georgeskanan/calculator.git', credentialsId: 'credentialgit'
                   }
               }

               stage('Build') {
                   steps {
                       // Build the Spring Boot application
                       sh 'chmod +x ./mvnw'
                       sh './mvnw clean install'
                   }
               }

        stage('Test') {
            steps {
                // Run the tests
                sh './mvnw test'
            }
        }

        stage('Package') {
            steps {
                // Package the application
                sh './mvnw package'
            }
        }

    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}