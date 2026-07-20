import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

void main() {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eneter Name to find: ");
        String Key =sc.next();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Nagothi");
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from student");
        while(res.next() && !res.getString(2).equals(Key));
        if(res.getString(2).equals(Key)){
            System.out.println("Found!....");
        }
        else{
            System.out.println("Not Found!....");
        }
        res.close();
        stmt.close();
        con.close();
    }
    catch(Exception e){
        System.out.println((e));
    }
}