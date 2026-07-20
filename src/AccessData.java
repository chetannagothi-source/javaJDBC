import java.sql.*;
public class AccessData {
     static void main(String[] args){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Nagothi");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("select * from student");
            System.out.println("SNO\tSNAME\tCGPA");
            System.out.println("==========================");
            while(result.next()){
                System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getFloat(3));
            }
            result.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
          System.out.println(e);
        }
    }
}
