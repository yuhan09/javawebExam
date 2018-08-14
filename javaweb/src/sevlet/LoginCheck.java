package sevlet;

import util.DButil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.*;

public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)
            throws javax.servlet.ServletException, IOException {

        Connection conn=DButil.getConnection();
        if(conn!=null){
            String user_name=req.getParameter("user_name");
            try {
                Statement stmt=conn.createStatement();
                String sql="select first_name from customer where first_name='"+user_name+"'";
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next()){
                    req.getRequestDispatcher("loginsuccess.jsp").forward(req, resp);
                }else {
                    req.getRequestDispatcher("loginerror.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else {
            System.out.println("数据库连接失败!");
        }

    }

    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws javax.servlet.ServletException, IOException {
        doPost(req,resp);

    }
}
