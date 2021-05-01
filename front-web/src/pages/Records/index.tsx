import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './styles.css';
import {formatDate} from './helpers'
import { RecordsResponse } from './types';
import Pagination from './Pagination';
import { Link } from 'react-router-dom'
import Filters from '../../componentes/Filters';

const BASE_URL = 'http://demo-pesquisa.herokuapp.com'



const Records = () => {
    const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
    const[activePage,setActivePage]=useState(0)

    const handlePaginationChange = (index:number)=>{
        setActivePage(index)
    }
    
    useEffect(() => {
        //console.log('componente iniciado')
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
            .then(response => setRecordsResponse(response.data));
    }, [activePage]);

    return (
        <div className="page-container">
            <Filters link="/charts" linkText="Ver Gráfico" />
            <table className="records-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th>Instante</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Plataforma</th>
                        <th>Genero</th>
                        <th>Título do Game</th>
                    </tr>
                </thead>
                <tbody>

                    {recordsResponse?.content.map(record => (
                        <tr key={record.id}>
                            <td>
                                {formatDate(record.moment)}
                        </td>
                            <td>
                                {record.name}
                        </td>
                            <td>
                                {record.age}
                        </td>
                            <td className="text-secondary">
                                {record.plataform}
                        </td>
                            <td>
                                {record.genreName}
                        </td>
                            <td className="text-primary">
                                {record.gameTitle}
                        </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Pagination 
                activePage={activePage}
                goToPage={handlePaginationChange}
                totalPages = {recordsResponse?.totalPages}
                />
        </div>
    )
}



export default Records;