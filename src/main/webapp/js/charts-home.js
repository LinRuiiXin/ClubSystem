/*global $, document, Chart, LINECHART, data, options, window*/
$(document).ready(function () {
    var checkInCountList;
    'use strict';
    $.ajax({
        url:"../loadLineChartServlet",
        method:"get"
    }).done(function(data){
        if(data.status == 0){
            checkInCountList = data.obj;
            var legendState = true;
            if ($(window).outerWidth() < 576) {
                legendState = false;
            }

            var LINECHART = $('#lineCahrt');
            var myLineChart = new Chart(LINECHART, {
                type: 'line',
                options: {
                    scales: {
                        xAxes: [{
                            display: true,
                            gridLines: {
                                display: false
                            }
                        }],
                        yAxes: [{
                            display: true,
                            gridLines: {
                                display: false
                            }
                        }]
                    },
                    legend: {
                        display: legendState
                    }
                },
                data: {
                    labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"],
                    datasets: [
                        {
                            label: "Page Views",
                            fill: true,
                            lineTension: 0,
                            backgroundColor: "transparent",
                            borderColor: "#54e69d",
                            pointHoverBackgroundColor: "#44c384",
                            borderCapStyle: 'butt',
                            borderDash: [],
                            borderDashOffset: 0.0,
                            borderJoinStyle: 'miter',
                            borderWidth: 1,
                            pointBorderColor: "#44c384",
                            pointBackgroundColor: "#fff",
                            pointBorderWidth: 1,
                            pointHoverRadius: 5,
                            pointHoverBorderColor: "#fff",
                            pointHoverBorderWidth: 2,
                            pointRadius: 1,
                            pointHitRadius: 10,
                            data:checkInCountList,
                            spanGaps: false
                        }
                    ]
                }
            });
        }else if(data.status == 1){
            xtip.msg(data.msg,{icon:'s',type:'w'});
        }
    })
    // ------------------------------------------------------- //
    // Line Chart
    // ------------------------------------------------------ //




    

});
