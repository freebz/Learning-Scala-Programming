// Actor communication via messages and its semantics

// Supervising fault in our actors

// OneForOne versus AllForOne strategy

// Default supervision strategy

// Applying the supervision strategy

import akka.actor.SupervisorStrategy.{Resume, Restart}

override val supervisorStragegy =
  OneForOneStrategy(
    maxNrOrRetries = 3,
    withinTimeRange = 1 minute
  ) {
    case _: ArithmeticException => {
      log.info("supervisor handling ArithmeticException! n Resuming!")
      Resume
    }
    case _: Exception => {
      log.info("supervisor handling Exception! n Restarting!")
      Restart
    }
  }


package example

import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props, ActorLogging}
import scala.concurrent.duration._

object SupervisionStragegyInPractice extends App {
  val system = ActorSystem("anActorSystem")
  val topLevelActor = system.actorOf(TopLevelActor.props)
  //Sending StopIt
  topLevelActor ! TopLevelActor.StopIt //Sending RestartIt
  toplevelactor ! Toplevelactor.RestartIt
}

class TopLevelActor extends Actor with ActorLogging {
  import akka.actor.SupervisorStrategy.{Resume,Restart}
  import TopLevelActor._

  override val preStart = log.info(s"TopLevelActor started!")
  override val postStop = log.info(s"TopLevelActor stopping!")

  val superSimpleActor = context.actorOf(SuperSimpleActor.props)

  override def receive = {
    case StopIt => superSimpleActor ! SuperSimpleActor.ArithmeticOpRequest
    case RestartIt => superSimpleActor ! SuperSimpleActor.OtherMessage
  }

  override val supervisorStrategy = OneForOneStragegy (
    maxNrOrRetries = 3,
    withinTimeRange = 1 minute
  ) {
    case _: ArithmeticException => {
      log.info("Supervisor handling ArithmeticException! n Resuming!')
      Resume
    }
    case _: Exception => {
      log.info("Supervisor handling Exception! n Restarting!")
      Restart
    }
  }

}

object TopLevelActor {
  val props = Props[TopLevelActor]
  case object StopIt
  case object RestartIt
}

class SuperSimpleActor extends Actor with ActorLogging {
  import SuperSimpleActor._

  override val preStart = log.info(s"SuperSimpleActor started!")
  override val postStop = log.info(s"SuperSimpleActor stopping!")

  override def preRestart(reason: Throwable, message: Option[Any]): Unit =
    log.info(s"SuperSimpleActor restarting!")

  override def receive = {
    case ArithmeticOpRequest => 1 / 0
    case OtherMessage => throw new Exception("Some Exception Occurred!")
  }

}

object SuperSimpleActor {
  val props = Props[SuperSimpleActor]

  case object ArithmeticOpRequest
  case object OtherMessage
}


// [INFO] [12/28/2017 13:35:39.856] [anActorSystem-akka.actor.default-dispather-2]
// [akka://anActorSystem/user/$a] TopLevelActor started!

// [INFO] [12/28/2017 13:35:39.856] [anActorSystem-akka.default-dispatcher-2]
// [akka://anActorSystem/user/$a] TopLevelActor stopping!

// [INFO] [12/28/2017 13:35:39.857] [anActorSystem-akka.actor.default-dispatcher-3]
// [akka://anActorSystem/user/$a/$a] SuperSimpleActor started!

// [INFO] [12/28/2017 13:35:39.857] [anActorSystem-akka.actor.default-dispatcher 3]
// [akka://anActorSystem/user/$a/$a] SuperSimpleActor stopping!

// [INFO] [12/28/2017 13:35:39.864] [anActorSystem-akka.actor.default-dispatcher-2]
// [akka://anActorSystem/user/$a] Supervisor handling ArithmeticException!

// Resuming!

// [WARN] [12/28/2017 13:35:39.865] [anActorSystem-akka.actor.default-dispatcher-2]
// [akka://anActorSystem/user/$a/$a] / by zero [INFO] [12/28/2017 13:35:39.867]
// [anActorSystem-akka.actor.default-dispatcher-2] [akka://anActorSystem/user/$a]
// Supervisor handling Exception!

// Restarting!

// [ERROR] [12/28/2017 13:35:39.868] [anActorSystem-akka.actor.default-dispatcher-2]
// [akka://anActorSystem/user/$a/$a] Some Exception Occurred!

// java.lang.Exception: Some Exception Occurred! at
// example.SuperSimpleActor$$anofun$receive$2.applyOrElse(SupervisionStragegyInPractice.s
//  at akka.actor.Actor.aroundReceive(Actor.scala:517) at
// akka.actor.Actor.aroundReceive$(Actor.scala:515) at
// example.SuperSimpleActor.aroundReceive(SupervisionStrategyInPractice.scala:55) ...

// [INFO] [12/28/2017 13:35:39.868] [anActorSystem-akka.actor.default-dispatcher-3]
// [akka://anActorSystem/user/$a/$a] SuperSimpleActor restarting!

// [INFO] [12/28/2017 13:35:39.871] [anActorSystem-akka.actor.default-dispatcher-3]
// [akka://anActorSystem/user/$a/$a] SuperSimpleActor started!

// [INFO] [12/28/2017 13:35:39.871] [anActorSystem-akka.actor.default-dispatcher-3]
// [akka://anActorSystem/user/$a/$a] SuperSimpleActor stopping!
