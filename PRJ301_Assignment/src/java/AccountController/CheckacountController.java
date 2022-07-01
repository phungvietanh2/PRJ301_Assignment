/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AccountController;

import Model.Account;
import Model.Feature;
import Model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public abstract class CheckacountController extends HttpServlet {

    private boolean isauthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account Accounts = (Account) session.getAttribute("account");
        if(Accounts ==null)
            return false;
        else
        {
            String visitingUrl = request.getServletPath();
            for (Role role : Accounts.getRoles()) {
                for (Feature feature : role.getFeatures()) {
                    if(feature.getFurl().equals(visitingUrl))
                        return true;
                }
            }
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isauthenticated(request)) {
            processget(request, response);
        } else {
            response.getWriter().println("oke");
        }
    }

    protected abstract void processget(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processpost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isauthenticated(request)) {
            processget(request, response);
        } else {
            response.getWriter().println("oke");
        }
    }
}
