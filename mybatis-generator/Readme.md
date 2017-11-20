#mybatis自动生成代码(oracle)
##使用说明:
1. 编辑resources目录下的配置generatorConfig.xml
2. 执行com.paulzhangcc.mybatis.StartUp.main

##配置注意事项：
1. sqlMapGenerator javaClientGenerator javaModelGenerator 中targetProject指定到项目目录或者自定目录
2. table中配置所有的Demo切换成你自己的表名
3. 选择是否需要table中generatedKey(插入语句使用SEQUENCE自动生成自增id)
4. 对于数据中所有是数字类型的列设置为NUMBER类型(不要使用Integer，Long代码生成会有问题)</br>

**number类型不同长度自动生成代码装换:**</br>
scale>0或length>18：使用BigDecimal;</br>
scale=0;length[10,18]：使用Long；</br>
scale=0;length[5,9]：使用Integer；</br>
scale=0;length<5：使用Short；</br>


    