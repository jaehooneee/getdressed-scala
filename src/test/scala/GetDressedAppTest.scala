import org.junit.Assert._
import org.junit._

@Test
class GetDressedAppTest {

  @Test
  def testHotSuccess(): Unit = {
    val args = Array[String] ("HOT", "8,", "6,", "4,", "2," ,"1,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("Removing PJs, shorts, shirt, sunglasses, sandals, leaving house", response)
  }

  @Test
  def testColdSuccess(): Unit = {
    val args = Array[String] ("COLD", "8,", "6,", "3,", "4,", "2,", "5,", "1,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house", response)
  }

  @Test
  def testHotDuplicateClothing(): Unit = {
    val args = Array[String] ("HOT", "8,", "6,", "6,")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testHotSocks(): Unit = {
    val args = Array[String] ("HOT", "8,", "6,", "3,")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testHotMissingCloth(): Unit = {
    val args = Array[String] ("HOT", "8,", "6,", "4,", "2," , "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testHotShortsMustBeOnBeforeSandals(): Unit = {
    val args = Array[String] ("HOT", "8,", "1,", "4,", "2," ,"6,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testHotShirtMustBeOnBeforeSunglasses(): Unit = {
    val args = Array[String] ("HOT", "8,", "6,", "2," ,"1,", "4,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testColdMissingCloth(): Unit = {
    val args = Array[String] ("COLD", "8,", "6,", "3,", "4,", "2,", "5,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testColdSocksMustBeOnBeforeBoots(): Unit = {
    val args = Array[String] ("COLD", "8,", "6,", "1,", "4,", "2,", "5,", "2,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testColdPantsMustBeOnBeforeBoots(): Unit = {
    val args = Array[String] ("COLD", "8,", "3,", "4,", "2,", "5,", "1,", "6,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testColdShirtMustBeOnBeforeHat(): Unit = {
    val args = Array[String] ("COLD", "8,", "6,", "3,", "2,", "4,", "5,", "1,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testColdShirtMustBeOnBeforeJacket(): Unit = {
    val args = Array[String] ("COLD", "8,", "6,", "3,", "5,", "2,", "4,", "1,", "7")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

  @Test
  def testColdPajamaStillOn(): Unit = {
    val args = Array[String] ("COLD", "6")
    val response = GetDressedApp.getDressed(args)
    assertEquals("fail", response)
  }

}


