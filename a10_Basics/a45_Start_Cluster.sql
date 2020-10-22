
-- Start cluster

/Users/raj/flink/bin$ start-cluster.sh
Starting cluster.
Starting standalonesession daemon on host Rajkumars-MacBook-Pro.local.
Starting taskexecutor daemon on host Rajkumars-MacBook-Pro.local.

-- Verify Java Processes

/Users/raj/flink/bin$ jps
3107 Jps
3079 TaskManagerRunner
2828 StandaloneSessionClusterEntrypoint
557

-- Check in Web App

  + http://localhost:8081