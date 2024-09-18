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
        <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
        
        <style>
            body {
		padding-top: 50px;
            }
                .special {
		padding-top:50px;
	}
        </style>
    </head>
    
    
    <body>
        
        <nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a  href ='../ServletSport/lister' class="navbar-brand" href=".">Système de gestion des épreuves</a>
			</div>
		</div>
	</nav>
        <div class="container special">
            <h2 class="h2">Liste des épreuves</h2>
		<div class="table-responsive">
        <%
                ArrayList<Epreuve> lesEpreuves = (ArrayList)request.getAttribute("pLesEpreuves");
        %>            
            <table class="table table-striped table-sm">  
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
            </div>
       </div>
</html>
