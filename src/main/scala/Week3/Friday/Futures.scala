package Week3.Friday

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import Week3.Thursday.Either.isOdd
import Week3.Thursday.Either.NewError

import scala.util.Success
object Futures extends App {

  // act as a placeholder

  def addition(x:Int, y:Int): Int = {
    Thread.sleep(1000) // sleep for one second
    x + y

    // to make the above act a future we,,,
  }

  def additionInTheFuture: Future[Int] = Future{
    addition(1,2)
  }

  val waitTime: FiniteDuration = Duration(10, TimeUnit.SECONDS)
  println(Await.result(additionInTheFuture, waitTime))


  def fetchIsOddOrError(num:Int): Future[Either[NewError, String]] =
    Future {
      Thread.sleep(1000)
      isOdd(num)
    }

  def eventualIsOddOrError: Future[Either[NewError, String]] =
    fetchIsOddOrError(4)

  def matchIsOddError = eventualIsOddOrError.value match {
    case Some(Success(complete)) => s"Future completed: $complete"
    case None => "Future did not complete in the given time"
  }

  println(Await.ready(eventualIsOddOrError, waitTime))
}

