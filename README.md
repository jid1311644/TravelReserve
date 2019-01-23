# TravelReserve
USTC radb experiment.

TravelReserve是一个旅游订票系统，包括预订机票、预订旅馆、预订接机服务。
TravelReserve需要在配置有jdk1.8.0_112以上版本JDK的Eclipse中打开运行。
TravelReserve使用MySQL实现数据的持久化存储。

由于使用本地数据库，所以运行前需要配置自己的MySQL。
在MySQL中新建数据库radb_reserve，执行radb_reserve_sql文件夹下的sql文件。

使用Eclipse打开TravelReserve工程，将lib文件下的jdbc包加入库中。
打开TravelReserve工程下src.controller.db.dao.BaseDAO文件，更改构造函数BaseDAO()中变量url、userName、userPassword，链接到自己MySQL中刚刚建立的数据库radb_reserve。

使用Eclipse以Java工程运行TravelReserve，主函数入口在src.start.Start中。
测试用例用户名为“user1”，密码为“userpsw”，可以自己注册用户进行测试。
