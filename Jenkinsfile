pipeline {
    agent any

    environment {
        IMAGE_NAME      = "hms-app-image"
        CONTAINER_NAME  = "hms-app-container"
        HOST_PORT       = "9000"   // browser port
        CONTAINER_PORT  = "8082"   // must match server.port in application.properties
    }

    stages {

        stage('Build & Test') {
            steps {
                // Use Maven Wrapper (Windows)
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
                // Stop & remove old container if it exists, ignore errors
                bat 'docker rm -f %CONTAINER_NAME% || echo "No existing container"'
            }
        }

        stage('Run New Container') {
            steps {
                // Map HOST 9000 -> CONTAINER 8082
                bat 'docker run -d --name %CONTAINER_NAME% -p %HOST_PORT%:%CONTAINER_PORT% %IMAGE_NAME%:%BUILD_NUMBER%'
            }
        }
    }
}

