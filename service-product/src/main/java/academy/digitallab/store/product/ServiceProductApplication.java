package academy.digitallab.store.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ServiceProductApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("org.h2.Driver");
        //Connection conn = DriverManager.getConnection("jdbc:h2:~/products", "sa", "");
        //conn.close();

        SpringApplication.run(ServiceProductApplication.class, args);
    }

}
