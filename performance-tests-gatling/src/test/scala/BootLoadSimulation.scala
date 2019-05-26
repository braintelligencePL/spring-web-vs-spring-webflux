import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BootLoadSimulation extends Simulation {

  private val baseUrl = "http://localhost:8010"
  private val endpoint = "/products"
  private val contentType = "application/json"
  private val requestCount = 4

  private val simUsers = System.getProperty("USERS", "1").toInt

  private val httpConf = http
    .baseURL(baseUrl)
    .acceptHeader("application/json;charset=UTF-8")

  private val addPersonTest = repeat(requestCount) {
    exec(http("create-new-product")
      .post(endpoint)
      .header("Content-Type", contentType)
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

  setUp(scn.inject(atOnceUsers(simUsers))).protocols(httpConf)
}

