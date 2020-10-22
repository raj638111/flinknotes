package rj.a10_basic

import a10_logger.CustomLogger
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.api.scala.{ExecutionEnvironment, createTypeInformation}

object a10_WordCount {

  val log = CustomLogger.getLogger(this.getClass.getName.dropRight(1))

  def main(args: Array[String]): Unit = {

    log.info("Starting...")

    // Returns Local environment when the app runs in IDE or
    //  remote environment when the app is executed in the cluster
    //  (Similar to SparkContext I believe)
    // NOTE: For datastream, we would be using `StreamExecutionEnvironment`
    //  instead of ExecutionEnvironment which is used for dataset
    val env = ExecutionEnvironment.getExecutionEnvironment

    // Use this tool to get arguments from user (Although we are not using this variable
    //  in this project
    // Can also be used to read configuration from .properties file & system properties also
    val params = ParameterTool.fromArgs(args)

    // Ensure the parameter is available in each & every node of the cluster
    //  where the program is going to run
    env.getConfig.setGlobalJobParameters(params)

    val text = env.fromElements(
      "Who's there?",
      "I think I hear them. Stand, ho! Who's there?")
    val counts = text
      .flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
      .map { (_, 1) }
      .groupBy(0)
      .sum(1)

    // Execution is triggered by calling any of these methods,
    //  execute(), count(), collect(), or print()
    counts.collect().foreach { x => log.info(x) }
    // env.execute("WordCount Example")

  }
}

/*

flink run -c rj.a10_dataset.a10_WordCount ./a15_Code/target/scala-2.12/a15_Code-assembly-0.1.0-SNAPSHOT.jar

 */
