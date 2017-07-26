package casper.model;

import java.util.Date;


public class Scraping  {

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getOta() {
		return Ota;
	}
	public void setOta(String ota) {
		Ota = ota;
	}
	public String getHotel() {
		return Hotel;
	}
	public void setHotel(String hotel) {
		Hotel = hotel;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getRoom() {
		return Room;
	}
	public void setRoom(String room) {
		Room = room;
	}
	public String getKodepos() {
		return Kodepos;
	}
	public void setKodepos(String kodepos) {
		Kodepos = kodepos;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public Date getScrapingDate() {
		return ScrapingDate;
	}
	public void setScrapingDate(Date scrapingDate) {
		ScrapingDate = scrapingDate;
	}
	
	 private int Id;
	
	private String Ota;
	private String Hotel;
	private String Address;
	private String Room;
	private String Kodepos;
	private String Area;
	private double Price;
	private Date ScrapingDate;
}

