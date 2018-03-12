package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {

	private String product;
	private String quantity;
	private String discount;
	private String total;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String cardType;
	private String cardNumber;
	private String expDate;
	private String date;
	
	
	public Order(String product, String quantity, String name, String street, String city, String state, String zip,
			String cardType, String cardNumber, String expDate) {
	
		super();
		this.date = getDate();
		this.product = product;
		this.quantity = quantity;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
	}

	
	private String getDate() {
		LocalDate localDate = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = localDate.format(formatter);
		
		return date;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getData() {
		return date;
	}
	
	@Override
	public String toString() {
		return name+" "+" "+product+" "+quantity+" "+street+" "+city;
	}
	
	
	
}
