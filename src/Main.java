import java.sql.*;
void main(){
  try{
    Scanner sc=new Scanner(System.in);
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Nagothi");
    System.out.println("Enter Student Name:");
    String sname = sc.next();
    System.out.println("Enter Student No:");
    int sno = sc.nextInt();
    System.out.println("Enter Student CGPA:");
    float cgpa = sc.nextFloat();
    PreparedStatement pstmt=con.PreparedStatement("insert into student values(?,?,?)");
    pstmt.setInt(1,sno);
    pstmt.setString(2,sname);
    pstmt.setfloat(3,cgpa);
    int rows =pstmt.executeUpdate();
    if (rows>0){
      System.out.println(rows+"Rows Inserted");
    }
    else{
      System.out.println("Insert Failed");
    }
    stmt.close();
    con.close();
  }
  catch(Exception e){
    System.out.println(e);
  }
}

