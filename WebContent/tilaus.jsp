<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">


<jsp:useBean id="ostoskoritaulukko" scope="request" type="java.util.List" />
<%@ page import="fi.omapizzeria.admin.bean.OstoskoriPizza" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>


<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aurinkopizza</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

   <div class="brand">Aurinkopizza</div><!-- Upper business name and info -->
    <div class="address-bar">
Opastinsilta 12 b, 00520 Helsinki
<br>Auki Arkisin 9-22, Viikonloppuisin 9-24</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Navigaatio</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Aurinkopizza</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="etusivu">Etusivu</a>
                    </li>
                    <li>
                        <a href="menu">Menu</a>
                    </li>
                    <li>
                        <a href="Palaute">Ota yhteyttä</a>
                    </li>
				<%if (ostoskoritaulukko.isEmpty()) { %>
						<%@ include file="okoriEmpty.inc" %>
				<%}else {%>
						<%@ include file="okori.inc" %>
				<%} %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box"> <!-- Container for contact info -->
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">
                    <strong>Tilaamasi tuotteet</strong>
                    </h2>
                    <hr>
                </div>
                
                <div class="col-md-4">
                    <p>Tilaamasi tuotteet ovat:
                         </p>
                        	
                               <% Iterator it2 = ostoskoritaulukko.iterator();
              	 while (it2.hasNext()) {  %>
		              <p>
		                  
		                           		 <%OstoskoriPizza ostoskoriItem = (OstoskoriPizza) it2.next(); %>
											<%=ostoskoriItem.getTuote_id() %>.
											<%=ostoskoriItem.getTuote_nimi() %>
											<%=ostoskoriItem.getRivihinta() %> &euro;
																			
		                         <br>
		              </p>
              <% } %>  
              

                    
                </div>
                <div class="clearfix"></div>
            </div>
        </div> <!-- /Container for contact -->

        <div class="row"> <!-- Container for contact form -->
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">
                   <strong> Tilauslomake </strong>
                        
                    </h2>
                    <hr>
                    
                    <c:if test="${not empty param.sent}"> <script>alert("Palautteen lähettäminen onnistui. Kiitos palautteesta.");</script></c:if>
                    
                    <form role="form" action="Tilaus" method="post">
                        <div class="row">
                            <div class="form-group col-lg-4">
                                <label>Etunimi</label>
                                <input type="text" name="tetunimi" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Sukunimi</label>
                                <input type="text" name="tsukunimi" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Osoite</label>
                                <input type="text" name="tosoite" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Postinumero</label>
                                <input type="text" name="tpostinro" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Postitoimipaikka</label>
                                <input type="text" name="tpostitmp" class="form-control">
                            </div>
                             <div class="form-group col-lg-4">
                                <label>Puhelinnumero</label>
                                <input type="tel" name="contactpuh" class="form-control">
                            </div>
                            
                            <div class="form-group col-lg-12">
                                <input type="hidden" name="save" value="${hintasumma}">
                                <button type="submit" class="btn btn-default">Lähetä</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div> <!-- /Container for contact form -->
        </div>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright ⓈⓄⒻⓉⒶⒼⓊⓇⓊⓉ</p>
                    <!-- DC Facebook Likes Start -->
<iframe src="http://www.facebook.com/plugins/like.php?href=https://www.facebook.com/pages/Haaga-Helia-University/188757324496426?fref=ts&send=false&layout=standard&width=250&show_faces=false&action=like&colorscheme=light&font&height=35" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:250px; height:35px;" allowTransparency="true"></iframe>
<!-- DC Facebook Likes End -->
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
