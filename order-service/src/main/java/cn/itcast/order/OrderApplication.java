package cn.itcast.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入spring容器
     * 作用:使程序能够发送http请求
     * @return
     */
    @Bean
    @LoadBalanced   /*负载均衡:默认轮询*/
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 将负载均衡规则改为随机(针对全体服务)----方法1
     * @return
     */
    /*@Bean
    public IRule randomRule(){
        return new RandomRule();
    }*/
}