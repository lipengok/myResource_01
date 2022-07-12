# git
解决fatal: unable to access ‘https://github.com/xxx/xxx.git/‘: Failed to connect to github.com port 4
总而言之连接远程仓库失败
方案：
启动git控制台，输入命令关闭代理
git config --global --unset https.proxy
git config --global --unset http.proxy


