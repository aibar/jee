[![Build Status](https://travis-ci.org/walkingdevs/jee.svg?branch=master)](https://travis-ci.org/walkingdevs/jee)

## Artifact

    <dependency>
        <groupId>walkingdevs</groupId>
        <artifactId>jee</artifactId>
        <version>7.2</version>
    </dependency>

    <repositories>
        <repository>
            <id>bintray</id>
            <url>http://dl.bintray.com/walkingdevs/mvn</url>
        </repository>
    </repositories>

## Building

    mvn install

## Testing

With Hsql

    mvn test

With Postgres

    docker run -d --name postgres postgres
    docker run --rm -it -v $PWD:/src -w /src --link postgres walkingdevs/mvn mvn test -Ddb=pg
    docker rm -f postgres