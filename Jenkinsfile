pipeline {
    agent any
    environment { 
	    DOCKER_USERNAME =  'goreges'
	    GITHUB_REPO_URL =  'https://github.com/goreges/dockercred1'  }

    tools {
        maven 'Maven-3.9.8' 
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${env.GITHUB_REPO_URL}"
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKER_USERNAME}/dockercred1:${env.BUILD_NUMBER}", '.')
                }
            }
        }
        
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        docker.image("${env.DOCKER_USERNAME}/dockercred1:${env.BUILD_NUMBER}").push()
                    }
                }
            }
        }
    }
}
