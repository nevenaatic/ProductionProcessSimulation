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
year:boolean=false;





  constructor(private statisticService: StatisticService) {
    this.loadIncomes()
  }
   
back(){
  this.year = false;
}
loadIncomes()  {
  let chart=  new Chart( 'incomes', {
    type: 'bar',
    data: {
      labels: ['Jan', 'Feb', 'Mar','Apr', 'Maj', 'Jun','Jul', 'Avg', 'Sep','Okt', 'Nov', 'Dec'],
        datasets: [{
            label: 'prihodi ',
            data: [100, 350, 350, 420, 600, 340, 530, 612, 145,],
            backgroundColor: [
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
            ],
            borderColor: [
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',

              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',
              'rgb(102, 178, 255)',

           
            ],
            borderWidth: 1
        }, 
        {
          label: 'rashodi',
          data: [30, 120, 150, 120, 300, 80, 130, 202, 65],
          backgroundColor: [
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
          ],
          borderColor: [
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)',
            
          ],
          borderWidth: 1
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
          text: 'Prihodi i rashodi'
        }
      },
      
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
}
  )
}

  ngOnInit() {
    this.processNames();
    this.initChart();
    this.loadIncomes();
}

showInfo(tip: string){
  this.year = true;
  this.loadIncomes();
}


initChart() {
      let myChart2 = new Chart('myChart2', {
        type: 'pie',
        data: {
          labels: ['Nestanak struje', 'Loš materijal', 'Neadekvatan rad', 'Loša obrada gume', 'Loše pripremljen alat', 'Nedovoljna tvrdoća gume'],
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
            label: 'Prosečno vreme izvršavanja u satima',
            // data: [16.4, 30.1, 23.3, 5, 2, 3],
            data: [19.4, 30.1, 0, 0],
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
    // options: {
    //   responsive: true,
    //   plugins: {
    //     legend: {
    //       position: 'top',
    //       display: true
    //     },
    //     title: {
    //       display: true,
    //       text: 'Prosečno vreme izvršavanja'
    //     }
    //   }
    // }

});
console.log(myChart)
}
    private readonly processNames =()=> 
    this.statisticService.getProcessNames()
    .subscribe( res => { this.processNameList = res; this.initProcessChart()})
  }