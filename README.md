# 590610644


## To run this
0. 	Start neo4j server at `bolt://localhost:7687` user = `neo4j` password=`neo4j` role = `admin`
1.	Extract / import zip file
2.	cd 260_261218_hw4_590610644/src/main/java
3.	compile `$ javac -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4.java`
4.	run `$ java -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4 <start_node default=A> <goal_node default=H> <threshold default=5>`

	example 
	```
	>> $ java -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4 A H 3
	>> NO

	>> $ java -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4 A C 3
	>> YES
	```

### Project tree
```
260_261218_hw4_590610644
¦   build.gradle
¦   command.txt
¦   gradlew
¦   gradlew.bat
¦   README.txt
¦   settings.gradle
¦
+---.gradle
¦   +---4.0
¦   ¦   +---fileChanges
¦   ¦   ¦       last-build.bin
¦   ¦   ¦
¦   ¦   +---fileContent
¦   ¦   ¦       annotation-processors.bin
¦   ¦   ¦       fileContent.lock
¦   ¦   ¦
¦   ¦   +---fileHashes
¦   ¦   ¦       fileHashes.bin
¦   ¦   ¦       fileHashes.lock
¦   ¦   ¦       resourceHashesCache.bin
¦   ¦   ¦
¦   ¦   +---taskHistory
¦   ¦           fileSnapshots.bin
¦   ¦           taskHistory.bin
¦   ¦           taskHistory.lock
¦   ¦
¦   +---buildOutputCleanup
¦           built.bin
¦           cache.properties
¦           cache.properties.lock
¦
+---.idea
¦   ¦   compiler.xml
¦   ¦   gradle.xml
¦   ¦   misc.xml
¦   ¦   modules.xml
¦   ¦   uiDesigner.xml
¦   ¦   workspace.xml
¦   ¦
¦   +---inspectionProfiles
¦   +---libraries
¦   ¦       Gradle__junit_junit_4_12.xml
¦   ¦       Gradle__org_hamcrest_hamcrest_core_1_3.xml
¦   ¦
¦   +---modules
¦           260_261218_hw4_590610644.iml
¦           260_261218_hw4_590610644_main.iml
¦           260_261218_hw4_590610644_test.iml
¦
+---gradle
¦   +---wrapper
¦           gradle-wrapper.jar
¦           gradle-wrapper.properties
¦
+---libs
¦       neo4j-java-driver-1.5.1.jar
¦
+---out
¦   +---production
¦       +---classes
¦               Homework4$1.class
¦               Homework4$Vertex.class
¦               Homework4.class
¦
+---src
    +---main
    ¦   +---java
    ¦   ¦       Homework4$1.class
    ¦   ¦       Homework4$Vertex.class
    ¦   ¦       Homework4.class
    ¦   ¦       Homework4.java
    ¦   ¦
    ¦   +---resources
    +---test
        +---java
        +---resources
```
