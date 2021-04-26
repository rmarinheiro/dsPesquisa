import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './styles.css';
import {formatDate} from './helpers'
import { RecordsResponse } from './types';

const BASE_URL = 'http://demo-pesquisa.herokuapp.com'

const Records = () => {
    const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
    console.log(recordsResponse);
    useEffect(() => {
        //console.log('componente iniciado')
        axios.get(`${BASE_URL}/records?linesPerPage=12`)
            .then(response => setRecordsResponse(response.data));
    }, []);

    return (
        <div className="page-container">
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
        </div>
    )
}



export default Records;