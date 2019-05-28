import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BootLoadSimulation extends Simulation {

  private val users = System.getProperty("USERS", "1").toInt
  private val requestsPerUser = System.getProperty("REQUESTS_PER_USER", "1").toInt

  private val httpConf = http
    .baseURL("http://localhost:8010")
    .acceptHeader("application/json;charset=UTF-8")

  private val createProduct = repeat(requestsPerUser) {
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
    .exec(createProduct)

  setUp(scn.inject(
    atOnceUsers(users)
  )).protocols(httpConf)
}

