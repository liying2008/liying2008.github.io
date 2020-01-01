# Spring Boot 结合 Elasticsearch 的演示代码

- **demo1**

使用 Spring Boot 官方提供的 Elasticsearch 组件。

```gradle
implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
```

- **demo2**

不使用 Spring Boot 官方提供的 Elasticsearch 组件，仅使用 Elasticsearch 官方提供的 Java API，需要依赖 Elasticsearch 官方库。

```gradle
implementation("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.5.1")
implementation("org.elasticsearch.client:elasticsearch-rest-client:7.5.1")
implementation("org.elasticsearch:elasticsearch:7.5.1")
```

Elasticsearch 官方 Java API 文档：https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.5/java-rest-high.html