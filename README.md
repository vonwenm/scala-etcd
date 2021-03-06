scala-etcd
==========

A simple scala client library for [etcd]

Uses spray http client to implement everything in a none blocking manner. It implements most of v2 api and returns objects to
represent the json.


```Scala

  val client = new EtcdClient("http://localhost:4001")

  client.setKey("configKey", "configValue")

  val response: Future[EtcdResponse] = client.getKey("configKey")

  response onComplete {
    case Success(response: EtcdResponse) =>
      System.out.println(response)
      client.shutdown()
    case Failure(error) =>
      System.out.println(error)
      client.shutdown()
  }
```

This library is avilable in maven

```XML

<dependency>
	<groupId>net.nikore.etcd</groupId>
	<artifactId>scala-etcd</artifactId>
	<version>0.3</version>
</dependency>
```

you can see here for all versions: http://repo1.maven.org/maven2/net/nikore/etcd/scala-etcd/

[etcd]: http://coreos.com/blog/distributed-configuration-with-etcd/
