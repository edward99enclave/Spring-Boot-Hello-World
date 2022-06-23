pipeline {
     agent any
     stages {
        stage("Build") {
            steps {
		echo "Building..."
		sh "sudo mvn clean install"
            }
        }
         stage("Deploy") {
            steps {
                sh "sudo rm -rf /var/www/test.mycove.com_mycove_coremycove_api/demo-0.0.1-SNAPSHOT.jar"
                sh "sudo yes | cp -rf ${WORKSPACE}/target/demo-0.0.1-SNAPSHOT.jar /var/www/test.mycove.com_mycove_coremycove_api/demo-0.0.1-SNAPSHOT.jar"
                sh "sudo service mycove_services restart"
            }
        }
    
    }
}
