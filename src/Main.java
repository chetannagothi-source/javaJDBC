import java.sql.*;
import java.util.*;
void main(){
  try{
    Scanner sc=new Scanner(System.in);
    System.out.println("How many records:");
    int n = sc.nextInt();
    int rows=0;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Nagothi");
    PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?)");
    for(int i=0;i<n;i++){
      System.out.println("Enter Student Name:");
      String sname = sc.next();
      System.out.println("Enter Student No:");
      int sno = sc.nextInt();
      System.out.println("Enter Student CGPA:");
      float cgpa = sc.nextFloat();
      pstmt.setInt(1,sno);
      pstmt.setString(2,sname);
      pstmt.setFloat(3,cgpa);
      rows =pstmt.executeUpdate();
    }
    if (rows>0){
      System.out.println(rows+"Rows Inserted");
    }
    else{
      System.out.println("Insert Failed");
    }
    pstmt.close();
    con.close();
  }
  catch(Exception e){
    System.out.println(e);
  }
}

