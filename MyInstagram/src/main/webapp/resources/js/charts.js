$(document).ready(function(){
    var line1=[['18.01.2016', 30], ['18.02.2016', 10], ['18.03.2016', 55], ['18.04.2016', 11],
        ['18.05.2016', 14], ['18.06.2016', 10], ['18.07.2016', 10], ['18.08.2016', 77],
        ['18.09.2016', 1], ['18.10.2016', 23], ['18.11.2016', 0], ['18.12.2016', 13]];
    var plot1 = $.jqplot('chart1', [line1], {
        title:'Data Point Highlighting',
        axes:{
            xaxis:{
                renderer:$.jqplot.DateAxisRenderer,
                tickOptions:{
                    formatString:'%b&nbsp;%#d'
                }
            },
            yaxis:{
                tickOptions:{
                    formatString:'%d'
                }
            }
        },
        highlighter: {
            show: true,
            sizeAdjust: 7.5
        },
        cursor: {
            show: false
        }
    });
});