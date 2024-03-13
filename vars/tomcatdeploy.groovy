def call(tomcatIp,warFileName,tomcatuser,credId){
  sshagent([credId]){
  sh "scp target/${warFileName} ${tomcatuser}@${tomcatIp}:/opt/tomcat9/webapps/"
  sh "ssh ${tomcatuser}@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
  sh "ssh ${tomcatuser}@ ${tomcatIp}/opt/tomcat9/bin/startup.sh"
  }
}
