package tr.edu.medipol.yazilimGelistirme.finalProject;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductWebService {

	public record Product(String ID, String brand, String productName, String price) {}
	
	private static final List<Product> PRODUCT_LIST = new ArrayList<>();
	static {
		PRODUCT_LIST.add(new Product("1", "LEGO","Batman Batmobile Set", "990TL"));
		PRODUCT_LIST.add(new Product("2" ,"Apple","Lightning Charger ", "470TL"));
		PRODUCT_LIST.add(new Product("3" ,"Kahve Dunyasi","Filter Coffee ", "290TL"));
		PRODUCT_LIST.add(new Product("4" ,"Tupperware","canteen", "470TL"));
	}
	
	@GetMapping("/")
	public List<Product> listing()
	{
		return PRODUCT_LIST;
	}
	
	@PostMapping("/")
	public Product add(@RequestBody Product product) {
	    if (product == null) {
	        return new Product("0", "Error", "Invalid Product", "0TL");
	    }
	    PRODUCT_LIST.add(product);
	    return product;
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable String id)
	{
		for(Product product: PRODUCT_LIST) 
		{
			if(product.ID().equals(id)) 
			{
				PRODUCT_LIST.remove(product);
				return true;
			}
		}
		return false;
	}
}