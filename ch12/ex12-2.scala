// Props

val props = Props[SimpleActor]()
  .withDispatcher("some-simple-dispatcher")

val simpleActor: ActorRef = system.actorOf(props, "simple-actor")
