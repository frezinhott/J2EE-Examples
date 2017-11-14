package testmart.business;

import java.util.List;

import javax.jws.WebService;

import testmart.model.Product;
import testmart.webservice.ProductCatalog;

// WebService Annotation
// endpointInterface:	Specifies the main web service class for the implementation class

@WebService(endpointInterface="testmart.webservice.ProductCatalog")
public class ProductCatalogImpl implements ProductCatalog{
	ProductServiceImpl productService = new ProductServiceImpl();
	

	public List<String> getProductCatagories(){
		return productService.getProductCatagories();
	}
	
	public List<String> getProducts(String catagory){
		return productService.getProducts(catagory);
	}
	
	public List<Product> getProductsV2(String catagory){
		return productService.getProductsV2(catagory);
	}
	
	public boolean addProduct(String catagory, String product){
		return productService.addProduct(catagory, product);
	}
}
