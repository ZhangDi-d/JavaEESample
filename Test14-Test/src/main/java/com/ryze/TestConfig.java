package com.ryze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by xueLai on 2019/4/8.
 */
@Configuration
public class TestConfig {

    /**
     * @profile 注解是spring提供的一个用来标明当前运行环境的注解。我们正常开发的过程中经常遇到的问题是，开发环境是一套环境，qa测试是一套环境，线上部署又是一套环境。这样从开发到测试再到部署，会对程序中的配置修改多次，尤其是从qa到上线这个环节，让qa的也不敢保证改了哪个配置之后能不能在线上运行。
     * 为了解决上面的问题，我们一般会使用一种方法，就是配置文件，然后通过不同的环境读取不同的配置文件，从而在不同的场景中跑我们的程序
     */
    /**
     * @Qualifier 可能会有这样一种情况，当你创建多个具有相同类型的 bean 时，并且想要用一个属性只为它们其中的一个进行装配，在这种情况下，你可以使用 @Qualifier 注释和 @Autowired 注释通过指定哪一个真正的 bean 将会被装配来消除混乱。
     */

    @Bean
    @Profile("dev")
    public  TestBean devTestBean(){
        return new TestBean("dev-testBean");
    }

    @Bean
    @Profile("prod")
    public  TestBean prodTestBean(){
        return new TestBean("prod-testBean");
    }
}
