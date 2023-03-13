//> using scala "3.2.2"
//> using lib "org.typelevel::cats-effect:3.4.7"

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

def calcFib(i: Long): Future[Long] =
  if (i == 0) Future.successful(0)
  else if (i == 1) Future.successful(1)
  else {
    val f1 = calcFib(i - 1)
    val f2 = calcFib(i - 2)

    f1.flatMap(i => f2.map(ii => i + ii))

  } //calcFib(i - 1) + calcFib(i - 2)

/* def calcFib(i: Long): (Long,Long) = {
  println(s"EVALUATING: $i")
  if (i == 0) {
    (0,0)
  }
  else if (i == 1) (1,0)
  else {
    val previous = calcFib(i - 1)
    (previous._1 + previous._2, previous._1)
  }
}*/

@main
def m(): Unit = println(Await.result(calcFib(42), Duration.Inf))
