### CheckStyle配置

1. 代码formatter 
    - Eclipse:

        > Preferences -> Java -> Code Style -> Formatter -> Import 导入 eclipse-java-google-style.xml
    - IDEA:

        > Preferences -> Editor -> Code Style -> Java -> Scheme右侧的setting按钮 -> import Scheme -> idea code style xml 导入idea-java-google-style.xml

2. 使用命令行检测git命令是否可用，如果不可用请先安装git
	
3. 根据操作系统执行AutoConfig（现提供Mac,win32,win64版本），注：需通过命令行终端进入到当前目录执行
	
4. gitlab服务器配置全局钩子（本地忽略此步骤）

    > 将checkstyle-8.9-all.jar拷贝到 /var/opt/gitlab/checkStyle/ 目录下  

    > 将pre-receive脚本拷贝到 /opt/gitlab/embedded/service/gitlab-shell/hooks/ 目录下
    
