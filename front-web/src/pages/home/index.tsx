import React from 'react';
import {ReactComponent as Arrow} from '../../Assets/arrow.svg';
import {ReactComponent as Gamer} from '../../Assets/GAMER.svg';
import './styles.css';

const home  = () =>(
    <div className="home-container">
        <div className="home-text">
            <h1 className="home-text-tilte">
                Quais jogos a galera mais Curte?
            </h1>
            <h3 className="home-text-subtitle">
                Clique no botão abaixo e saiba quais são os jogos que os gamers estão escolhendo!
            </h3>
            <div className="home-actions">
                <button className="home-btn">Quero Saber Quais São?</button>
                <div className="home-btn-icon">
                <Arrow/>
              </div>
            </div>
        </div>
        <Gamer className="home-image"/>
    </div>
)

export default home