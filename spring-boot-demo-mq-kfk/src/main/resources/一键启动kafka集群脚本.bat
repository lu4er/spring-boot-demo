@echo off
start kafka-server-start.bat ..\..\config\server1.properties
start kafka-server-start.bat ..\..\config\server2.properties
start kafka-server-start.bat ..\..\config\server3.properties