pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'Initializing'
        bat 'mvn clean'
      }
    }

    stage('Build') {
      steps {
        bat 'mvn package'
      }
    }

    stage('Static Analysis') {
      steps {
        bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
      }
    }

    stage('Deploy') {
      steps {
        bat 'docker build -t pixels-chatservice .'
        bat 'docker tag pixels-chatservice abhi2104/pixels-chatservice'
        bat 'docker push abhi2104/pixels-chatservice'
      }
    }

    stage('') {
      agent {
        node {
          label 'jenkinsagent'
        }

      }
      steps {
        sh 'docker pull abhi2104/pixels-chatservice'
      }
    }

  }
}