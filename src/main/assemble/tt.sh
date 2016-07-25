cs=`echo /ROOT/tmp/z_check_hbase/lib/*jar | sed 's/ /:/g'`
#配置文件的目录
conf="$cdir/conf:"
#追加进入cp中
cs=$cs$conf
#打印
echo $cs
#执行
nohup java -cp  $cs  com.tools.HbaseDaoImpl   &>/dev/null  &   echo $! >pid&
