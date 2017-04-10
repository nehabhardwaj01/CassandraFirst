
import com.datastax.driver.core.{ResultSet, Cluster}

class QueryMethods {

  val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()

  val session = cluster.connect("assignment")

  /**
    * Selects user by given email
    *
    * @param email email id of the user
    */
  def userByEmail(email: String) = {

    val result = session.execute(s"SELECT * from user where email = '$email';")
    println("Selecting user by email : ")
    printValues(result)
  }

  /**
    * Selects video by the given video_name
    *
    * @param name name of the video to be selected
    */
  def videoByName(name: String) = {

    val result = session.execute(s"SELECT * FROM video WHERE video_name = '$name';")
    println("Selecting video by video_name : ")
    printValues(result)
  }

  /**
    * Selects videos that were uploaded after year 2017
    */
  def videoByYear() = {

    val result = session.execute("SELECT * FROM videobyyear WHERE year > 2015 ALLOW FILTERING ;")
    println("Selecting videos uploaded after 2015 : ")
    printValues(result)
  }

  /**
    * Selects video by user_id and records are selected in descending order by year
    *
    * @param userid
    */
  def videoById(userid: Int) = {

    val result = session.execute(s"SELECT * FROM videobyyear WHERE userid = $userid ORDER BY year DESC ;")
    println("Selecting videos by user_id : ")
    printValues(result)
  }

  def printValues(result : ResultSet): Unit = {
    val iterate = result.iterator()
    while (iterate.hasNext) {
      println(iterate.next())
    }
  }
}
