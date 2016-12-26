$(document).ready(function(){
    $.ajax({
        type: 'get',
        url: '/likes/likesProfile',
        success: function(data){
            paintChart(data);
        }
    });
});
function paintChart(data){
    var plot1 = $.jqplot('chart1', [data], {
        title:'Активность/Your activity',
        axes:{
            xaxis:{
                renderer:$.jqplot.DateAxisRenderer,
                tickOptions:{
                    formatString:'%b&nbsp'
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
            sizeAdjust: 5.0
        },
        cursor: {
            show: false
        }
    });
}