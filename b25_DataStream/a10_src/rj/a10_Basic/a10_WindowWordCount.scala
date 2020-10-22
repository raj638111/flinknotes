package rj.a10_Basic

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.api.scala.createTypeInformation

object a10_WindowWordCount {
  def main(args: Array[String]) {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text = env.socketTextStream("127.0.0.1", 9999)
    val counts = text
      .flatMap {
        _.toLowerCase.split("\\W+") filter (_.nonEmpty)
      }
      .map ((_, 1))
      .keyBy(_._1)
      .timeWindow(Time.seconds(5))
      .sum(1)
    counts.print()
    env.execute("Window Stream WordCount")
  }
}

/*

Pre-requisite: Start netcat ; nc in port 9999
ie
  nc -lk 9999   (or)
  nc -l -p 9999

flink run -c rj.a10_Basic.a10_WindowWordCount \
./b25_DataStream/target/scala-2.12/b25_DataStream-assembly-0.1.0-SNAPSHOT.jar

*/