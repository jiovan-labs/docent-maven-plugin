[English](README.md) | [简体中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# Docent Maven 插件

docent-maven-plugin 是一个 Maven 插件，支持生成具有多语言能力的替代性 Javadoc 注解。

## 快速开始

- 在 `pom.xml` 的 `maven-javadoc-plugin` 插件下配置

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
                        <groupId>com.jiovan.maven.plugin</groupId>
                        <artifactId>docent-maven-plugin</artifactId>
                        <version>LATEST</version>
                    </tagletArtifact>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

> 你可以按需仅引入所需的 `taglet`。

- 支持的 Javadoc 注解包括：

| 注解 | Taglet 类型 | 用法 |
|------------|-------------|-------------------------------|
| @attention | 块级 | @attention "content" |
| @dtdd | 块级 | @dtdd "title" "content" |
| @reference | 块级 | @reference "href" ["content"] |
| @task | 块级 | @task "content" |
| @url | 行内 | {&#64;url "href" ["content"]} |
| @warning | 块级 | @warning "content" |

## 文档

- GitHub：https://github.com/jiovan-labs/docent-maven-plugin

## 环境要求

- jdk 17+

## 许可证

本项目采用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证。

请参阅 `NOTICE.txt` 文件了解所需的声明与归属信息。

## 版权

北京玖漫科技有限公司

## 捐赠

喜欢这个工具包吗？欢迎[向玖漫捐赠](https://jiovan.com/donation)以支持开发。

## 网站

- 玖漫：https://jiovan.com
