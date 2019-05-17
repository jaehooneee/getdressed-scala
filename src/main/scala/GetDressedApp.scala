import scala.collection.mutable.ListBuffer

/**
  * Get Dressed command-line application
  */
object GetDressedApp extends App {

  println(this.getDressed(args))

  /**
    * GetDressed main logic flow
    *
    * @param args
    * @return
    */
  def getDressed(args: Array[String]): String = {

    try {
      val temperature = Temperature.withName(args(0))
      val commands = args.splitAt(1)._2
      val clothings = ListBuffer[Clothing]()

      commands
        .map(_.replace(",",""))
        .map(command => Clothing(temperature, command))
        .map(clothing => {
          // stop processing if failure is detected
          if (clothing.isNotValid(temperature, clothings)) {throw new Exception("Failure Detected")}
          clothings += clothing
          clothing.toString
        })
        .reduce(_ + ", " + _)
    }
    catch { case _: Throwable =>
      // added "," delimiter if already wearing something
      "fail"
    }
  }
}