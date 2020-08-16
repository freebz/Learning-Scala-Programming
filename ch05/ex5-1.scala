// Motivation

object RESTFulAPIs extends App {
    //List of Method and URI
    val listOfAPIs = List(("GET", "/user/:id"),
                          ("GET", "user/:id/profile/:p_id"),
                          ("POST", "/user"),
                          ("POST", "/profile"),
                          ("PUT", "/user/:id"))

    /*
     * Returns a scala.collection.immutable.Map[String, List[(String,String)]]
     */
    val groupedListOfAPIs = listOfAPIs.groupBy(_._1)
    println(s"APIs grouped to a Map :: $groupedListOfAPIs")

    /*
     * Returns a scala.collection.immutable.Map[String, List[String]]
     */
    val apisByMethod = groupedListOfAPIs.mapValues(_.map(_._2))

    println(s"APIs By Method :: $apisByMethod")
}


// APIs grouped to a Map :: Map(POST -> List((POST,/user), (POST,/profile)), GET -> List((GET,/user/:id), (GET,user/:id/profile/:p_id)), PUT -> List((PUT,/user/:id)))
// APIs By Method :: Map(POST -> List(/user, /profile), GET -> List(/user/:id, user/:id/profile/:p_id), PUT -> List(/user/:id))
