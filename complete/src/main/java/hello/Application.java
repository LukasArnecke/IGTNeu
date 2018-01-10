package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private static final String url = "http://localhost:420";

	private static final String urlCustomer = "http://localhost:420/customer";

	private static final String urlProduct = "http://localhost:420/product";

	private static final String urlWarehouse = "http://localhost:420/warehouse";

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		/*return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
		*/

		Customer hugo = new Customer("Hugo", "Edingen", new Date());


		return args -> {

		    //Product




		    //Customer
            //Create Customer
            Response response1 = restTemplate.postForObject(urlCustomer, hugo, Response.class);
            log.info(response1.toString());
            //Read Customer
            //Ab hier url = url + cId
            Customer hugoback = restTemplate.getForObject(urlCustomer, Customer.class);
            log.info(hugoback.toString());
            //Update Customer
            hugoback.setDistrict("Neuschwanstein");
            restTemplate.put(urlCustomer, hugoback);
            Customer hugobackback = restTemplate.getForObject(urlCustomer, Customer.class);
            log.info(hugobackback.toString());
            //Delete Customer, sollte erst am Ende kommen
            restTemplate.delete(urlCustomer);


            //Warehouse

            //TODO: Selbe mit den anderen Klassen
		};


	}
}