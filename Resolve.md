1.解决jar包全爆红，引入不了pom文件问题（切换到repository目录下cmd）
(1).首先下载jar到repository目录下.
(2).mvn install:install-file
-Dfile=spring-boot-admin-starter-client-2.3.1.jar 
-DgroupId=spring-boot-admin-starter-client 
-DartifactId=spring-boot-admin-starter-client 
-Dversion=2.3.1 
-Dpackaging=jar
