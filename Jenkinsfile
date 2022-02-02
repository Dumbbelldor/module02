pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('Sonar') {
            steps {
                echo 'Sonar..'
                mvn clean install sonar:sonar -Dsonar.login='2eb3291c3398748ce040cf06d20d9beae6e65c4c' -Dsonar.password='root'
            }
        }
    }
}
