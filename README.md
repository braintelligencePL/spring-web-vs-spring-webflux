# spring-web vs spring-webflux
Analyze performance of spring-boot-web and spring-boot-webflux. Blocking vs Non-Blocking.

1. We have some slow service `product-store` which responds with `400ms delay`: <br>
Run with: `./gradlew -p product-store bootRun`

2. We have normal blocking web-service `spring-boot-web`: <br>
Run with: `./gradlew -p spring-boot-web bootRun`

3. We have non-blocking, reactive web service `spring-boot-webflux`: <br>
Run with: `./gradlew -p spring-boot-webflux bootRun`

4. TODO(" Vertx ")
