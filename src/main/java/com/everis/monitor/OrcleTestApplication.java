package com.everis.monitor;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.monitor.entities.Incurrido;
import com.everis.monitor.entities.User;
import com.everis.monitor.repositories.incurrido.IncurridoRepository;
import com.everis.monitor.repositories.user.UserRepository;

@RestController
@SpringBootApplication

public class OrcleTestApplication {
	@Autowired
	UserRepository userRep;
	
	@Autowired
	IncurridoRepository incRep;
	
	@GetMapping("/allUsers")
	public List<User> getall() {
		System.out.println("users: "+userRep.count());
		List<User> users = userRep.findAll();
		users.forEach(user -> System.out.println("user "+user));
		return users;
	}
	
	@GetMapping("/allInc")
	public List<Incurrido> getallInc() {
		System.out.println("incurridos: "+incRep.count());
		return incRep.findAll();
	}

	public static void main(String[] args) throws Exception {
	
		ApplicationContext ctx = SpringApplication.run(OrcleTestApplication.class, args);
//		IncurridoRepository IncRep = ctx.getBean(IncurridoRepository.class);
//		UserRepository userRep = ctx.getBean(UserRepository.class);
		
//		System.out.println("count: "+IncRep.count());
		
//		List<REPORT_INCURRIDO> incurridos = IncRep.findAll();
//		 long count = userRep.count();
//		 System.out.println("count users :"+count);
//		incurridos.forEach(inc -> System.out.println("Inc: "+ inc));
	
//		for(REPORT_INCURRIDO inc : incurridos) {
//			System.out.println("inc: "+inc);
//		}
		
//		
//		String url = "jdbc:oracle:thin:@10.45.18.1:1524:FENIX";
//        String username = "UREP_TET";
//        String password = "9SJvjzmYgUFBYC9";
//        String driver = "oracle.jdbc.OracleDriver";
//
//        Class.forName(driver);
//        Connection conn = DriverManager.getConnection(url, username, password);
//        if(conn != null) {
//        	System.out.println("success ");
//        }
//        try {
//            Statement statement = conn.createStatement();
//            
//            ResultSet rs = statement.executeQuery("SELECT * FROM FENIX_REP.REPORT_INCURRIDO WHERE NRO_EMPLEADO=134567");
//            System.out.println("selecting data *** ");
//            while(rs.next()) {
//                System.out.println("retreived data : "+rs.getObject(1)+" *** "+rs.getObject(3)+" *** "+rs.getObject(13) );
//            }
//        } finally {
//            conn.close();
//        }
        
		
	}

}
