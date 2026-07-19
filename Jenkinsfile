pipeline {
    agent any

    stages {

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t employee-app:${BUILD_NUMBER} .'
            }
        }

        stage('Deploy Container') {
    steps {
        sh '''
        docker stop employee-app || true
        docker rm employee-app || true

        docker run -d \
          --name employee-app \
          --network employee-network \
          -p 8080:8080 \
          employee-app:${BUILD_NUMBER}
        '''
    }
}
    }
}