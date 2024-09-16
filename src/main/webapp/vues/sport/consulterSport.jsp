<%-- 
    Document   : listerAthletes
    Created on : 14 août 2024, 12:27:51
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Sport"%>
<%@page import="sio.paris2024.model.Epreuve"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
    </head>
    <body>
        <%
                ArrayList<Epreuve> lesEpreuves = (ArrayList)request.getAttribute("pLesEpreuves");
        %>            
            <table>  
                <thead>
                    <tr>             
                        <th>id</th>
                        <th>nom des epreuves</th>
              
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            if (lesEpreuves != null && !lesEpreuves.isEmpty()) {
                            for (Epreuve e : lesEpreuves) {
                             
                                out.println("<tr><td>");
                                out.println(e.getId());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(e.getNom());
                                out.println("</a></td>");;
                               }
                            }
                        %>
                    </tr>
                </tbody>
            </table>
</html>
