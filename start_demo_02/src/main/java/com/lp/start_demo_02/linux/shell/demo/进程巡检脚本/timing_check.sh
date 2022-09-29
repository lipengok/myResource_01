while true
do
  ps -ef | grep "utils_demo-0.0.1-SNAPSHOT.jar" | grep -v grep
	#如果进程搜索不出来，则$?的值为1，否则值为0
	#当$?值不等于0的时候，重新启动进程
	if [ $? -ne 0 ]
	then
	  echo "utils_demo-0.0.1-SNAPSHOT.jar is starting...."
	  cd "/lp/resource/jar/java_base" && "java -jar utils_demo-0.0.1-SNAPSHOT.jar"
	else
	  echo "utils_demo-0.0.1-SNAPSHOT.jar is running...."
	fi

	# 等待1分钟
	sleep 60 
done
