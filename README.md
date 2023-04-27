# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn spotbugs:gui 
```

or 


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs. 


For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```

# Implementation Description

For this implementation, I focused on the flexibility design goal so that it is easier to expand in the future. Such as adding new drinks or new drink types. Each drink has its own class which extends from the Beverage class. The Beverage class has methods to handle adding condiments to drink. This was chosen so that the condiments implementation would not have to be duplicated in all the drink type classes. 

In terms of the understandability, the code is easy to understand and follow along while running manual tests, since the GUI used is a very simple command line interface helps as well. All methods have comments to understand what each method does easily.

One assumption made for this assignment, was that if the user inputted a value below 0 for a condiment then it is taken as 0 or if the user inputted a value above 3 it is taken as a 3. This could be changed so that users get multiple tries to choose a value between the given range.

# Compiling Instructions

Once you have imported this project onto an IDE such as IntelliJ or VSCode run the Main class to begin the program. 

After follow the prompts as given in the command line interface to interact with the vending machine and create one or multiple drinks.


