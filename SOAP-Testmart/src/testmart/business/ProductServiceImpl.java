package testmart.business;

import java.util.ArrayList;
import java.util.List;

import testmart.model.Product;

public class ProductServiceImpl {
	
	List<String> bookList = new ArrayList<String>();
	List<String> movieList = new ArrayList<String>();
	List<String> musicList = new ArrayList<String>();
	
	public ProductServiceImpl(){
		bookList.add("Inferno");
		bookList.add("Joyland");
		bookList.add("Game of Thrones");
		
		movieList.add("Star Trek");
		movieList.add("Widard of Oz");
		movieList.add("Hitman");
		
		musicList.add("Dave Matthews");
		musicList.add("Perl Jam");
		musicList.add("Joy Wave");
	}
	
	public List<String> getProductCatagories(){
		List<String> catagories = new ArrayList<String>();
		catagories.add("Books");
		catagories.add("Movies");
		catagories.add("Music");
		return catagories;
	}
	
	public List<String> getProducts(String catagory){
		switch(catagory.toLowerCase()){
		case("books"):
			return bookList;
		case("movies"):
			return movieList;
		case("music"):
			return musicList;		
		}
		return null;
	}
	
	public boolean addProduct(String catagory, String product){
		switch(catagory.toLowerCase()){
		case("books"):
			bookList.add(product);
			break;
		case("movies"):
			movieList.add(product);
			break;
		case("music"):
			musicList.add(product);
			break;
		default:
			return false;
		}		
		return true;
	}

	public List<Product> getProductsV2(String catagory) {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Java Book", "1234", 10.99));
		productList.add(new Product("C++ Book", "5534", 10.99));
		return productList;
	}
}
