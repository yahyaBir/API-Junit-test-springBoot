package tr.edu.medipol.yazilimGelistirme.finalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductWebServiceTest {

    @Test
    void testListProductsSize() {

        int expectedSize = 4;
        ProductWebService productService = new ProductWebService();
        int actualSize = productService.listing().size();
        assertEquals(expectedSize, actualSize, "product does not match on product.");
    }
    
    @Test
    void testDeleteProduct() 
    {
        String productIDToDelete = "1";   
        ProductWebService productService = new ProductWebService();    
        boolean isDeleted = productService.delete(productIDToDelete); 
        assertTrue(isDeleted, "product could not be deleted");
        boolean isProductStillInList = productService.listing()
                .stream()
                .anyMatch(product -> product.ID().equals(productIDToDelete));
        assertFalse(isProductStillInList, "the deleted product is still on the list");
    }
    @Test
    void testAddProduct() {
        ProductWebService.Product newProduct = new ProductWebService.Product("5", "Samsung", "Smartphone", "1500TL");
        ProductWebService productService = new ProductWebService();
        ProductWebService.Product addedProduct = productService.add(newProduct);
        assertEquals(newProduct, addedProduct, "product could not be added.");
        assertTrue(productService.listing().contains(newProduct), "product not found in the list");
    }
}


