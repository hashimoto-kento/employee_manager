package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ConnectionManager;
import model.dao.YourDatabaseUtil;

/**
 * Servlet implementation class EmloyeeRegistarationServlet
 */
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub 
        Connection connection = null;
        
        try {
            connection = ConnectionManager.getConnection();
            
            List<String> sectionNames = YourDatabaseUtil.retrieveDepartmentsFromDatabase(connection);
            
            List<String> languages = YourDatabaseUtil.retrieveLanguagesFromDatabase(connection);
            
            
            request.setAttribute("sectionNames", sectionNames);
            request.setAttribute("languages", languages);
            
            System.out.println("all green");
            System.out.println(sectionNames);
        } catch (SQLException e) {
            /* e.printStackTrace();*/
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
            return;
        } catch (ClassNotFoundException e) {
            /*    e.printStackTrace();*/
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
            return;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    /*      e.printStackTrace();*/
            }
        }
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("employeeRegistration.jsp");
            dispatcher.forward(request, response);   
  }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phoneNumber = request.getParameter("phoneNumber");
        String section = request.getParameter("section");
        String language = request.getParameter("language");
        String hiringDate = request.getParameter("hiringDate");
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ConnectionManager.getConnection();
            String sql = "INSERT INTO m_employee (l_name, f_name, gender, birthday, phone_number, section, language, hire_date) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, gender);
            pstmt.setString(4, birthday);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, section);
            pstmt.setString(7, language);
            pstmt.setString(8, hiringDate);
            
            pstmt.executeUpdate();
            
            response.sendRedirect("menu.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Databese Error");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
