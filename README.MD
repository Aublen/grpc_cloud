## 环境要求
idea需安装插件，搜索protobuf安装

## 测试步骤
1.service_api项目执行mvn compile

2.启动eureka_server

3.启动service

4.启动application

5.get方式请求 http://127.0.0.1:8080/demo/get?id=1