# Generation Parent POM

```
mvn archetype:generate -DgroupID=com.klebermagno -DartifactId=parent-project
```

Add the follow tag in the pom.xml

```
<packaging>pom</packaging>
``` 


# Creating Submodules

```
mvn archetype:generate -DgroupId=com.klebermagno -DartifactId=sub-module
```
