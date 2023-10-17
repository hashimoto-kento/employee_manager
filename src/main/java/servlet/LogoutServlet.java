package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        
        String id = (String) session.getAttribute("id");
        
        String logoutMessage = id + "さん ログアウトしました";
        
        request.setAttribute("logoutMessage", logoutMessage);
        
        HttpSession adminSession = request.getSession(false);
        
        
        if(adminSession !=null) {
            
            System.out.println("セッションが存在しています。そのため、セッションを破棄します。");
            
            adminSession.invalidate();
            
        } else {
            System.out.println("セッションが存在していません。");
        
        }
        
        adminSession = request.getSession(false);
        
        if(adminSession == null) {
            System.out.println("セッションが破棄されました。");
        };
        
                
        RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp");
        dispatcher.forward(request, response);
        
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    }
}
