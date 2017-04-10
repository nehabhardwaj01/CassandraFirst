
object MainValues extends App {

  val userValues = new QueryMethods
  userValues.userByEmail("neha.bhardwaj@knoldus.in")
  userValues.videoByName("myVideo")
  userValues.videoByYear()
  userValues.videoById(2)
}
