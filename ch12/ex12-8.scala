// Stopping Actors

case "terminate" => context stop self


simpleActor ! PoisonPill
