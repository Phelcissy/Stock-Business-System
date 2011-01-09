package com.test;

import junit.framework.TestCase;

import com.stockpublish.hibernate.Stock;
import com.stockpublish.hibernate.StockDAO;

public class StockDAOTest extends TestCase {
	final String stock_id="sto0000";
	final String stock_name="浦发银行";
	final String company_name="浦发银行";
	final String status="1";
	
	private Stock st;
	private StockDAO stDAO;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		st=new Stock(this.stock_name,this.company_name,this.status);
		stDAO=new StockDAO();
		
	}

	protected void tearDown() throws Exception {
		this.st=null;
		this.stDAO=null;
		
		super.tearDown();
	}

	public void testSave() {
		stDAO.save(this.st);
		Stock one=stDAO.findById(this.stock_id);
		assertEquals(this.stock_name,one.getStockName());
	}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testFindById() {
		fail("Not yet implemented");
	}

	public void testFindByExample() {
		fail("Not yet implemented");
	}

	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	public void testFindByStockName() {
		fail("Not yet implemented");
	}

	public void testFindByCompanyName() {
		fail("Not yet implemented");
	}

	public void testFindByCompanyAddress() {
		fail("Not yet implemented");
	}

	public void testFindByZipCode() {
		fail("Not yet implemented");
	}

	public void testFindByCorporateRepName() {
		fail("Not yet implemented");
	}

	public void testFindByBusinessRegNum() {
		fail("Not yet implemented");
	}

	public void testFindByStatus() {
		fail("Not yet implemented");
	}

	public void testFindByCompanySynopsis() {
		fail("Not yet implemented");
	}

	public void testFindAll() {
		fail("Not yet implemented");
	}

	public void testMerge() {
		fail("Not yet implemented");
	}

	public void testAttachDirty() {
		fail("Not yet implemented");
	}

	public void testAttachClean() {
		fail("Not yet implemented");
	}

	public void testFindLikeName() {
		fail("Not yet implemented");
	}

}
