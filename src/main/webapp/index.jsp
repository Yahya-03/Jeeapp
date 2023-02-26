<%@ page import="java.sql.Connection" %>
<%@ page import="db.DbConn" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Project JEE</title>
<%@include file="comp/allcss.jsp" %>
    <style type="text/css">
        .point-card{
            box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
        }
    </style>
</head>
<body>

<%@include file="comp/navbar.jsp" %>

<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/doct.jpg" class="d-block w-100" alt="..." height="500px">
        </div>
        <div class="carousel-item">
            <img src="img/hoss1.jpg" class="d-block w-100" alt="..." height="500px">
        </div>
        <div class="carousel-item">
            <img src="img/hopp.jpeg" class="d-block w-100" alt="..." height="500px">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="container p-3">
    <p class="text-center fs-2">Principales Caractéristiques de notre Hôpital</p>
    <div class="row">
        <div class="col-md-8 p-5">
            <div class="row">
                <div class="col-md-6">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">100% Sécurité</p>
                            <p>Il est très important de traiter le patient, et l'élite adipeuse sera suivie.
                                Plaisir, l'inventeur</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">Environnement Propre</p>
                            <p>Il est très important de traiter le patient, et l'élite adipeuse sera suivie.
                                Plaisir, l'inventeur</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card point-card">
                        <div class="card-body">
                            <p class="fs-5">Médecins Sympathiques</p>
                            <p>Il est très important de traiter le patient, et l'élite adipeuse sera suivie.
                                Plaisir, l'inventeur</p>
                        </div>
                    </div>
                </div>
                <div  class="col-md-6 mt-2">
                    <div class="card point-card">
                        <div class="card-body">
                         <p class="fs-5">Recherche Médicale</p>
                            <p>Il est très important de traiter le patient, et l'élite adipeuse sera suivie.
                                Plaisir, l'inventeur</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <img src="img/docc1.jpg">
        </div>
    </div>
</div>
<hr>

<div class="container p-2">
    <p class="text-center fs-2">Notre Equipe</p>
    <div class="row">
        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/d1h.png" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr.Hendou </p>
                    <p class="fs-7">(PDG et Président)</p>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/d2yo.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr.Youssef </p>
                    <p class="fs-7">(Médecin-Chef)</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/d3n.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr.Neziha </p>
                    <p class="fs-7">(Médecin-Chef)</p>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="card point-card">
                <div class="card-body text-center">
                    <img src="img/d4y.jpg" width="250px" height="300px">
                    <p class="fw-bold fs-5">Dr.Yahya </p>
                    <p class="fs-7">(Médecin-Chef)</p>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="comp/footer.jsp" %>

</body>
</html>