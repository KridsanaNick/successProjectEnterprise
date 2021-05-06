<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%@page import="model.Covid"%>
<%@page import="model.CovidRank"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>

        <title>Covid Chart Report</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <script type="text/javascript" src="http://gstatic.com/charts/loader.js"></script>
        <%
            Covid cv = new Covid();
            cv.Json();
            CovidRank cr = new CovidRank();
            cr.Json();

        %>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawFirstChart);
            google.charts.setOnLoadCallback(drawSecondChart);
            google.charts.setOnLoadCallback(drawChart);

            function drawFirstChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Name', 'Value'],
                    ['Recovered', <%=cv.getRecovered()%>],
                    ['Hospitalized', <%=cv.getHospitalized()%>],
                    ['Deaths', <%=cv.getDeaths()%>],
                ]);


                var options = {
                    title: 'COVID-19 CORONAVIRUS PANDEMIC',
                    pieStartAngle: 100,
                    slices: {
                        0: {color: '#0da75e'},
                        1: {color: '#0DA3A7'},
                        2: {color: '#a7110d', offset: 0.2},
                    },
                };

                var chart = new google.visualization.PieChart(document.getElementById('FirstChart'));

                chart.draw(data, options);
            }
            function drawSecondChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Gender', 'Value'],
                    ['Male', <%=cr.getMale()%>],
                    ['Female', <%=cr.getFemale()%>],
                    ['Unknown', <%=cr.getUnknown()%>],
                ]);


                var options = {
                    title: 'GENDER REPORT',
                    slices: {
                        0: {color: '#55CDFC'},
                        1: {color: '#F7A8B8'},
                        2: {color: '#E8CFEE'},
                    },
                };

                var chart = new google.visualization.PieChart(document.getElementById('SecondChart'));

                chart.draw(data, options);
            }

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Name', 'Value'],
                    ['Recovered', <%=cv.getConfirmed()%>],
                    ['Hospitalized', <%=cv.getHospitalized()%>],
                    ['Deaths', <%=cv.getDeaths()%>],
                ]);


                var options = {
                    title: 'COVID-19 CORONAVIRUS PANDEMIC',
                    pieStartAngle: 100,
                    slices: {
                        0: {color: '#0da75e'},
                        1: {color: '#0DA3A7'},
                        2: {color: '#a7110d', offset: 0.2},
                    },
                };

                var chart = new google.visualization.PieChart(document.getElementById('Chart'));

                chart.draw(data, options);
            }


        </script> 
        <style>

        </style>

    </head>
    <body>




        <div class="container">
            <div class="row">
                <div class="col text-end">  
                    <p>
                        Update Date : 
                        <%
                            out.println(cv.getUpdateDate());
                        %>
                    </p>
                </div>

            </div>
            <div class="row">
                <div class="col">

                    <div class="row mt-3">
                        <div class="card text-center rounded-pill bg-warning ">
                            <h5 class="card-title text-center">Confirmed</h5>
                            <p class="card-text text-center"> 
                                <%
                                    out.println(cv.getConfirmed());
                                %>
                            </p>

                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col">
                            <div class="card text-center rounded-pill bg-success ">
                                <h6 class="card-title text-center">Recovered</h6>
                                <p class="card-text text-center"> 
                                    <%
                                        out.println(cv.getRecovered());
                                    %>
                                </p>

                            </div>

                        </div>
                        <div class="col">
                            <div class="card text-center rounded-pill bg-primary ">
                                <h6 class="card-title text-center">Hospitalized</h6>
                                <p class="card-text text-center"> 
                                    <%
                                        out.println(cv.getHospitalized());
                                    %>
                                </p>

                            </div>

                        </div>
                        <div class="col">
                            <div class="card text-center rounded-pill bg-danger ">
                                <h6 class="card-title text-center">Deaths</h6>
                                <p class="card-text text-center"> 
                                    <%
                                        out.println(cv.getDeaths());
                                    %>
                                </p>

                            </div>

                        </div>

                    </div>


                </div>



            </div>




            <div class="row">
                <div class="col"id="FirstChart" style="width: 900px; height: 500px;">                   
                </div>

            </div>

            <div class="row">
                <div class="col text-end">  
                    <p>
                        Update Date : 
                        <%
                            out.println(cr.getUpdateDate());
                        %>
                    </p>
                </div>

            </div>


            <div class="row">
                <div class="col">


                    <div class="row mt-3">
                        <div class="col">
                            <div class="card text-center rounded-pill " style="background-color: #55CDFC">
                                <h6 class="card-title text-center" >Male</h6>
                                <p class="card-text text-center"> 
                                    <%
                                        out.println(cr.getMale());
                                    %>
                                </p>

                            </div>

                        </div>
                        <div class="col">
                            <div class="card text-center rounded-pill"  style="background-color: #E8CFEE">
                                <h6 class="card-title text-center">Unknown</h6>
                                <p class="card-text text-center"> 
                                    <%
                                        out.println(cr.getUnknown());
                                    %>
                                </p>

                            </div>

                        </div>
                        <div class="col">
                            <div class="card text-center rounded-pill "style="background-color: #F7A8B8">
                                <h6 class="card-title text-center">Female</h6>
                                <p class="card-text text-center"> 
                                    <%
                                        out.println(cr.getFemale());
                                    %>
                                </p>

                            </div>

                        </div>

                    </div>


                </div>



            </div>

            <div class="row">

                <div class="col"id="SecondChart" style="width: 900px; height: 500px;">
                </div>
            </div>




        </div>

    </body>
</html>
