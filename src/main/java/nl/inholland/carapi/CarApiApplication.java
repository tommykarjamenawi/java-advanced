package nl.inholland.carapi;

import nl.inholland.carapi.model.Car;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CarApiApplication.class, args);
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Bean
	@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
	public List<Car> cars() {
		// returns list of cars
		return new ArrayList<>((List.of(
				new Car(1, "Ferrari", "F40", 200000, 1988),
				new Car(2, "Tesla", "S", 70000, 2019),
				new Car(3, "Volvo", "V-50", 20000, 1988),
				new Car(4, "Toyota", "Andrada", 15000, 2020),
				new Car(5, "Honda", "H37", 25000, 2007)
		)));
	}

}
