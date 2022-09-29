# 程序名
name="timing_check.sh"
# 进程号
str=`ps aux | grep $name | grep -v grep | awk '{print $2}'`
if [ $str -gt 0 ]; then
    echo $str
    kill -9 $str
    if [ "$?" -eq 0 ]; then
        echo "kill success"
    else
        echo "kill failed"
    fi
else
    echo "程序未启动"
fi