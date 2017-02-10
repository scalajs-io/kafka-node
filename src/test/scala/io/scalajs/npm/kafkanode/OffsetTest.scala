package io.scalajs.npm.kafkanode

import io.scalajs.JSON
import io.scalajs.nodejs.process
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Offset Tests
  * @author lawrence.daniels@gmail.com
  */
class OffsetTest extends FunSpec {

  describe("Offset") {

    it("can fetch data") {
      process.env.get("ZK_HOST") match {
        case None =>
          info("No Zookeeper host was specified. Set 'ZK_HOST=localhost:2181'")

        case Some(zkConnect) =>
          val client = new Client(zkConnect)
          val offset = new Offset(client)
          val payloads = js.Array(new Payload(topic = "t", partition = 0, time = js.Date.now(), maxNum = 1))
          offset.fetch(payloads, (err, data) => {
            info(s"data: ${JSON.stringify(data)}")
            client.close()
          })
      }
    }

  }

}
