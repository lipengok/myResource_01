# 程序名
name="utils_demo-0.0.1-SNAPSHOT.jar"
# 进程号
str=`ps aux | grep $name | grep -v grep | awk '{print $2}'`

if [ "$str" -gt 0 ]; then
    echo "running....."
    echo "pid:$str"

else
    nohup java -jar $name &
fi
