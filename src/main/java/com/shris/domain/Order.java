
package com.shris.domain;

public class Order {

	private String orderId;
	private String parentOrdId;
	private String clientId;
	private String accountId;
	private String ticker;
	private String type;
	private int qty;
	private double buyPrice;
	private double marketPrice;
	private double avgPrice;
	private double vwapPrice;
	private long dateTime;
	private String msg;
	private long orderDate;
	private String side;
	private long dateTimeNano;
	private String orderDateStr;

	public Order(String id, String ticker, long timestamp) {
		this.orderId = id;
		this.ticker = ticker;
		this.dateTime = timestamp;
	}
	
	public Order() {}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public double getVwapPrice() {
		return vwapPrice;
	}

	public void setVwapPrice(double vwapPrice) {
		this.vwapPrice = vwapPrice;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(long orderDate) {
		this.orderDate = orderDate;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getParentOrdId() {
		return parentOrdId;
	}

	public void setParentOrdId(String parentOrdId) {
		this.parentOrdId = parentOrdId;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public long getDateTimeNano() {
		return dateTimeNano;
	}

	public void setDateTimeNano(long dateTimeNano) {
		this.dateTimeNano = dateTimeNano;
	}

	public String getOrderDateStr() {
		return orderDateStr;
	}

	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}


}
