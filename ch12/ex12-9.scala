// The preStart and postStop hooks

override def preStart(): Unit = log.info("SimpleActor starting!")
override def postStop(): Unit = log.info("SimpleActor stopping!")


// [INFO] [12/27/2017 14:56:54.887] [SimpleActorSystem-akka.actor.default-dispatcher-3]
// [akka://SimpleActorSystem/user/simple-actor] SimpleActor starting!
// [INFO] [12/27/2017 14:56:54.915] [SimpleActorSystem-akka.actor.default-dispatcher-2]
// [akka://SimpleActorSystem/user/simple-actor] Executing
// GetPlayerInformationRequest(Cristiano Ronaldo, listOfPlayers)
// Player(Cristiano Ronaldo,Portugal,32,Real Madrid,Spain,4829,4789,1,2)
// [INFO] [12/27/2017 14:56:54.938] [SimpleActorSystem-akka.actor.default-dispatcher 2]
// [akka://SimpleActorSystem/user/simple-actor] SimpleActor stopping!
