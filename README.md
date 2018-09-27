# TIN Validation Tools


## Overview

This library provides a wrapper for the eu.europa.ec.taxud tin-algorithm.
This wrapper will consider any TIN Valid if no validator exists for a certain country.


## Building

```bash
mvn install
```

## Using

First, add the dependency to the SDK in your project, module or application.
If you use maven, add the following dependency, adjusting the version adequately:

```xml
   <dependency>
      <groupId>org.fenixedu</groupId>
      <artifactId>tinTools</artifactId>
      <version>${version.org.fenixedu.tinTools}</version>
   </dependency>
```

This artifact is available in the following maven repository:

```xml
    <repositories>
        <repository>
            <id>fenixedu-maven-repository</id>
            <url>https://repo.fenixedu.org/fenixedu-maven-repository</url>
        </repository>
    </repositories>
```

The org.fenixedu.TINValidator provides a static method for validating Tax Identification Numbers.
The method only validates TIN Numbers that are supported by the underlying tin-algorithm.
For countries not supported by the underlying tin-algorithm, this method will always return a true value.


## Examples

```java
org.fenixedu.TINValidator.isValid("PT", "123456789");
org.fenixedu.TINValidator.isValid("MZ", "abc 123 45");
```
