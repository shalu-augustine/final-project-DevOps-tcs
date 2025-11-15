pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "shaluaugustine/final-project-devops-tcs:latest"
        DOCKER_CREDS = "docker-hub-creds"   // Jenkins credentials ID
    }

    stages {
        stage('Clone GitHub Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/shaluaugustine/final-project-tcs.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh './mvnw clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Package JAR') {
            steps {
                sh './mvnw package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: DOCKER_CREDS,
                                                 usernameVariable: 'DOCKER_USER',
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker push $DOCKER_IMAGE
                    """
                }
            }
        }

        stage('Deploy to Minikube') {
            steps {
                sh '''
                kubectl apply -f k8s/deployment.yaml
                kubectl apply -f k8s/service.yaml
                kubectl rollout status deployment/final-project
                '''
            }
        }
    }
}
