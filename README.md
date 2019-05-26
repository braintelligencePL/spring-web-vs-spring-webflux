## Spring Web vs Spring Webflux vs Vert.x
Analyze performance of <b>`spring-boot-web`</b> and <b>`spring-boot-webflux`</b> and <b>`Vert.x`</b>. 

<br>

## 🏬 `product-store: 8000` - slow service

We have some slow service that responds with 200ms delay. Lets assume that this service mimics some service accessed via HTTP. To better utilize hardware that is available we have reactive stack here.

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

### Each user makes 4 requests! 📈

<br>

### Web - simple and popular blocking code

10_000 users at once. Response time started to be long.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web_10000.png)

<br> 

14_000 users at once. Too many request and application stoped to respond for some time.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web_14000.png)

<br> 

### Webflux - more efficient, but also a bit more complex to code

14_000 users at once. App seems to work just fine.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_14000.png)

<br> 

<b> Lets make 4x users to handle! </b> 56_000 users at once. Just like nothing really happen. My hardware limit is probably 1k req/s. Interesting thing is that everything works even better than with 14k users load.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_56000.png)

<br> 

## Summary: 

| Blocking - web        | Reactive - webflux | Reactive Vert.x
| --------------------------|--------------------------|--------------------------|
| run: 180sek  | run: 180sek | TODO() |
| 56k requests | 224k requests | TODO() |
| 14k failed requests | 0 failed requests | TODO() |




