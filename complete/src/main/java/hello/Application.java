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

		Product rasierer = new Product("Rasierer", 23.95);
		Product strick = new Product("Strick", 9.99);
		Product feuerzeug = new Product("Feuerzeug", 2.90);

		Customer hugo = new Customer("Hugo", "Edingen", new Date());

		Warehouse drogenversteck = new Warehouse("Edingen");


		return args -> {

		    //Product
			//Create Product
			Product re = restTemplate.postForObject(urlProduct, strick, Product.class);
			log.info(re.toString());
			//Read Product
			Product reback = restTemplate.getForObject(urlProduct+"/id?"+re.getpId(), Product.class);
			log.info(reback.toString());
			//Update Customer
			reback.setPreis(4.95);
			restTemplate.put(urlProduct, reback);
			Product rebackback = restTemplate.getForObject(urlProduct+"/id?"+reback.getpId(), Product.class);
			log.info(rebackback.toString());



		    //Customer
            //Create Customer
            Customer hugoback = restTemplate.postForObject(urlCustomer, hugo, Customer.class);
            log.info(hugoback.toString());
            //Read Customer
            Customer hugobackback = restTemplate.getForObject(urlCustomer+"/id?"+hugoback.getcId(), Customer.class);
            log.info(hugobackback.toString());
            //Update Customer
			hugobackback.addProduct(strick);
            restTemplate.put(urlCustomer+"/id?"+hugobackback.getcId(), hugobackback);
            Customer hugobackbackback = restTemplate.getForObject(urlCustomer+"/id?", Customer.class);
            log.info(hugobackbackback.toString());
            //Delete Customer, sollte erst am Ende kommen
            restTemplate.delete(urlCustomer);


            //Warehouse


			//delete

			restTemplate.delete(urlCustomer+"/id?"+hugobackback.getcId());
			restTemplate.delete(urlProduct+"/id?"+rebackback.getpId());


			//TODO: Selbe mit den anderen Klassen
		};


	}
}