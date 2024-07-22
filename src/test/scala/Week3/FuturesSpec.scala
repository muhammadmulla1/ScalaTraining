package Week3

import Week3.Friday.Futures.{addition, additionInTheFuture}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Second, Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec

class FuturesSpec extends AnyWordSpec with Matchers with ScalaFutures {

  implicit val defaultWaitTime: PatienceConfig = PatienceConfig(timeout = Span(3, Seconds), interval = Span(500, Millis))

  "addition methods" should {
    "add two ints" in {
      addition(1, 2) shouldEqual 3
    }
  }

  //Unit test the future
  "additionInThFuture" should {
    "eventually return the correct sum" in {
      whenReady(additionInTheFuture) {
        result => result shouldEqual 3
      }
    }
  }
}
