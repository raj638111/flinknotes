

-- StreamExecutionEnvironment.  # 15

  + readTextFile(path)
  + readFile(FileInputFormat, path)
  + readFile(FileInputFormat, path, watchType, interval, pathFilter)
  + socketTextStream()
  + addSource()
    - Add source like Kafka, Flume, Twitter etc...

-- readFile(FileInputFormat, path, watchType, interval, pathFilter)

      . watchType:  Will the file be read periodically or once for a checkpoint?
                    Take one of 2 available value
                    ~ FileProcessingMode.PROCESS_CONTINUOUSLY - Read periodically
                    ~ FileProcessingMode.PROCESS_ONCE         - Scan the path once, read the complete data,
                                                                  Creates a check point and exits
                                                                Drawback
                                                                  Suppose the source is aborted in b/w
                                                                  app will process from the last left checkpoint
                                                                  although we might have processed some data
                                                                  from the last left checkpoint before the
                                                                  application crashed
                                                                  (So slow recovery in case of node failure)
      . pathFile: Use this to exclude files


