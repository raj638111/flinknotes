package a10_logger

import org.apache.log4j._

/*
 * How to get this logger?
 * 	CustomLogger.getLogger(<category>)
 * 	Ex: CustomLogger.getLogger(this.getClass.getName.dropRight(1))
 *
 * loglevel: Log level for com.homeaway* packages
 * Example: --conf "spark.driver.extraJavaOptions=-Dloglevel=debug"
 * The accepted values are debug/info
 * When not specified, default loglevel is `debug`
 *
 */
object CustomLogger {

  val mPattern = "%d{yy/MM/dd HH:mm:ss} | %p | %c | %M() | %L | %m%n"

  Logger.getRootLogger.removeAllAppenders()
  setLogger(Logger.getRootLogger, Level.DEBUG, Level.INFO)

  val logLevel = System.getProperty("loglevel") match {
    case "debug" => Level.DEBUG
    case "info" => Level.INFO
    case _ => Level.INFO
  }
  setLogger(Logger.getLogger("rj"), Level.DEBUG, logLevel)

  def setLogger(logger: Logger, logLevel: Level, thresholdLevel: Level): Unit = {
    println("Setting Root Logger...") //scalastyle:ignore
    logger.setLevel(logLevel)
    logger.setAdditivity(false)
    setConsoleAppender(logger, thresholdLevel)
  }

  def getLogger(category: String): Logger = {
    Logger.getLogger(category)
  }

  def setConsoleAppender(logger: Logger, thresholdLevel: Level): Unit = {
    val console = new ConsoleAppender(); //create appender
    console.setLayout(new PatternLayout(mPattern));
    console.setThreshold(thresholdLevel);
    console.activateOptions();
    logger.addAppender(console)
  }

}
