import React, { useEffect, useState } from 'react';
import Filters from '../../componentes/Filters';
import './styles.css';
import Chart from 'react-apexcharts';
import { barOptions, pieOptions } from './chart-options';
import axios from 'axios';
import { buildBarSeries, getGenderChartData, getPlatformChartData } from './helpers';

type PieCharData = {
    labels:string [];
    series:number[];
}

type BarChartData = {
    x:string;
    y: number;
}

const initialPieData ={
    labels: [],
    series: [],
}

const BASE_URL = 'http://demo-pesquisa.herokuapp.com'

const Charts = () =>{

    const[barChartData,setBarCharData] = useState<BarChartData[]>();
    const [platformData,setPlatformData] = useState<PieCharData>(initialPieData);
    const [genderData,setGenderData] = useState<PieCharData>(initialPieData);

    useEffect(()=>{
        async function getData(){
            const recordsResponse = await axios.get(`${BASE_URL}/records`);
            const gamesResponse = await axios.get(`${BASE_URL}/games`);
            console.log(recordsResponse.data);
            console.log(gamesResponse.data);

            const barData = buildBarSeries(gamesResponse.data,recordsResponse.data.content);
            //console.log(barData);
            setBarCharData(barData);

            const platFormChartData = getPlatformChartData(recordsResponse.data.content);
            setPlatformData(platFormChartData);

            const genreChartData = getGenderChartData(recordsResponse.data.content);
            setGenderData(genreChartData);
            
        }
        getData();
    },[])


    return (
        <div className="page-container">
             <Filters link="/records" linkText="Ver Tabela" />
                <div className="chart-container">
                    <div className="top-related">
                        <h1 className="top-related-title">
                            Jogos Mais Votados
                        </h1>
                        <div className="games-container">
                            <Chart options={barOptions} 
                                   type ="bar"
                                   width="500"
                                   height="350"
                                   series={[{data: barChartData }]}                                
                                />     
                        </div>
                    </div>
                    <div className="charts">
                       <div className="platform-chart">
                            <h2 className="chart-title">Plataformas</h2>
                            <Chart 
                             options ={{ ...pieOptions, labels: platformData?.labels }}
                             type="donut"
                             series={platformData?.series}
                             width="300"
                            />
                       </div> 
                       <div className="gender-chart">
                            <h2 className="chart-title">Gêneros</h2>
                            <Chart 
                             options ={{ ...pieOptions, labels: genderData?.labels }}
                             type="donut"
                             series={genderData?.series}
                             width="300"
                            />
                       </div>
                    </div>

                </div>

        </div>
    )
}

export default Charts; 