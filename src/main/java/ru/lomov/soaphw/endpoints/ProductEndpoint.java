package ru.lomov.soaphw.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.lomov.soaphw.services.ProductService;
import ru.lomov.soaphw.soap.products.GetAllProductRequest;
import ru.lomov.soaphw.soap.products.GetAllProductResponse;

import javax.xml.bind.JAXBElement;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.lomov.ru/ws/products";
    private final ProductService productService;

    //Запрос для Postman
    /*
     <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.lomov.ru/ws/products">
        <soapenv:Header/>
        <soapenv:Body>
            <f:getAllProductRequest/>
        </soapenv:Body>
     </soapenv:Envelope>
    * */



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductRequest")
    @ResponsePayload
    public GetAllProductResponse getAllProducts(@RequestPayload GetAllProductRequest request){
        GetAllProductResponse response = new GetAllProductResponse();
        productService.findAllProduct().forEach(response.getProducts()::add);
        return response;
    }
}
