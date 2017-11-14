package testmart.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// SOAPBinding Annotation
// style:	Document-creates a separate schema document for the input and output types in the WSDL 
//			(Schema can be validated)
//
//			RPC-creates the type schema in-line for the input and output types in the WSDL

@WebService
@SOAPBinding(style=Style.RPC)
public class ShopInfo {
	
	// @WebResult Annotation
	// partName: defines the output type name variable in the WSDL
	// @WebParam Annotation
	// partName: defines the input type name variable in the WSDL
	@WebMethod
	@WebResult(partName="lookupResult")
	public String getShopInfo(@WebParam(partName="lookupInput") String property){
		String response = "Invalid property";
		if("shopName".equals(property)){
			response = "Test Mart";
		}
		else if("since".equals(property)){
			response="Since 1962";
		}
		return response;
	}

}
