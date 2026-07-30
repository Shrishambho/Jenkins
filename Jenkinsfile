
@Library("Shared") _
pipeline{
    agent{label "shri"}
    
    stages{
        
        stage("Hello"){
            steps{
                script{
                    hello()
                }
            }
        }
      
      stage("Code"){
          steps{
              echo "This is cloning the code"
              git url: "https://github.com/Shrishambho/Jenkins.git", branch : "develop"
              echo "Code cloned successfully."
          }
      }
      
       stage("build"){
          steps{
              echo "This is building the code."
              sh "docker build -t springboot:latest ."
              echo "code build successfully."
          }
      }
      
       stage("test"){
          steps{
              echo "This is testing the code."
          }
      }
      
      stage("Push to docker hub"){
          steps{
              echo "pushing docker image to docker"
             withCredentials([usernamePassword('credentialsId':"DockerCredentials",passwordVariable : "dockerHubPass",usernameVariable:"dockerHubUser")]){
                 sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                 sh "docker image tag springboot:latest ${env.dockerHubUser}/springboot:latest"
                 sh "docker push ${env.dockerHubUser}/springboot:lates"
             } 
          }
      }
      
       stage("deploy"){
          steps{
              echo "stopping docker"
              
              echo "This is deploying the code"
              sh "docker compose up -d"
          }
      }
    }
}
