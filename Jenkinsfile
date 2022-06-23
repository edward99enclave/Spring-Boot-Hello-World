pipeline {
     agent any
     tools { 
        maven 'Maven 3.8.5' 
        jdk 'jdk9.0.4' 
     }
     stages {
	stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage("Build") {
            steps {
		echo "Building..."
		sh "mvn clean install"
            }
        }
         stage("Deploy") {
            steps {
                sh "rm -rf /var/www/test.mycove.com_mycove_coremycove_api/demo-0.0.1-SNAPSHOT.jar"
                sh "yes | cp -rf ${WORKSPACE}/target/demo-0.0.1-SNAPSHOT.jar /var/www/test.mycove.com_mycove_coremycove_api/demo-0.0.1-SNAPSHOT.jar"
                sh "service mycove_services restart"
            }
        }
    
    }
}
