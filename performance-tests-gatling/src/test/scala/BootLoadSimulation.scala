
class BootLoadSimulation extends Simulation {

  private val requestCount = 4

  private val httpConf = http
    .baseURL("http://localhost:8010")
    .acceptHeader("application/json;charset=UTF-8")

  private val addPersonTest = repeat(requestCount) {
    exec(http("create-new-product")
      .post("/products")
      .header("Content-Type", "application/json")
      .body(StringBody(
        s"""
           | {
           |  "name": "name1234",
           |  "unitPrice": "1234"
           | }
         """.stripMargin
      )).check(status.is(200)))
  }
  private val scn = scenario("BootLoadSimulation")
    .exec(addPersonTest)

  setUp(
    scn.inject(
      atOnceUsers(System.getProperty("SIM_USERS", "1").toInt)
    )
  ).protocols(httpConf)
}

