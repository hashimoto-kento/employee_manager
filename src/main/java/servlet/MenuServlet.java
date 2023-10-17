package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Map<String, String> actionMap = new HashMap<>();
        
        actionMap.put("employeeList", "/employeeList.jsp");
        actionMap.put("employeeRegistration", "/employeeRegistration.jsp");
        actionMap.put("languageRegistration", "/languageRegistration.jsp");
    
        String action = request.getParameter("action");
        
        if (action != null && actionMap.containsKey(action)) {
            String url = actionMap.get(action);
            
            response.sendRedirect(request.getContextPath() + url);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "URLが存在しません");
        }   
    }
}
