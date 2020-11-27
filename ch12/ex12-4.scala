// Selecting existing actorRefs via actorSelection

context.actorSelection("../siblingActor")

context.actorSelection("/user/siblingActor")

context.actorSelection("akka://someActorSystem/user/*/LogicAActor")
