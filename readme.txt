


details can refer to http://www.mybatis.org/mybatis-3/configuration.html#properties
logImpl	Specifies which logging implementation MyBatis should use. If this setting is not present logging implementation will be autodiscovered.	
SLF4J | LOG4J | LOG4J2 | JDK_LOGGING | COMMONS_LOGGING | STDOUT_LOGGING | NO_LOGGING	NotSet

by default we didnt set any log proxy for mybatis. so if need mybatis to print out the sql we executed then we need 
to configured it first in this demo we use 

TODO:
need to go thr crutial propertoies in both configuration and mapp file
http://www.mybatis.org/mybatis-3/configuration.html
http://www.mybatis.org/mybatis-3/sqlmap-xml.html

need to understand the architecture of mybatis

SqlSessionFactoryBuilder create one SqlSessionFactory, and then use this factory to create session, session use to do CRUD operation
