pipeline {
    agent any
environment {
    IMAGE_NAME      = "hms-app-image"
    CONTAINER_NAME  = "hms-app-container"
    HOST_PORT       = "9000"   // port you use in browser
    CONTAINER_PORT  = "8082"   // MUST match server.port and EXPOSE
}

}

stage('Run New Container') {
    steps {
        bat 'docker run -d --name %CONTAINER_NAME% -p %HOST_PORT%:%CONTAINER_PORT% %IMAGE_NAME%:%BUILD_NUMBER%'
    }
}
