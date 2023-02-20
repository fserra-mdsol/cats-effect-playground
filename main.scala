//> using scala "3.2.2"
//> using lib "org.typelevel::cats-effect:3.4.7"

def calcFib(i: Int): Int =
  if (i == 0) 0
  else if (i == 1) 1
  else calcFib(i - 1) + calcFib(i - 2)


@main
def m(): Unit = println(calcFib(6))
