## spring-web vs spring-webflux
Analyze performance of spring-boot-web and spring-boot-webflux. Blocking vs Non-Blocking.

<br>

## 🏬 `product-store` on port 8000 - slow service

We have some slow service that responds with 200ms delay. Lets assume that this service mimics some service accessed via HTTP. To better utilize hardware that is available we have reactive stack here.

Run: `./gradlew -p product-store bootRun`

<br>

## 🕰 `spring-boot-web` on port 8010 - classical web service 

Normal blocking web-service that fetches data from product-store.

Run: `./gradlew -p spring-boot-web bootRun`

<br>

## 🧬 `spring-boot-webflux` on port 8010 - reactive web service 

Non-blocking, reactive web service that fetches data from product-store.

* Run with: `./gradlew -p spring-boot-webflux bootRun`

<br>

4. TODO(" Vertx ")

<br>

# Results 🧪⚗👩‍🔬

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

Lets make 4x users to handle! 

At 56_000 users at once. Well thats my hardware limit but as you can see nothing really happen. Everything works like harm!

![](https://github.com/braintelligencePL/playgrounds/blob/master/images/webflux_56000.png)
