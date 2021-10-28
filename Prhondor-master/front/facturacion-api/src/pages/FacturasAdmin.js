import React from "react";
import Navbar from "../components/Navbar";
import APIInvoke from '../utils/APIInvoke'
import { Link } from 'react-router-dom'

class FacturasAdmin extends React.Component {

    constructor(args) {
        super(args)
        this.state = {
            facturas: []
        }
    }

    async componentDidMount() {
        const response = await APIInvoke.invokeGET("/api/v1/facturas")
        this.setState({
            facturas: response
        })
    }

    async remove(e, factura) {
        e.preventDefault();
        await APIInvoke.invokeDELETE(`/api/v1/facturas/${factura.id}`)
    }

    async componentDidUpdate() {
        const response = await APIInvoke.invokeGET("/api/v1/facturas")
        this.setState({
            facturas: response
        })
    }

    render() {

        const arreglofacturas = this.state.facturas

        return (
            <div>
                <Navbar />
                <div className="main container">
                    <div className="row">
                        <div className="col-md-12">
                        <Link to="/facturas-crear" className="btn btn-primary">Crear</Link>
                        
                        <div className="col-md-12">&nbsp;</div>
                            {
                                arreglofacturas.length === 0 ? <div className="alert alert-warning">No existen Registros.</div>:
                                <table className="table table-dark text-center">
                                    <thead>
                                        <tr>
                                            
                                            <th scope="col">Factura</th>
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Apellido</th>
                                            <th scope="col">Cedula</th>
                                            <th scope="col">Dirección</th>
                                            <th scope="col">Telefono</th>
                                            <th scope="col">Fecha</th>
                                            <th scope="col">Vendedor</th>
                                            <th scope="col">Articulo</th>
                                            <th scope="col">Precio</th>
                                            <th scope="col">Stock</th>
                                            <th scope="col">Codigo</th>
                                            <th scope="col">Opciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {
                                            arreglofacturas.map(
                                                factura =>
                                                    <tr key={factura.id}>
                                                        <td>{factura.id}</td>
                                                        <td>{factura.nombre}</td>
                                                        <td>{factura.apellido}</td>
                                                        <td>{factura.cedula}</td>
                                                        <td>{factura.direccion}</td>
                                                        <td>{factura.telefono}</td>
                                                        <td>{factura.fecha}</td>
                                                        <td>{factura.vendedor}</td>
                                                        <td>{factura.articulo}</td>
                                                        <td>{factura.precio}</td>
                                                        <td>{factura.stock}</td>
                                                        <td>{factura.codigo}</td>
                                                        <td>
                                                            <Link to={`/facturas-editar/${factura.id}`} className="btn btn-info btn-sm" title="Editar">
                                                                <i className="fa fa-edit"></i>
                                                            </Link>
                                                            &nbsp;&nbsp;
                                                            <button onClick={(e) => this.remove(e, factura)} className="btn btn-danger btn-sm" title="Eliminar">
                                                                <i className="fa fa-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                            )
                                        }
                                    </tbody>
                                </table>
                            }
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default FacturasAdmin