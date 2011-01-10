cornflakes.jar: Corn.class
	jar -cfm cornflakes.jar manifest.txt *.class

Corn.class: *.java
	javac Corn.java
