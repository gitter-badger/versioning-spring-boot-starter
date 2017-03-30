node {
	stage('Git', {
		checkout scm
	})
	withEnv(["JAVA_HOME=${tool 'oracle-jce-1.8'}"]) {
	    withMaven(maven: 'maven-3.3.9', mavenSettingsConfig: 'maven-global-settings') {
	        stage('Compile', { sh 'mvn clean compile' })
	        stage('Tests', {
	        	try {
	        		sh 'mvn verify'
	        	} finally {
	        		junit 'target/surefire-reports/*.xml'
	        	}
	        })
	        stage('Package', { sh 'mvn package -DskipTests=true' })
	        stage('Nexus', { sh 'mvn deploy -DskipTests=true' })
	    }
	}
} 