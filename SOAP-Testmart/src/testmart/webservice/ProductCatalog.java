package testmart.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import testmart.model.Product;

//Annotation to create the web service.  Must be included within a package.
//WSDL file is auto generated after every compile.
//To see WSDL, go to the glassfish admin page: http://localhost:4848
//Click on Applications tab and click on the view endpoint link
//Annotation parameters:
//name:  			Overrides the portType name in the WSDL
//portName: 		Overrides the port name in the WSDL
//serviceNmae: 	Overrides the service name in the WSDL
//targetNamespace: Overrides the targetNamespace in the WSDS (like a package in Java)
//@WebService(name="TestMartCatalog", portName="TestMartCatalogPort", serviceName="TestMartCatalogService",
//				targetNamespace="http://www.testmart.com")

@WebService
public interface ProductCatalog {

	// Annotation to expose the method to the web service
	// Annotation parameters:
	// exclude: 		(true/false) value to expose the method to the web service
	// action:			Overrides the soapAction in the WSDL
	// operationName: 	Overrides the operation name in the WDSL
	//@WebMethod(action="fetch_catagories", operationName="fetchCatagories")
	@WebMethod
	public List<String> getProductCatagories();
	
	@WebMethod
	public List<String> getProducts(String catagory);
	
	@WebMethod
	public List<Product> getProductsV2(String catagory);
	
	@WebMethod
	public boolean addProduct(String catagory, String product);
}
