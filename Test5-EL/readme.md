如果我们想通过@value获取spring容器中的值（包括bean和bean的属性值），我们可以通过@value("#{bean名称}")或者@value("#{bean名称.属性名}",该属性要有setter方法)

如果我们想通过@value获取xx.properties配置文件中的某个key-value对的值，可以通过@value("${key}")获取其中的value值的信息，