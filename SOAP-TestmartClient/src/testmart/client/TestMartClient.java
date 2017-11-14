package testmart.client;

import java.util.ArrayList;
import java.util.List;

import testmart.business.ProductCatalog;
import testmart.business.ProductCatalogImplService;
import testmart.webservice.ShopInfo;
import testmart.webservice.ShopInfoService;

// use wsimport to create the Service End-point Interface
// -keep keeps the generated java files
// -s src stores the generated java files in the src sub-directory
// copy the generated java files into the net.webservicex package
// wsimport -keep -s src http://www.webservicex.net/geoipservice.asmx?WSDL

public class TestMartClient {	
	
	public static void main(String[] args) {
		// Create the service object
		ShopInfoService shopInfoService = new ShopInfoService();
		
		// Create service port stub that gives us access to the service methods
		ShopInfo shopInfo = shopInfoService.getShopInfoPort();
		
		System.out.println(shopInfo.getShopInfo("shopName"));
		System.out.println(shopInfo.getShopInfo("since"));
		
		// Create the service object
		ProductCatalogImplService productCatalogService = new ProductCatalogImplService();
		
		// Create service port stub that gives us access to the service methods
		ProductCatalog productCatalog = productCatalogService.getProductCatalogImplPort();
		
		List<String> movieList = new ArrayList<>();
		movieList = productCatalog.getProducts("movies");
		
		for(String movie : movieList){
			System.out.println("movie: " + movie);
		}
		
		
		

	}

}
