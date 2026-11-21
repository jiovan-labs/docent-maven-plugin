[English](README.md) | [簡體中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# Docent Maven 外掛

docent-maven-plugin 是一個 Maven 外掛，支援生成具有多語言能力的替代性 Javadoc 註解。

## 快速開始

- 在 `pom.xml` 的 `maven-javadoc-plugin` 外掛下設定

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

> 你可以按需僅引入所需的 `taglet`。

- 支援的 Javadoc 註解包括：

| 註解 | Taglet 型別 | 用法 |
|------------|-------------|-------------------------------|
| @attention | 塊級 | @attention "content" |
| @dtdd | 塊級 | @dtdd "title" "content" |
| @reference | 塊級 | @reference "href" ["content"] |
| @task | 塊級 | @task "content" |
| @url | 行內 | {&#64;url "href" ["content"]} |
| @warning | 塊級 | @warning "content" |

## 文件

- GitHub：https://github.com/jiovan-labs/docent-maven-plugin

## 環境要求

- jdk 17+

## 許可證

本專案採用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 許可證。

請參閱 `NOTICE.txt` 檔案瞭解所需的宣告與歸屬資訊。

## 版權

北京玖漫科技有限公司

## 捐贈

喜歡這個工具包嗎？歡迎[向玖漫捐贈](https://jiovan.com/donation)以支援開發。

## 網站

- 玖漫：https://jiovan.com
