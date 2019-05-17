import Clothing.RemovingPJs

import scala.collection.mutable.ListBuffer

/**
  * Clothing Trait
  */
trait Clothing {
  def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
    // PJ is not removed or clothing already on
    !clothings.contains(RemovingPJs) || clothings.contains(this)
  }
}

/**
  * Clothing constructor with nested clothing objects
  */
object Clothing {

  val DRESSER = Map(
    (Temperature.HOT, "1") -> Sandals,
      (Temperature.HOT, "2") -> Sunglasses,
      (Temperature.HOT, "3") -> Fail,
      (Temperature.HOT, "4") -> Shirt,
      (Temperature.HOT, "5") -> Fail,
      (Temperature.HOT, "6") -> Shorts,
      (Temperature.HOT, "7") -> LeavingHouse,
      (Temperature.HOT, "8") -> RemovingPJs,
      (Temperature.COLD, "1") -> Boots,
      (Temperature.COLD, "2") -> Hat,
      (Temperature.COLD, "3") -> Socks,
      (Temperature.COLD, "4") -> Shirt,
      (Temperature.COLD, "5") -> Jacket,
      (Temperature.COLD, "6") -> Pants,
      (Temperature.COLD, "7") -> LeavingHouse,
      (Temperature.COLD, "8") -> RemovingPJs)

  val ALL_HOT_CLOTHES = ListBuffer(RemovingPJs, Shorts, Shirt, Sunglasses, Sandals)
  val ALL_COLD_CLOTHES = ListBuffer(RemovingPJs, Pants, Socks, Shirt, Hat, Jacket, Boots)

  def apply(temperature: Temperature.Value, command: String): Clothing = DRESSER(temperature, command)

  object Shirt extends Clothing {override def toString: String = "shirt"}
  object Shorts extends Clothing {override def toString: String = "shorts"}
  object Socks extends Clothing {override def toString: String = "socks"}
  object Pants extends Clothing {override def toString: String = "pants"}

  object Fail extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = true
    override def toString: String = "fail"
  }

  object RemovingPJs extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // Pajama must be taken off before anything else can be put on
      clothings.nonEmpty
    }
    override def toString: String = "Removing PJs"
  }

  object Sandals extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // pants must be put on before footwear
      super.isNotValid(temperature, clothings) || !clothings.contains(Shorts)
    }
    override def toString: String = "sandals"
  }

  object Sunglasses extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // shirt must be put on before headwear
      super.isNotValid(temperature, clothings) || !clothings.contains(Shirt)
    }
    override def toString: String = "sunglasses"
  }

  object Boots extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // socks must be put on before footwear
      // pants must be put on before footwear
      super.isNotValid(temperature, clothings) || !clothings.contains(Socks) || !clothings.contains(Pants)
    }
    override def toString: String = "boots"
  }

  object Hat extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // shirt must be put on before headwear
      super.isNotValid(temperature, clothings) || !clothings.contains(Shirt)
    }
    override def toString: String = "hat"
  }

  object Jacket extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // shirt must be put on before jacket
      super.isNotValid(temperature, clothings) || !clothings.contains(Shirt)
    }
    override def toString: String = "jacket"
  }

  object LeavingHouse extends Clothing {
    override def isNotValid(temperature: Temperature.Value, clothings: ListBuffer[Clothing]): Boolean = {
      // Wear all clothing before leaving house
      // NOTE: could not find great alternative for containsAll
      temperature match {
        case Temperature.HOT => !ALL_HOT_CLOTHES.map(clothings.contains(_)).reduce(_ && _)
        case Temperature.COLD => !ALL_COLD_CLOTHES.map(clothings.contains(_)).reduce(_ && _)
      }
    }
    override def toString: String = "leaving house"
  }
}