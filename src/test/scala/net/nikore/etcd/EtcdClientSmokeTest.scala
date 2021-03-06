package net.nikore.etcd

import scala.concurrent.Future
import net.nikore.etcd.EtcdJsonProtocol.EtcdResponse
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object EtcdClientSmokeTest extends App {
  val client = new EtcdClient("http://localhost:4001")

  val response: Future[EtcdResponse] = client.setKey("test4","com.java.property1=value2\n" +
    "com.java.property3=vale4\n" +
    "com.java.property4=value6\n" +
    "com.java.property5=value10\n" +
    "com.java.property6=value11;value12;value13\n" +
    "com.java.property7=value14&value16&value17\n"
  )

  //  val response: Future[EtcdResponse] = client.setKey("test3","yep")

  response onComplete {
    case Success(response: EtcdResponse) =>
      System.out.println(response)
      client.shutdown()
    case Failure(error) =>
      System.out.println(error)
      client.shutdown()
  }
}
