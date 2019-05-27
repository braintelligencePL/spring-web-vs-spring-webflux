## Spring Web vs Spring Webflux vs Vert.x
Analyze performance of <b>`spring-boot-web`</b> and <b>`spring-boot-webflux`</b> and <b>`Vert.x`</b>. 

<br>

## 🏬 `product-store: 8000` - slow service

We have some slow service that responds with 200ms delay. Lets assume that this service mimics some service accessed via HTTP. To better utilize hardware we have reactive stack here.

Run: `./gradlew -p product-store bootRun`

<br>

## 🕰 `spring-boot-web: 8010` - classical web service 

Normal blocking web-service that fetches data from product-store.

Run: `./gradlew -p spring-boot-web bootRun`

<br>

## 🧬 `spring-boot-webflux: 8010` - reactive web service 

Non-blocking, reactive web service that fetches data from product-store.

Run `./gradlew -p spring-boot-webflux bootRun`

<br>

## ⚗ Vertx - Web (WIP)

Go to: `cd vertx-web/`

Build and run: `./gradlew clean build && java -jar build/libs/vertx-web-1.0.0-SNAPSHOT-fat.jar`

## ⚗ TODO(" Vertx - Reactive")

<br>

## 🏎 Performance Tests

Run `./gradlew -p performance-tests-gatling loadTest -D USERS=10000`

<br>
<br>

# Results 👩‍🔬

Tests launched with: 
* MacBook Pro (15-inch, 2017)
* 2,8 GHz Intel Core i7
* 16 GB 2133 MHz LPDDR3
* Radeon Pro 555 2 GB

<br>


### Web - users at once 2_000. Each of them making 200 requests.

Simple and popular blocking code.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web-vs-webflux/web_2000users_200reqPerUser.png)

Run: `./gradlew -p performance-tests-gatling loadTest -D USERS=2000 -D REQUESTS_PER_USER=200`

### Webflux - users at once 2_000. Each of them making 200 requests.

More efficient, less popular and a bit more complex to implement.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web-vs-webflux/webflux_2000users_200reqPerUser.png)

Run: `./gradlew -p performance-tests-gatling loadTest -D USERS=2000 -D REQUESTS_PER_USER=200`

### Web - users at once 4_000. Each of them making 50 requests.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web-vs-webflux/web_4000users_50reqPerUser.png)

Run: `./gradlew -p performance-tests-gatling loadTest -D USERS=4000 -D REQUESTS_PER_USER=50`

<br> 

### Webflux - Users at once 4_000. Each of them making 50 requests.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web-vs-webflux/webflux_4000users_50reqPerUser.png)

Run: `./gradlew -p performance-tests-gatling loadTest -D USERS=4000 -D REQUESTS_PER_USER=50`

<br>

### Web - users at once 4_000. Each of them making 100 requests.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web-vs-webflux/web_4000users_100reqPerUser.png)

Run: `./gradlew -p performance-tests-gatling loadTest -D USERS=4000 -D REQUESTS_PER_USER=100`

<br> 

### Webflux - users at once 4_000. Each of them making 100 requests.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web-vs-webflux/webflux_4000users_100reqPerUser.png)

Run: `./gradlew -p performance-tests-gatling loadTest -D USERS=4000 -D REQUESTS_PER_USER=100`

<br> 

## Summary: 

| Blocking - web        | Reactive - webflux | Reactive Vert.x
| --------------------------|--------------------------|--------------------------|
| TODO() | TODO() | TODO() |
| TODO() | TODO() | TODO() |
| TODO() | TODO() | TODO() |
| TODO() | TODO() | TODO() |




