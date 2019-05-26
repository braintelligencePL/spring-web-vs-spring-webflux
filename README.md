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

* Run with: `./gradlew -p spring-boot-webflux bootRun`

<br>

## ⚗ TODO(" Vertx ")

<br>

## 🏎 Performance Tests

1. Go to `cd performance-tests-gatling/`
2. Run with: `./gradlew loadTest -D SIM_USERS=10000`

<br>
<br>

# Results 👩‍

Tests launched with: 
* MacBook Pro (15-inch, 2017)
* 2,8 GHz Intel Core i7
* 16 GB 2133 MHz LPDDR3
* Radeon Pro 555 2 GB

<br> 

### Web - simple and popular blocking code

10_000 users at once. Response time started to be long.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web_10000.png)

14_000 users at once. Too many request and application stoped to respond for some time.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web_14000.png)

### Webflux - more efficient, but also a bit more complex to code

14_000 users at once. App seems to work just fine.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_14000.png)

<b> Lets make 4x users to handle! </b> At 56_000 users at once nothing really happen. Another thing is that thats my hardware limit 1k req/s. Everything works even better than with 14k load.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_56000.png)

## Summary: 

| Blocking - web        | Reactive - webflux | Reactive Vert.x
| --------------------------|--------------------------|--------------------------|
| run: 180sek  | run: 180sek | TODO() |
| 56k requests | 224k requests | TODO() |
| 14k failed requests | 0 failed requests | TODO() |




