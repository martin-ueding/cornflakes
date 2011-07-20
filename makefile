# Copyright (c) Martin Ueding <dev@martin-ueding.de>

cornflakes.jar: Corn.class pic
	jar -cfm $@ manifest.txt *.class pic *.properties

Corn.class: *.java
	javac Corn.java

clean:
	rm -rf *.class *.jar
