pipeline {
     agent any
     stages {
        stage("Build") {
            steps {
		echo "Building..."
            }
        }
         stage("Deploy") {
            steps {
                sh "sudo rm -rf /var/www/test.mycove.com_mycove_coremycove_api/mycove-0.0.1-SNAPSHOT.jar"
                sh "sudo yes | cp -rf ${WORKSPACE}/target/mycove-0.0.1-SNAPSHOT.jar /var/www/test.mycove.com_mycove_coremycove_api/mycove-0.0.1-SNAPSHOT.jar"
                sh "sudo service mycove_services restart"
            }
        }
    
    }
}
