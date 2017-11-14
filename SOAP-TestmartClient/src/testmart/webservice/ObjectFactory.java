
package testmart.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the testmart.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProducts_QNAME = new QName("http://webservice.testmart/", "getProducts");
    private final static QName _GetProductsResponse_QNAME = new QName("http://webservice.testmart/", "getProductsResponse");
    private final static QName _GetProductsV2_QNAME = new QName("http://webservice.testmart/", "getProductsV2");
    private final static QName _AddProductResponse_QNAME = new QName("http://webservice.testmart/", "addProductResponse");
    private final static QName _AddProduct_QNAME = new QName("http://webservice.testmart/", "addProduct");
    private final static QName _FetchCatagories_QNAME = new QName("http://webservice.testmart/", "fetchCatagories");
    private final static QName _FetchCatagoriesResponse_QNAME = new QName("http://webservice.testmart/", "fetchCatagoriesResponse");
    private final static QName _GetProductsV2Response_QNAME = new QName("http://webservice.testmart/", "getProductsV2Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: testmart.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductsV2Response }
     * 
     */
    public GetProductsV2Response createGetProductsV2Response() {
        return new GetProductsV2Response();
    }

    /**
     * Create an instance of {@link FetchCatagoriesResponse }
     * 
     */
    public FetchCatagoriesResponse createFetchCatagoriesResponse() {
        return new FetchCatagoriesResponse();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link FetchCatagories }
     * 
     */
    public FetchCatagories createFetchCatagories() {
        return new FetchCatagories();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link GetProductsV2 }
     * 
     */
    public GetProductsV2 createGetProductsV2() {
        return new GetProductsV2();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "getProducts")
    public JAXBElement<GetProducts> createGetProducts(GetProducts value) {
        return new JAXBElement<GetProducts>(_GetProducts_QNAME, GetProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "getProductsResponse")
    public JAXBElement<GetProductsResponse> createGetProductsResponse(GetProductsResponse value) {
        return new JAXBElement<GetProductsResponse>(_GetProductsResponse_QNAME, GetProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsV2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "getProductsV2")
    public JAXBElement<GetProductsV2> createGetProductsV2(GetProductsV2 value) {
        return new JAXBElement<GetProductsV2>(_GetProductsV2_QNAME, GetProductsV2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchCatagories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "fetchCatagories")
    public JAXBElement<FetchCatagories> createFetchCatagories(FetchCatagories value) {
        return new JAXBElement<FetchCatagories>(_FetchCatagories_QNAME, FetchCatagories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchCatagoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "fetchCatagoriesResponse")
    public JAXBElement<FetchCatagoriesResponse> createFetchCatagoriesResponse(FetchCatagoriesResponse value) {
        return new JAXBElement<FetchCatagoriesResponse>(_FetchCatagoriesResponse_QNAME, FetchCatagoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsV2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.testmart/", name = "getProductsV2Response")
    public JAXBElement<GetProductsV2Response> createGetProductsV2Response(GetProductsV2Response value) {
        return new JAXBElement<GetProductsV2Response>(_GetProductsV2Response_QNAME, GetProductsV2Response.class, null, value);
    }

}
