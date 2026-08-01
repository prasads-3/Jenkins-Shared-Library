def call(String imageName, String imageTag, String dockerHubUser) {

    withCredentials([usernamePassword(
        credentialsId: 'DockerHubJack',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker push ${dockerHubUser}/${imageName}:${imageTag}
            docker logout
        """
    }
}
