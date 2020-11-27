// Why do we care about Akka?

// What's up with the Actor Model?

// Understanding the Actor system

val system = ActorSystem("SimpleActorSystem")
// system.actorOf(Props[SimpleActor], "simple-actor")


val anotherSimpleActor = context.actorOf(Props[AnotherSimpleActor], "another-simple-actor")


context.actorOf(Props[AnotherSimpleActor], "another-simple-actor")


// akka://SimpleActorSystem/user/simple-actor/another-simple-actor
// akka://SimpleActorSystem/user/simple-actor
