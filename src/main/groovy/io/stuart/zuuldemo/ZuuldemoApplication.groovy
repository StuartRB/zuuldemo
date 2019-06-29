package io.stuart.zuuldemo

import io.stuart.zuuldemo.filters.RequestUuidHeaderFilter
import io.stuart.zuuldemo.filters.GatewayViaHeaderFilter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean

@EnableZuulProxy
@SpringBootApplication
class ZuuldemoApplication {

	static void main(String[] args) {
		SpringApplication.run(ZuuldemoApplication, args)
	}

    @Bean
    GatewayViaHeaderFilter getZuulHeaderFilter(){
        return new GatewayViaHeaderFilter()
    }

    @Bean
    RequestUuidHeaderFilter guidFilter(){
        return new RequestUuidHeaderFilter()
    }
}
