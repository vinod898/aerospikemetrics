package com.shris.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.shris.domain.Order;

@Service
public class Utils {


	Order order;

	static ArrayList<String> tickers = new ArrayList<String>();

	static {
		Map<String, String> tickerMap = getMasterTickerExchangeMap();
		tickers = new ArrayList<String>(tickerMap.keySet());
	}

	public Utils() {
            this.order = new Order();
	}

	public int randInt(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public double randDouble(double min, double max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	}

	public double randFloat(double min_price, double max_price) {

		if (min_price >= max_price) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return min_price + (max_price - min_price) * r.nextDouble();
	}

	public String convertLongToDateString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		return formatter.format(date);
	}

	public static Map<String, String> getMasterTickerExchangeMap() {
		Map<String, String> ticketExchangeCodeMap = new HashMap<String, String>();
		ticketExchangeCodeMap.put("A", "Agilent Technologies");
		ticketExchangeCodeMap.put("AAPL", "Apple");
		ticketExchangeCodeMap.put("BRK.A", "Berkshire Hathaway (class A shares)");
		ticketExchangeCodeMap.put("C", "Citigroup");
		ticketExchangeCodeMap.put("GOOG", "Alphabet Inc.");
		ticketExchangeCodeMap.put("HOG", "Harley-Davidson");
		ticketExchangeCodeMap.put("HPQ", "Agilent Technologies");
		ticketExchangeCodeMap.put("INTC", "Intel");
		ticketExchangeCodeMap.put("LUV", "Southwest Airlines (after their main hub at Love Field)");
		ticketExchangeCodeMap.put("MMM", "Minnesota Mining and Manufacturing (3M)");
		ticketExchangeCodeMap.put("MSFT", "Microsoft");
		ticketExchangeCodeMap.put("T", "AT&T");
		ticketExchangeCodeMap.put("TGT", "Target Corporation");
		ticketExchangeCodeMap.put("TXN", "Texas Instruments");
		ticketExchangeCodeMap.put("WMT", "Walmart");
		return ticketExchangeCodeMap;

	}

	public Order getOrderData(double min_price, double max_price) {

		Date date = new Date();
		final String orderId = UUID.randomUUID().toString().replace("-", "");
		final String accountId = UUID.randomUUID().toString().replace("-", "");
		final String clientId = UUID.randomUUID().toString().replace("-", "");
		final String parentOrderId = UUID.randomUUID().toString().replace("-", "");
		double avgPrice = randDouble(1234, 12365236);
		double buyPrice = randDouble(1234, 12365236);
		double marketPrice = randDouble(min_price, max_price);
		int qty = 100;
		double vwapPrice = randDouble(min_price, max_price);
		int index = new Random().nextInt(tickers.size() - 1 - 1) + 1;
		String ticker = tickers.size() > 0 ? tickers.get(index) : "MSFT";
		String msg = "Market Price for Ticker " + ticker + " is " + marketPrice;

		 this.order .setOrderId(orderId);
		 this.order.setAccountId(accountId);
		 this.order.setClientId(clientId);
		 this.order.setDateTimeNano(System.nanoTime());
		 this.order.setParentOrdId(parentOrderId);
		 this.order.setAvgPrice(avgPrice);
		 this.order.setBuyPrice(buyPrice);
		 this.order.setOrderDateStr(convertLongToDateString(date));
		 this.order.setMarketPrice(marketPrice);
		 this.order.setOrderDate(date.getTime());
		 this.order.setQty(qty);
		 this.order.setSide("BSE");
		 this.order.setOrderDate(System.currentTimeMillis());
		 this.order.setType( this.order.getDateTime() % 2 == 0 ? "Buy" : "Sell");

		 this.order.setMsg(msg);
		 this.order.setVwapPrice(vwapPrice);

		return this.order;

	}

//	public static Map<String, String> getMapFromCSV(final String filePath) throws IOException {
//
//		Stream<String> lines = Files.lines(Paths.get(filePath));
//		Map<String, String> resultMap = lines.map(line -> line.split(","))
//				.collect(Collectors.toMap(line -> line[0], line -> line[1]));
//
//		lines.close();
//
//		return resultMap;
//	}

}
