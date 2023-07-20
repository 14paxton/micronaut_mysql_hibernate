# SSI - Self Service Integration Notes

## DataSources
### - [Micronaut Data](https://micronaut-projects.github.io/micronaut-data/latest/guide)

#### - [MySQL Configuration](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html)

#### - [Micronaut Hibernate](https://micronaut-projects.github.io/micronaut-data/latest/guide/#hibernate)

##### - [Hibernate Reactive](https://micronaut-projects.github.io/micronaut-data/latest/guide/#hibernateReactive)

#### - [Hibernate ORM Current Documentation](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html)
- [Hibernate Annotation Documentation](https://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/)
- [Annotation Examples](https://www.digitalocean.com/community/tutorials/jpa-hibernate-annotations)

---

---
## Running
```bash
./gradlew run
```
- ***Use in build.gradle to run in dev***

```groovy
 run {
    systemProperty('micronaut.environments', 'dev')
 }
```

### Create GraalVM native image
```bash
./gradlew nativeCompile
```
#### Run Native Image in Dev
```bash
./build/native/nativeCompile/graal-vm-ssi -Dmicronaut.environments=dev
```


---

---
## Testing
### IntelliJ HTTP
[HTTP Restfull Endpoints File](rest-api.http)

### Terminal

- ***CREATE***
```bash
curl -i -d '{"companyCode": "MICROSTREAM_bpaxton"}' -H "Content-Type: application/json" -X POST http://localhost:8082/ssi
```
- ***LIST*** 
```bash
curl -i localhost:8082/ssi/
```
---

---

## Hibernate
- [Hibernate Docs](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#hibernate)

> Hibernate uses a proxy object to implement lazy loading with a default implementation generating a proxy during the runtime.
> This has a few disadvantages:
> Runtime class generation can affect startup and runtime performance
> Environments like GraalVM don’t support it

-- If you wish to use lazy entity associations and avoid runtime proxies you can enable compile-time proxies:
```yml
jpa:
  default:
    compile-time-hibernate-proxies: true
 ```

-- The entity Owner needs to be annotated with @GenerateProxy to have a proxy generated and the compile-time.
```java
@Entity
@GenerateProxy
public class Owner {
    //...
}
```


### [Joins](https://micronaut-projects.github.io/micronaut-data/latest/guide/#_jpa_2_1_entity_graphs)
```java
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Join(value = "manufacturer", type = Join.Type.FETCH) // 
    List<Product> list();
}
```

#### JPA Entity Graphs
```java
@EntityGraph(attributePaths = {"manufacturer", "title"}) // 
List<Product> findAll();
```
---

---

## Jackson JSON Annotations
- [Micronaut Config Docs](https://docs.micronaut.io/latest/guide/#_jackson_configuration)
- [Jackson Website](https://github.com/FasterXML/jackson-databind/wiki/JacksonFeatures)
- [Annotations](https://www.baeldung.com/jackson-advanced-annotations)
- [More Annotations](https://www.baeldung.com/jackson-annotations#bd-3-jsonanysetter)

## GraalVM
- [GraalVM Micronaut Docs](https://docs.micronaut.io/latest/guide/index.html#graal)



---

---


## Resources
### Micronaut 3.7.2 Documentation

- [User Guide](https://docs.micronaut.io/3.7.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.7.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.7.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

### Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


### Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)

### Feature reactor documentation

- [Micronaut Reactor documentation](https://micronaut-projects.github.io/micronaut-reactor/snapshot/guide/index.html)

### HTTP-client documentation
- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

### Security-JWT documentation
- [Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

### Liquibase documentation
- [Micronaut and Liquibase](https://micronaut-projects.github.io/micronaut-liquibase/2.0.0.M1/guide/index.html#introduction)
