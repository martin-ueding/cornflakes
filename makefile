cornflakes.jar: Corn.class pic
	jar -cfm cornflakes.jar manifest.txt *.class pic *.properties

Corn.class: *.java
	javac Corn.java
