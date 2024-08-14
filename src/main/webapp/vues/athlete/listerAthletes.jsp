<%-- 
    Document   : listerAthletes
    Created on : 14 août 2024, 12:27:51
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
    </head>
    <body>
        <h1>Liste des athlètes</h1>
            <%
                ArrayList<Athlete> lesAthletes = (ArrayList)request.getAttribute("pLesAthletes");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>nom</th>             
                    <th>pays</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Athlete a : lesAthletes)
                        {              
                            out.println("<tr><td>");
                            out.println(a.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletAthlete/consulter?idAthlete="+ a.getId()+ "'>");
                            out.println(a.getNom());
                            out.println("</td>");;                        
                           
                            out.println("<td>");
                            out.println(p.getPays().getNom());
                            out.println("</td>");
                               
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
