package org.play.embedded

object Fibonacci {
  def compute(index: BigInt): List[BigInt] = {
    def fib(prev: List[BigInt], next: BigInt, curIndex: BigInt): List[BigInt] = {
      if (curIndex!=0) fib(next :: prev, prev.head + next, curIndex-1)
      else prev.reverse
    }

    fib(List(0),1,index)
  }
}
