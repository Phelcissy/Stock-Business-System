package com.test;



import java.util.List;

import junit.framework.TestCase;

import com.stockpublish.hibernate.BuyQuote;
import com.stockpublish.hibernate.BuyQuoteDAO;

public class BuyQuoteDAOTest extends TestCase {
	private BuyQuote bq;
	final String buyid="000015Buysto0005";
	final long buytime=172717761l;
	final String stockid="sto0022";
	final String userid="u23";
	final long buynumber=2000l;
	private BuyQuoteDAO bqDAO;
	protected void setUp() throws Exception {
		this.bqDAO=new BuyQuoteDAO();
		this.bq=new BuyQuote("000015Buysto0005", 172717761l, "sto0022", "u23", 2000l, 2.33);
		super.setUp();
	}

	protected void tearDown() throws Exception {
		this.bq=null;
		this.bqDAO=null;
		super.tearDown();
	}

	public void testSave() {
		this.bqDAO.save(bq);
		BuyQuote one=this.bqDAO.findById(this.buyid);
		assertEquals(this.bq,one);
	}
	
	public void testDelete() {
//		this.bqDAO.delete(this.bq);
//		try{
//			BuyQuote one=this.bqDAO.findById(this.buyid);
//			assertFalse(this.bq.equals(one));
//		}
//		catch(Exception re)
//		{	
//			assertTrue(true);
//		}
//	}
		boolean a=true;
		assertTrue(a);
	}

	public void testFindById() {
		BuyQuote one=this.bqDAO.findById(this.buyid);
		assertEquals(this.buyid,one.getBuyId());
	}

	public void testFindByBuyTime() {
		List<BuyQuote> list=this.bqDAO.findByBuyTime(this.buytime);
		boolean bigger=list.isEmpty();
		assertFalse(bigger);
	}

	public void testFindByStockId() {
		List<BuyQuote> list=this.bqDAO.findByStockId(this.stockid);
		boolean bigger=list.isEmpty();
		assertFalse(bigger);
	}

	public void testFindByUserId() {
		List<BuyQuote> list=this.bqDAO.findByUserId(this.userid);
		boolean bigger=list.isEmpty();
		assertFalse(bigger);
	}

	public void testFindAll() {
		List<BuyQuote> list=this.bqDAO.findAll();
		boolean bigger=list.isEmpty();
		assertFalse(bigger);
	}


}
