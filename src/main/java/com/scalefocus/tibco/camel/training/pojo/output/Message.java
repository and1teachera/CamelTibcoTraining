//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.10.07 at 10:49:02 PM EEST 
//


package com.scalefocus.tibco.camel.training.pojo.output;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ClientData" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ClientAddress" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PriceSum" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PromotionApplied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Products" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ProductId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Promotion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}time"/&gt;
 *         &lt;element name="AdditionalData" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="Identificator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="NewVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transactionType",
    "transactionId",
    "clientData",
    "clientAddress",
    "priceSum",
    "promotionApplied",
    "products",
    "startDate",
    "additionalData",
    "newVersion"
})
@XmlRootElement(name = "Message")
public class Message {

    @XmlElement(name = "TransactionType", required = true)
    protected String transactionType;
    @XmlElement(name = "TransactionId", required = true)
    protected String transactionId;
    @XmlElement(name = "ClientData", required = true)
    protected String clientData;
    @XmlElement(name = "ClientAddress", required = true)
    protected String clientAddress;
    @XmlElement(name = "PriceSum")
    protected double priceSum;
    @XmlElement(name = "PromotionApplied")
    protected boolean promotionApplied;
    @XmlElement(name = "Products")
    protected List<Message.Products> products;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "AdditionalData")
    protected List<Message.AdditionalData> additionalData;
    @XmlElement(name = "NewVersion", required = true)
    protected String newVersion;

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the clientData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientData() {
        return clientData;
    }

    /**
     * Sets the value of the clientData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientData(String value) {
        this.clientData = value;
    }

    /**
     * Gets the value of the clientAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * Sets the value of the clientAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientAddress(String value) {
        this.clientAddress = value;
    }

    /**
     * Gets the value of the priceSum property.
     * 
     */
    public double getPriceSum() {
        return priceSum;
    }

    /**
     * Sets the value of the priceSum property.
     * 
     */
    public void setPriceSum(double value) {
        this.priceSum = value;
    }

    /**
     * Gets the value of the promotionApplied property.
     * 
     */
    public boolean isPromotionApplied() {
        return promotionApplied;
    }

    /**
     * Sets the value of the promotionApplied property.
     * 
     */
    public void setPromotionApplied(boolean value) {
        this.promotionApplied = value;
    }

    /**
     * Gets the value of the products property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the products property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message.Products }
     * 
     * 
     */
    public List<Message.Products> getProducts() {
        if (products == null) {
            products = new ArrayList<Message.Products>();
        }
        return this.products;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the additionalData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message.AdditionalData }
     * 
     * 
     */
    public List<Message.AdditionalData> getAdditionalData() {
        if (additionalData == null) {
            additionalData = new ArrayList<Message.AdditionalData>();
        }
        return this.additionalData;
    }

    /**
     * Gets the value of the newVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewVersion() {
        return newVersion;
    }

    /**
     * Sets the value of the newVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewVersion(String value) {
        this.newVersion = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="Identificator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "position",
        "identificator"
    })
    public static class AdditionalData {

        @XmlElement(name = "Type", required = true)
        protected String type;
        @XmlElement(name = "Position")
        protected int position;
        @XmlElement(name = "Identificator", required = true)
        protected String identificator;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the position property.
         * 
         */
        public int getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         * 
         */
        public void setPosition(int value) {
            this.position = value;
        }

        /**
         * Gets the value of the identificator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdentificator() {
            return identificator;
        }

        /**
         * Sets the value of the identificator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdentificator(String value) {
            this.identificator = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="ProductId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Promotion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "price",
        "name",
        "type",
        "productId",
        "promotion"
    })
    public static class Products {

        @XmlElement(name = "Price", required = true)
        protected String price;
        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Type", required = true)
        protected String type;
        @XmlElement(name = "ProductId", required = true)
        protected String productId;
        @XmlElement(name = "Promotion")
        protected Boolean promotion;

        /**
         * Gets the value of the price property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrice() {
            return price;
        }

        /**
         * Sets the value of the price property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrice(String value) {
            this.price = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the productId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductId() {
            return productId;
        }

        /**
         * Sets the value of the productId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductId(String value) {
            this.productId = value;
        }

        /**
         * Gets the value of the promotion property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPromotion() {
            return promotion;
        }

        /**
         * Sets the value of the promotion property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPromotion(Boolean value) {
            this.promotion = value;
        }

    }

}