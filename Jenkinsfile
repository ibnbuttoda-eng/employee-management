pipeline {
    agent any

    stages {

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t employee-app:v1 .'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker stop employee-app || true
                docker rm employee-app || true
                docker run -d --name employee-app -p 8080:8080 employee-app:v1
                '''
            }
        }
    }
}