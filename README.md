# Javadoc Docent Maven Plugin

docent-maven-plugin is a maven plugin, to support generating alternative Javadoc annotations, with multilingual capability.

## Quickstart

- Configure maven `pom.xml` under plugin `maven-javadoc-plugin`

```xml

<project>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>LATEST</version>
                <configuration>
                    <taglets>
                        <taglet>
                            <tagletClass>com.jiovan.maven.plugin.docent.taglet.AttentionTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.jiovan.maven.plugin.docent.taglet.DtddTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.jiovan.maven.plugin.docent.taglet.ReferenceTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.jiovan.maven.plugin.docent.taglet.TaskTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.jiovan.maven.plugin.docent.taglet.UrlTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.jiovan.maven.plugin.docent.taglet.WarningTaglet</tagletClass>
                        </taglet>
                    </taglets>
                    <tagletArtifact>
                        <groupId>com.jiovan.plugincom.jiovan.plugin</groupId>
                        <artifactId>docent-maven-plugin</artifactId>
                        <version>LATEST</version>
                    </tagletArtifact>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

> You may just include the necessary `taglet` as you wish.

- Supported Javadoc annotations are:

| Annotation | Taglet Type | Usage                         |
|------------|-------------|-------------------------------|
| @attention | block       | @attention "content"          |
| @dtdd      | block       | @dtdd "title" "content"       |
| @reference | block       | @reference "href" ["content"] |
| @task      | block       | @task "content"               |
| @url       | inline      | {&#64;url "href" ["content"]} |
| @warning   | block       | @warning "content"            |

## Document

- Github: https://github.com/jiovan-labs/docent-maven-plugin

## Requirement

- jdk 17+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to Jiovan](https://jiovan.com/donation) to support the development.

## Website

- Jiovan: https://jiovan.com
