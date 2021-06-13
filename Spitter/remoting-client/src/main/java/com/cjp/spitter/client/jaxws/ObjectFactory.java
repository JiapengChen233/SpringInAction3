
package com.cjp.spitter.client.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cjp.spitter.client.jaxws package. 
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

    private final static QName _GetRecentSpittles_QNAME = new QName("http://jaxws.spitter.cjp.com/", "getRecentSpittles");
    private final static QName _AddSpittle_QNAME = new QName("http://jaxws.spitter.cjp.com/", "addSpittle");
    private final static QName _AddSpittleResponse_QNAME = new QName("http://jaxws.spitter.cjp.com/", "addSpittleResponse");
    private final static QName _GetSpittlesForSpitterResponse_QNAME = new QName("http://jaxws.spitter.cjp.com/", "getSpittlesForSpitterResponse");
    private final static QName _DeleteSpittleResponse_QNAME = new QName("http://jaxws.spitter.cjp.com/", "deleteSpittleResponse");
    private final static QName _DeleteSpittle_QNAME = new QName("http://jaxws.spitter.cjp.com/", "deleteSpittle");
    private final static QName _GetRecentSpittlesResponse_QNAME = new QName("http://jaxws.spitter.cjp.com/", "getRecentSpittlesResponse");
    private final static QName _GetSpittlesForSpitter_QNAME = new QName("http://jaxws.spitter.cjp.com/", "getSpittlesForSpitter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cjp.spitter.client.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddSpittle }
     * 
     */
    public AddSpittle createAddSpittle() {
        return new AddSpittle();
    }

    /**
     * Create an instance of {@link GetRecentSpittles }
     * 
     */
    public GetRecentSpittles createGetRecentSpittles() {
        return new GetRecentSpittles();
    }

    /**
     * Create an instance of {@link AddSpittleResponse }
     * 
     */
    public AddSpittleResponse createAddSpittleResponse() {
        return new AddSpittleResponse();
    }

    /**
     * Create an instance of {@link GetSpittlesForSpitterResponse }
     * 
     */
    public GetSpittlesForSpitterResponse createGetSpittlesForSpitterResponse() {
        return new GetSpittlesForSpitterResponse();
    }

    /**
     * Create an instance of {@link GetSpittlesForSpitter }
     * 
     */
    public GetSpittlesForSpitter createGetSpittlesForSpitter() {
        return new GetSpittlesForSpitter();
    }

    /**
     * Create an instance of {@link DeleteSpittle }
     * 
     */
    public DeleteSpittle createDeleteSpittle() {
        return new DeleteSpittle();
    }

    /**
     * Create an instance of {@link GetRecentSpittlesResponse }
     * 
     */
    public GetRecentSpittlesResponse createGetRecentSpittlesResponse() {
        return new GetRecentSpittlesResponse();
    }

    /**
     * Create an instance of {@link DeleteSpittleResponse }
     * 
     */
    public DeleteSpittleResponse createDeleteSpittleResponse() {
        return new DeleteSpittleResponse();
    }

    /**
     * Create an instance of {@link Spitter }
     * 
     */
    public Spitter createSpitter() {
        return new Spitter();
    }

    /**
     * Create an instance of {@link Spittle }
     * 
     */
    public Spittle createSpittle() {
        return new Spittle();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentSpittles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "getRecentSpittles")
    public JAXBElement<GetRecentSpittles> createGetRecentSpittles(GetRecentSpittles value) {
        return new JAXBElement<GetRecentSpittles>(_GetRecentSpittles_QNAME, GetRecentSpittles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSpittle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "addSpittle")
    public JAXBElement<AddSpittle> createAddSpittle(AddSpittle value) {
        return new JAXBElement<AddSpittle>(_AddSpittle_QNAME, AddSpittle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSpittleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "addSpittleResponse")
    public JAXBElement<AddSpittleResponse> createAddSpittleResponse(AddSpittleResponse value) {
        return new JAXBElement<AddSpittleResponse>(_AddSpittleResponse_QNAME, AddSpittleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpittlesForSpitterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "getSpittlesForSpitterResponse")
    public JAXBElement<GetSpittlesForSpitterResponse> createGetSpittlesForSpitterResponse(GetSpittlesForSpitterResponse value) {
        return new JAXBElement<GetSpittlesForSpitterResponse>(_GetSpittlesForSpitterResponse_QNAME, GetSpittlesForSpitterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSpittleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "deleteSpittleResponse")
    public JAXBElement<DeleteSpittleResponse> createDeleteSpittleResponse(DeleteSpittleResponse value) {
        return new JAXBElement<DeleteSpittleResponse>(_DeleteSpittleResponse_QNAME, DeleteSpittleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSpittle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "deleteSpittle")
    public JAXBElement<DeleteSpittle> createDeleteSpittle(DeleteSpittle value) {
        return new JAXBElement<DeleteSpittle>(_DeleteSpittle_QNAME, DeleteSpittle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentSpittlesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "getRecentSpittlesResponse")
    public JAXBElement<GetRecentSpittlesResponse> createGetRecentSpittlesResponse(GetRecentSpittlesResponse value) {
        return new JAXBElement<GetRecentSpittlesResponse>(_GetRecentSpittlesResponse_QNAME, GetRecentSpittlesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpittlesForSpitter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.spitter.cjp.com/", name = "getSpittlesForSpitter")
    public JAXBElement<GetSpittlesForSpitter> createGetSpittlesForSpitter(GetSpittlesForSpitter value) {
        return new JAXBElement<GetSpittlesForSpitter>(_GetSpittlesForSpitter_QNAME, GetSpittlesForSpitter.class, null, value);
    }

}
