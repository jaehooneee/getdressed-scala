import org.junit.{Assert, Test}

@Test
class ClothingTest {

  @Test
  def testHotPutOnFootwear(): Unit = {
    val response = Clothing(Temperature.HOT,"1")
    Assert.assertTrue("Wrong response! " + response, "sandals".equals(response.toString))
  }

  @Test
  def testHotPutOnHeadwear(): Unit = {
    val response = Clothing(Temperature.HOT, "2")
    Assert.assertTrue("Wrong response! " + response, "sunglasses".equals(response.toString))
  }

  @Test
  def testHotPutOnSocks(): Unit = {
    val response = Clothing(Temperature.HOT, "3")
    Assert.assertTrue("Wrong response! " + response, "fail".equals(response.toString))
  }

  @Test
  def testHotPutOnShirt(): Unit = {
    val response = Clothing(Temperature.HOT, "4")
    Assert.assertTrue("Wrong response! " + response, "shirt".equals(response.toString))
  }

  @Test
  def testHotPutOnJacket(): Unit = {
    val response = Clothing(Temperature.HOT, "5")
    Assert.assertTrue("Wrong response! " + response, "fail".equals(response.toString))
  }

  @Test
  def testHotPutOnPants(): Unit = {
    val response = Clothing(Temperature.HOT, "6")
    Assert.assertTrue("Wrong response! " + response, "shorts".equals(response.toString))
  }

  @Test
  def testHotLeaveHouse(): Unit = {
    val response = Clothing(Temperature.HOT, "7")
    Assert.assertTrue("Wrong response! " + response, "leaving house".equals(response.toString))
  }

  @Test
  def testHotTakeOfPajamas(): Unit = {
    val response = Clothing(Temperature.HOT, "8")
    Assert.assertTrue("Wrong response! " + response, "Removing PJs".equals(response.toString))
  }

  @Test
  def testColdPutOnFootwear(): Unit = {
    val response = Clothing(Temperature.COLD, "1")
    Assert.assertTrue("Wrong response! " + response, "boots".equals(response.toString))
  }

  @Test
  def testColdPutOnHeadwear(): Unit = {
    val response = Clothing(Temperature.COLD, "2")
    Assert.assertTrue("Wrong response! " + response, "hat".equals(response.toString))
  }

  @Test
  def testColdPutOnSocks(): Unit = {
    val response = Clothing(Temperature.COLD, "3")
    Assert.assertTrue("Wrong response! " + response, "socks".equals(response.toString))
  }

  @Test
  def testColdPutOnShirt(): Unit = {
    val response = Clothing(Temperature.COLD, "4")
    Assert.assertTrue("Wrong response! " + response, "shirt".equals(response.toString))
  }

  @Test
  def testColdPutOnJacket(): Unit = {
    val response = Clothing(Temperature.COLD, "5")
    Assert.assertTrue("Wrong response! " + response, "jacket".equals(response.toString))
  }

  @Test
  def testColdPutOnPants(): Unit = {
    val response = Clothing(Temperature.COLD, "6")
    Assert.assertTrue("Wrong response! " + response, "pants".equals(response.toString))
  }

  @Test
  def testColdLeaveHouse(): Unit = {
    val response = Clothing(Temperature.COLD, "7")
    Assert.assertTrue("Wrong response! " + response, "leaving house".equals(response.toString))
  }

  @Test
  def testColdTakeOfPajamas(): Unit = {
    val response = Clothing(Temperature.COLD, "8")
    Assert.assertTrue("Wrong response! " + response, "Removing PJs".equals(response.toString))
  }

}
