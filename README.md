## Spring Web vs Spring Webflux vs Vert.x
Analyze performance of spring-boot-web and spring-boot-webflux and Vert.x. 

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

At 10_000 users at once response time started to be long.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web_10000.png)

At 14_000 users at once app stoped responding for some time.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/web_14000.png)

### Webflux - more efficient, but also a bit more complex to code

At 14_000 users at once. Like nothing really happend

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_14000.png)

<b> Lets make 4x users to handle! </b> At 56_000 users at once nothing really happen. Another thing is that thats my hardware limit 1k req/s. Everything works even better than with 14k load.

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_56000.png)

## Summary: 

| Blocking - web        | Reactive - webflux
| ------------- |-------------|
| run: 180sek  | run: 180sek |
| 56k requests | 224k requests |
| 14k failed requests | 0 failed requests |




