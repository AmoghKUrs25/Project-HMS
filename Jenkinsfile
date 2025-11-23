pipeline {
    agent any

    environment {
        IMAGE_NAME      = "hms-app-image"
        CONTAINER_NAME  = "hms-app-container"
        HOST_PORT       = "9000"
        CONTAINER_PORT  = "8082"
    }

    stages {
        stage('Checkout from Git') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AmoghKUrs25/Project-HMS.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvnw.cmd clean test'
                bat 'mvnw.cmd package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:%BUILD_NUMBER% .'
            }
        }

        stage('Stop Old Container (if running)') {
            steps {
                bat 'docker rm -f %CONTAINER_NAME% || echo "No existing container"'
            }
        }

        stage('Run New Container') {
            steps {
                bat 'docker run -d --name %CONTAINER_NAME% -p %HOST_PORT%:%CONTAINER_PORT% %IMAGE_NAME%:%BUILD_NUMBER%'
            }
        }
    }
}
