package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages= {"service", "controller","init","converters"})
@EnableJpaRepositories(basePackages= {"dao"})
@EntityScan(basePackages= {"model"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate template() {
		BasicAuthenticationInterceptor itercep = new BasicAuthenticationInterceptor("admin","admin");
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(itercep);
		return template;
	}

}
