package sevlet;

import util.*;
import bean.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class listFilm extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection conn=DButil.getConnection();
        List<filminfo> filmList= new ArrayList<filminfo>();
        if(conn!=null){
            try {
                Statement stmt=conn.createStatement();
                String sql="select film.film_id,film.title,film.description,`language`.name from film,`language`where film.language_id=`language`.language_id ";
                ResultSet rs=stmt.executeQuery(sql);
                while (rs.next()){
                    int film_id=rs.getInt("film_id");
                    String title=rs.getString("title");
                    String description=rs.getString("description");
                    String name=rs.getString("name");
                    //System.out.println(name);
                    filminfo bean = new filminfo();
                    bean.setFilm_id(film_id);
                    bean.setTitle(title);
                    bean.setDescription(description);
                    bean.setName(name);
                    filmList.add(bean);
                }
                req.setAttribute("allfilm", filmList);
                req.getRequestDispatcher("listfilm.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else {
            System.out.println("数据库连接失败!");
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req,resp);

    }
}
