// Scala's class hierarchy

// Any

import java.util.UUID

class Item {
  val id: UUID = UUID.randomUUID()
}

class ElectronicItem(val name: String, val subCategory: String) extends Item {
  val uuid: String = "Elec_" + id
}

object CartApp extends App {

  def showItem(item: ElectronicItem) = println(s"Item id: ${item.id} uuid: ${item.uuid} name: ${item.name}")

  showItem(new ElectronicItem("Xperia", "Mobiles"))
  showItem(new ElectronicItem("IPhone", "Mobiles"))
}


// Item id: 10630ea8-6f21-4994-bb2f-c4e063df6f3a uuid: Elec_10630ea8-6f21-4994-bb2f-c4e063df6f3a name: Xperia
// Item id: 492cdab2-dbb6-4f5c-b8d4-cb31147dcfbc uuid: Elec_492cdab2-dbb6-4f5c-b8d4-cb31147dcfbc name: IPhone


final def  !=  (that: Any): Boolean
final def  ==  (that: Any): Boolean
def isInstanceOf[a]: Boolean
def equals(that: Any): Boolean
def ##: Int
def hashCode: Int
def toString: String
