项目目录结构说明
com.paulzhang.demo
    controller
    dao                  ---数据访问层，与底层 MySQL、Oracle、Hbase 等进行数据交互。
        oracle
            DO          --该目录只能自动生成与数据库保持一致
            mapper
                auto    --该目录只能自动生成新增和替换，不可以修改
                ex      --该目录进行扩展mybatis生成的mapper或者provider文件(例如UserMapperEx，UserSqlProvider)
    manager              ---1） 对第三方平台封装的层，预处理返回结果及转化异常信息；
                         ---2） 对 Service 层通用能力的下沉，如缓存方案、中间件通用处理；
                         ---3） 与 DAO 层交互，对多个 DAO 的组合复用。
    rpc                  ---所有暴露的服务service接口，及其依赖Dto,exception(此目录直接打包暴露)
        enum             ---
        dto              ---
        constant         ---
        api              ---暴露门面service
        impl             ---
    service              ---
        rpcimpl          ---暴露rpc的实现，对rpc返回的组装
        impl             ---上一级目录中所有service接口的实现
        *.Service.java(I)
    constant
        ConfigConsts.java
        RedisPrefixKeyConsts.java
    enum
    event                ---spring事件
        register         ---业务名称(例如注册)
            RegisterListener.java   监听者
            RegisterEvent.java      事件对象
    mq                   ---mq
        invest           ---业务名称(例如投资)
            InvestProducer.java  生产者
            InvestConsumer.java  消费者
            InvestMq.java        mq传输对象
        QueueKeyConsts.java
    lock
        IDistributedLock.java
        RedisLock.java
        ZookeeperLock.java
    spring               ---spring 相关的内容
    *Application.java


    对于mybatis 复杂的sql 使用xml 简单的使用注解，优先级是注解--》xml



    数据库:sql使用小写 id  user_name


生成带有目录的Markdown格式文档:http://blog.csdn.net/uxyheaven/article/details/49253757