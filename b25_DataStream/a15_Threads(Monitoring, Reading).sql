

  # Streaming app reading process constitute 2 threads

    + Monitoring Thread
    + Reading Thread

  # Monitoring Thread

    + Scan Path
    + Divide into splits
    + Assign splits to readers

  # Reading Thread

    + Performed by multiple readers
    + Each split read by one reader
