# Copyright (c) Martin Ueding <dev@martin-ueding.de>

cornflakes.jar: Corn.class pic
	jar -cfm cornflakes.jar manifest.txt *.class pic *.properties

Corn.class: *.java
	javac Corn.java
