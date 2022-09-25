import { Component, Input, OnInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';
import { StatisticService } from 'src/app/services/statistic.service';
Chart.register(...registerables);   //fucking registration
@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
processNameList: []=[];
  constructor(private statisticService: StatisticService) {}
   
  ngOnInit() {
    this.processNames();
 this.initChart();
//  this.initProcessChart();
}

initChart() {
      let myChart2 = new Chart('myChart2', {
        type: 'pie',
        data: {
          labels: ['Nestanak struje', 'Los materijal', 'Neadekvatan rad', 'Losa obrada gume', 'Lose pripremljen alat', 'Nedovoljna tvrdoca gume'],
          datasets: [{
            data: [5, 7, 3, 4, 1, 2],
            backgroundColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(240, 159, 74, 1)'
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(240, 159, 54, 1)'
            ],
            borderWidth: 1,
          }]
        },
        options: {
          responsive: true,
          plugins: {
            legend: {
              position: 'top',
              display: true
            },
            title: {
              display: true,
              text: 'Verovatnoća pojave najčešćih grešaka %'
            }
          }
        }
      });
    }

initProcessChart(){

  const myChart = new Chart('myChart', {
    type: 'bar',
    data: {
        // labels: ['Proizvodnja membrana', 'Proivodnja besavnih cevi', 'AKZ cevi'],
        labels: this.processNameList,
        datasets: [{
            label: 'Prosečno vreme izvršavanja',
            // data: [16.4, 30.1, 23.3, 5, 2, 3],
            data: [16.4, 30.1, 0, 0],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                // 'rgba(75, 192, 192, 0.2)',
                // 'rgba(153, 102, 255, 0.2)',
                // 'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                // 'rgba(75, 192, 192, 1)',
                // 'rgba(153, 102, 255, 1)',
                // 'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
 
});
console.log(myChart)
}
    private readonly processNames =()=> 
    this.statisticService.getProcessNames()
    .subscribe( res => { this.processNameList = res; this.initProcessChart()})
  }