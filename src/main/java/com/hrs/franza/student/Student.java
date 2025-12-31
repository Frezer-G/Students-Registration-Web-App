/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hrs.franza.student;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/register", "/show_all"})
public class Student extends HttpServlet {

    // POST /register - Handles data submission 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); // 
        String email = request.getParameter("email"); // 
        String yearStr = request.getParameter("year"); // 

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Action: Validate and insert record [cite: 4, 11]
            String sql = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, Integer.parseInt(yearStr));
            ps.executeUpdate();
            
            response.sendRedirect("show_all"); // Go to list after success
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html><html lang='en'><head>");
    // Use local styles instead of external CDN/fonts
    out.println("<style>");
    out.println("body { font-family: Inter, system-ui, -apple-system, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif; background:#f1f5f9; margin:0; padding:32px; color:#0f172a; }");
    out.println(".container { max-width:64rem; margin:0 auto; }");
    out.println(".header { display:flex; justify-content:space-between; align-items:center; margin-bottom:32px; }");
    out.println(".add-button { background:#ffffff; border:1px solid #e6eef6; padding:8px 12px; border-radius:8px; text-decoration:none; color:#0f172a; font-size:0.875rem; }");
    out.println(".card { background:#ffffff; border-radius:12px; box-shadow:0 1px 2px rgba(2,6,23,0.06); border:1px solid #e6eef6; overflow:hidden; }");
    out.println("table { width:100%; border-collapse:collapse; }");
    out.println("thead { background:#f8fafc; border-bottom:1px solid #e6eef6; }");
    out.println("th { padding:16px 24px; font-size:0.75rem; font-weight:600; color:#64748b; text-transform:uppercase; letter-spacing:0.05em; text-align:left; }");
    out.println("td { padding:16px 24px; font-size:0.875rem; color:#0f172a; }");
    out.println("tbody tr:hover { background:#f8fafc; transition:background .15s ease; }");
    out.println("</style></head>");
    out.println("<body style='background:#f1f5f9;padding:32px;'>");
    out.println("<div class='max-w-4xl mx-auto'>");
    out.println("<div class='flex justify-between items-center mb-8'>");
    out.println("<div><h2 class='text-2xl font-bold text-slate-800'>Registered Students</h2><p class='text-slate-500'>Full list of students from the database.</p></div>");
    out.println("<a href='index.jsp' class='bg-white border border-slate-200 px-4 py-2 rounded-lg text-sm font-medium hover:bg-slate-50 transition-all'>+ Add New Student</a>");
    out.println("</div>");
    
    out.println("<div class='bg-white rounded-xl shadow-sm border border-slate-200 overflow-hidden'>");
    out.println("<table class='w-full text-left border-collapse'>");
    out.println("<thead class='bg-slate-50 border-b border-slate-200'>");
    out.println("<tr><th class='px-6 py-4 text-xs font-semibold text-slate-500 uppercase tracking-wider'>Name</th>");
    out.println("<th class='px-6 py-4 text-xs font-semibold text-slate-500 uppercase tracking-wider'>Email</th>");
    out.println("<th class='px-6 py-4 text-xs font-semibold text-slate-500 uppercase tracking-wider'>Year</th></tr></thead>");
    out.println("<tbody class='divide-y divide-slate-100'>");

    try (Connection conn = DatabaseConnection.getConnection()) {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students"); // [cite: 6]
        while (rs.next()) {
            out.println("<tr class='hover:bg-slate-50 transition-colors'>");
            out.println("<td class='px-6 py-4 text-sm font-medium text-slate-700'>" + rs.getString("name") + "</td>"); // [cite: 7]
            out.println("<td class='px-6 py-4 text-sm text-slate-500'>" + rs.getString("email") + "</td>"); // [cite: 7]
            out.println("<td class='px-6 py-4 text-sm text-slate-500'>" + rs.getInt("year") + "</td>"); // [cite: 7]
            out.println("</tr>");
        }
    } catch (Exception e) {
        out.println("<tr><td colspan='3' class='px-6 py-4 text-red-500'>Error loading data.</td></tr>");
    }

    out.println("</tbody></table></div></div></body></html>");
}}