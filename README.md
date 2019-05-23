## spring-web vs spring-webflux
Analyze performance of spring-boot-web and spring-boot-webflux. Blocking vs Non-Blocking.

<br>

### `product-store` - slow service

We have some slow service that responds with 200ms delay. Our data center or whatever. 

Run: `./gradlew -p product-store bootRun`

<br>

### `spring-boot-web` - Classical web service

Normal blocking web-service that fetches data from product-store.

Run: `./gradlew -p spring-boot-web bootRun`

<br>

### `spring-boot-webflux` - Reactive web service

3. We have non-blocking, reactive web service : <br>

* Run with: `./gradlew -p spring-boot-webflux bootRun`

<br>

4. TODO(" Vertx ")
