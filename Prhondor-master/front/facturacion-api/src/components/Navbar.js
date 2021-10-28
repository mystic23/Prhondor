import React from "react";
import {Link} from 'react-router-dom'
import Logo from '../assets/img/logo.png'

function Navbar(props){
    return(
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <Link to="/home" className="navbar-brand">
                <img height="50" width="50" src={Logo} alt="Logo de Prhondor"/>&nbsp;&nbsp;
                <strong>Home</strong>
            </Link>
            <Link to="/facturas" className="btn btn-info my-2 my-sm-0 mr-3">Facturas</Link><p/> 
            
        </nav>
    )
}
export default Navbar