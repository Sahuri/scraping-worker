package casper.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import casper.model.Scraping;
import casper.util.HibernateUtil;

public class ScripingDao{
	
	public ScripingDao() {};
	
	/*@Transactional(readOnly=true)
    public List<?> findScrapings() {
        List<?> scrapingList = getHibernateTemplate().find("from Scraping");
        System.out.println("Employees found: " + scrapingList.size());
        return scrapingList;
    }*/
     
    
    public void deleteScraping(List<Scraping> scrapingList) {        
        if (!scrapingList.isEmpty()) {
            
            System.out.println("Employees deleted");
        }
    }
      
	 
	    public void saveScraping(Scraping data){
	    	SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
	    	Session session = sessionFactory.openSession();
	    	Transaction tx = null;
	    	try {
	    	   tx = session.beginTransaction();
	    	   session.save(data);
	    	   System.out.println("Create new scaping " + data.getHotel());
	    	   tx.commit();
	    	}
	    	catch (Exception e) {
	    	   if (tx!=null) tx.rollback();
	    	   e.printStackTrace(); 
	    	}finally {
	    	   session.close();
	    	}
	    	
		 } 
}

