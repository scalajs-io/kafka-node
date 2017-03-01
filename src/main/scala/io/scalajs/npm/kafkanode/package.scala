package io.scalajs.npm

import io.scalajs.nodejs.Error
import io.scalajs.util.PromiseHelper.promiseWithError1

import scala.concurrent.Promise
import scala.scalajs.js

/**
  * kafkanode package object
  * @author lawrence.daniels@gmail.com
  */
package object kafkanode {

  /**
    * Client Extensions
    * @param client the given [[Client client]]
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * @see [[Client.close()]]
      */
    @inline
    def closeAsync(): Promise[js.Any] = promiseWithError1[Error, js.Any](client.close)

  }

  /**
    * Consumer Extensions
    * @param consumer the given [[Consumer consumer]]
    */
  implicit class ConsumerExtensions(val consumer: Consumer) extends AnyVal {

    /**
      * @see [[Consumer.addTopics()]]
      */
    @inline
    def addTopicsAsync(topics: String, fromOffset: Boolean): Promise[js.Any] =
    promiseWithError1[Error, js.Any](consumer.addTopics(topics, _, fromOffset))

    /**
      * @see [[Consumer.addTopics()]]
      */
    @inline
    def addTopicsAsync(topics: String): Promise[js.Any] = promiseWithError1[Error, js.Any](consumer.addTopics(topics, _))

    /**
      * @see [[Consumer.close()]]
      */
    @inline
    def closeAsync: Promise[js.Any] = promiseWithError1[Error, js.Any](consumer.close)

    /**
      * @see [[Consumer.commit()]]
      */
    @inline
    def commitAsync[T <: js.Any]: Promise[T] = promiseWithError1[Error, T](consumer.commit)

    /**
      * @see [[Consumer.removeTopics()]]
      */
    @inline
    def removeTopicsAsync(topics: js.Array[String]): Promise[Boolean] =
    promiseWithError1[Error, Boolean](consumer.removeTopics(topics, _))

    /**
      * @see [[Consumer.on()]]
      */
    @inline
    def onError(callback: js.Function): consumer.type = consumer.on("error", callback)

    /**
      * @see [[Consumer.on()]]
      */
    @inline
    def onMessage(callback: js.Function): consumer.type = consumer.on("message", callback)

    /**
      * @example on('offsetOutOfRange', function (err) {})
      * @see [[Consumer.on()]]
      */
    @inline
    def onOffsetOutOfRange(callback: js.Function): consumer.type = consumer.on("offsetOutOfRange", callback)

  }

  /**
    * High Level Consumer Extensions
    * @param consumer the given [[HighLevelConsumer consumer]]
    */
  implicit class HighLevelConsumerExtensions(val consumer: HighLevelConsumer) extends AnyVal {

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    @inline
    def addTopicsAsync(topics: String, fromOffset: Boolean): Promise[js.Any] =
    promiseWithError1[Error, js.Any](consumer.addTopics(topics, _, fromOffset))

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    @inline
    def addTopicsAsync(topics: String): Promise[js.Any] =
    promiseWithError1[Error, js.Any](consumer.addTopics(topics, _))

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    @inline
    def closeAsync: Promise[js.Any] = promiseWithError1[Error, js.Any](consumer.close)

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    @inline
    def closeAsync(force: Boolean): Promise[js.Any] =
    promiseWithError1[Error, js.Any](consumer.close(force, _))

    /**
      * @see [[HighLevelConsumer.commit()]]
      */
    @inline
    def commitAsync[T <: js.Any]: Promise[T] = promiseWithError1[Error, T](consumer.commit)

    /**
      * @see [[HighLevelConsumer.removeTopics()]]
      */
    @inline
    def removeTopicsAsync(topics: js.Array[String]): Promise[Boolean] =
    promiseWithError1[Error, Boolean](consumer.removeTopics(topics, _))

    /**
      * @example consumer.on('error', function (message) {})
      * @see [[HighLevelConsumer.on()]]
      */
    @inline
    def onError(callback: js.Function): consumer.type = consumer.on("error", callback)

    /**
      * @example consumer.on('message', function (message) {})
      * @see [[HighLevelConsumer.on()]]
      */
    @inline
    def onMessage(callback: js.Function): consumer.type = consumer.on("message", callback)

    /**
      * @example on('offsetOutOfRange', function (err) {})
      * @see [[HighLevelConsumer.on()]]
      */
    @inline
    def onOffsetOutOfRange(callback: js.Function): consumer.type = consumer.on("offsetOutOfRange", callback)

  }

  /**
    * High Level Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class HighLevelProducerExtensions(val producer: HighLevelProducer) extends AnyVal {

    /**
      * @see [[HighLevelProducer.createTopics()]]
      */
    @inline
    def createTopicsAsync(topics: js.Array[String], async: Boolean): Promise[js.Any] =
    promiseWithError1[Error, js.Any](producer.createTopics(topics, async, _))

    /**
      * @see [[HighLevelProducer.send()]]
      */
    @inline
    def sendAsync(payloads: js.Array[Payload]): Promise[js.Any] = promiseWithError1[Error, js.Any](producer.send(payloads, _))

    /**
      * @see [[HighLevelProducer.on()]]
      */
    @inline
    def onError(callback: js.Function): producer.type = producer.on("error", callback)

    /**
      * @see [[HighLevelProducer.on()]]
      */
    @inline
    def onReady(callback: js.Function): producer.type = producer.on("ready", callback)

  }

  /**
    * Offset Extensions
    * @param offset the given [[Offset offset]]
    */
  implicit class OffsetExtensions(val offset: Offset) extends AnyVal {

    /**
      * @see [[Offset.commit()]]
      */
    @inline
    def commitAsync(groupId: String, payloads: js.Array[Payload]): Promise[js.Any] =
    promiseWithError1[Error, js.Any](offset.commit(groupId, payloads, _))

    /**
      * @see [[Offset.fetch()]]
      */
    @inline
    def fetchAsync[T](payloads: js.Array[Payload]): Promise[T] = {
      promiseWithError1[Error, T](offset.fetch(payloads, _))
    }

    /**
      * @see [[Offset.fetchCommits()]]
      */
    @inline
    def fetchCommitsAsync(groupId: String, payloads: js.Array[Payload]): Promise[js.Any] =
    promiseWithError1[Error, js.Any](offset.fetchCommits(groupId, payloads, _))

  }

  /**
    * Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class ProducerExtensions(val producer: Producer) extends AnyVal {

    /**
      * @see [[Producer.on()]]
      */
    @inline
    def onError(callback: js.Function): producer.type = producer.on("error", callback)

    /**
      * @see [[Producer.on()]]
      */
    @inline
    def onReady(callback: js.Function): producer.type = producer.on("ready", callback)

    /**
      * @see [[Producer.createTopics()]]
      */
    @inline
    def createTopicsFuture(topics: js.Array[String], async: Boolean): Promise[js.Any] = {
      promiseWithError1[Error, js.Any](producer.createTopics(topics, async, _))
    }

    /**
      * @see [[Producer.send()]]
      */
    @inline
    def sendFuture(payloads: js.Array[Payload]): Promise[js.Any] = {
      promiseWithError1[Error, js.Any](producer.send(payloads, _))
    }

  }

}
