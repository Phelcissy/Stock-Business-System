package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import com.stockpublish.hibernate.Stock;
import com.stockpublish.hibernate.StockDAO;
import com.stockpublish.hibernate.StockTodayInfo;
import com.stockpublish.hibernate.StockTodayInfoDAO;


public class StockTodayInfoDAOTest extends TestCase {
	final int id=1;
	final String stock_id="sto0000";
	final String stock_name="浦发银行";
	final String company_name="浦发银行";
	final double opening_price=0.75;
	final double min_price=0.71;
	final double max_price=0.79;
	final double close_price=0.75;
	
	private Date info_date;
	
	private Stock st;
	private StockDAO stDAO;
	private StockTodayInfo sti;
	private StockTodayInfoDAO stiDAO;
	
	protected void setUp() throws Exception {
		stDAO=new StockDAO();
		this.st=stDAO.findById(this.stock_id);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-DD");
		info_date=df1.parse("2010-11-03");
		sti=new StockTodayInfo(this.stock_id, this.info_date, this.opening_price,
				this.close_price, this.max_price, this.min_price);
		stiDAO=new StockTodayInfoDAO();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		sti=null;
		stiDAO=null;
		super.tearDown();
	}

	public void testSave() {
		stiDAO.save(sti);
		StockTodayInfo one=stiDAO.findByDateStockID(this.stock_id, this.info_date);
		assertEquals(this.stock_id,one.getStockId());
		assertEquals(this.info_date,one.getInfoDate());
	}


	public void testFindById() {
		StockTodayInfo one=stiDAO.findById(id);
		assertEquals(this.stock_id,one.getStockId());
		assertEquals(this.max_price,one.getMaximunPrice());
		assertEquals(this.min_price,one.getMinimunPrice());
	}

	public void testFindByDateStockIDStockDate() {
		StockTodayInfo one=stiDAO.findByDateStockID(this.stock_id, this.info_date);
		assertEquals(this.stock_id,one.getStockId());
		assertEquals(this.info_date,one.getInfoDate());
	}

	public void testFindByDateStockIDStringDate() {
		StockTodayInfo one=stiDAO.findByDateStockID(this.st, this.info_date);
		assertEquals(this.stock_id,one.getStockId());
		assertEquals(this.info_date,one.getInfoDate());
	}

}
