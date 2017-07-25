package casper.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import casper.dao.DataScripingDao;
import casper.model.DataScraping;
import casper.model.ResScraping;
import casper.util.ExecuteCommand;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws JsonParseException, JsonMappingException, IOException {
    	int i=0;
        DataScripingDao ao=new DataScripingDao();
        DataScraping d;
        
    	log.info("The time is now {}", dateFormat.format(new Date()));
        String path = System.getProperty("user.dir");
        path=path+"\\Scripts\\scrap.js";
        ExecuteCommand cmd=new ExecuteCommand("casperjs "+path);
        String res= cmd.run();
        if (res=="not elements") {
        	log.info(res);
        }
        else {
	        ObjectMapper mapper = new ObjectMapper();
	        List<ResScraping> h= mapper.readValue(res, new TypeReference<List<ResScraping>>(){});
	        
	        for (ResScraping resScraping : h) {
	        	d=new DataScraping();
	        	d.setHotel(resScraping.getHotel());
	        	d.setPrice(resScraping.getPrice());
	        	d.setScrapingDate(new Date());
	        	ao.saveScraping(d);
	        	String s=i+++":"+resScraping.getHotel();
	        	log.info(s);
			}
        }
        
    }
    
    
}
