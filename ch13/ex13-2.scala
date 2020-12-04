// Executor and ExecutionContext

import java.util.concurrent.ForkJoinPool
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object TowardsExecutor extends App {

  val executor: ForkJoinPool = new java.util.concurrent.ForkJoinPool()
  executor.execute(new Runnable {
    override def run(): Unit =
      println(s"${Thread.currentThread().getName()} printing this in execution of juc.ForkJoinPool!")
  })

  val ec: ExecutionContextExecutor = ExecutionContext.global
  ec.execute(new Runnable {
    override def run(): Unit =
      println(s"${Thread.currentThread().getName()} printing this in execution of sc.ExecutionContext!")
  })
}


import java.util.concurrent.ForkJoinPool
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object TowardsExecutor extends App {

  val executor: ForkJoinPool = new java.util.concurrent.ForkJoinPool()
  executor.execute(new Runnable {
    override def run(): Unit =
      println(s"${Thread.currentThread().getName()} printing this in execution of juc.ForkJoinPool!")
  })

  val ec: ExecutionContextExecutor = ExecutionContext.global
  ec.execute(new Runnable {
    override def run(): Unit =
      println(s"${Thread.currentThread().getName()} printing this in execution of sc.ExecutionContext!")
  })

  Thread.sleep(500)

}


// ForkJoinPool-1-worker-1 printing this in execution of sc.ExecutionContext!
// ForkJoinPool-2-worker-1 printing this in execution of juc.ForkJoinPool!
