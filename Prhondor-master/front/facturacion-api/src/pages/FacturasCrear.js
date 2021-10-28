import React from "react";
import Navbar from "../components/Navbar";
import APIInvoke from "../utils/APIInvoke";
import './FacturasCrear.css'

class FacturasCrear extends React.Component {

    constructor(args){
        super(args)
        this.state = {
            nombre: '',
            apellido: '',
            cedula: '',
            direccion: '',
            telefono: '',
            fecha: '',
            vendedor: '',
            articulo: '',
            precio: '',
            stock: '',
            codigo: ''
        }
        this.handleChange = this.handleChange.bind(this);   
    }

    componentDidMount(){
        document.getElementById("nombre").focus()
        document.getElementById("apellido").focus()
        document.getElementById("cedula").focus()
        document.getElementById("direccion").focus()
        document.getElementById("telefono").focus()
        document.getElementById("fecha").focus()
        document.getElementById("vendedor").focus()
        document.getElementById("articulo").focus()
        document.getElementById("precio").focus()
        document.getElementById("stock").focus()
        document.getElementById("codigo").focus()
    }

    handleChange(e){
        let name = e.target.name;
        let value = e.target.value;
        
        this.setState({
            [name]: value,
        })
        console.log(this.state);
    }

    async add(){
        const data = {
            nombre: this.state.nombre,
            apellido: this.state.apellido,
            cedula: this.state.cedula,
            direccion: this.state.direccion,
            telefono: this.state.telefono,
            fecha: this.state.fecha,
            vendedor: this.state.vendedor,
            articulo: this.state.articulo,
            precio: this.state.precio,
            stock: this.state.stock,
            codigo: this.state.codigo,
        }

        const response = await APIInvoke.invokePOST("/api/v1/facturas", data)
        console.log(response)

        if (response.id !== 0){
            this.props.history.push('/facturas')
        }else{
            console.log(response.message)
        }
    }

    render() {
        return (
            <div>
                <Navbar />
                <div id="frm">
                    <div className="container">
                        <div id="frm-row" className="row justify-content-center align-items-center">
                            <div id="frm-column" className="col-md-6">
                                <div id="frm-box" className="col-md-12">
                                    <div id="frm-form" className="form">
                                        <h3 className="text-center text-info">Crear Factura</h3>
                                        <div className="form-group">
                                            <label htmlFor="nombre" className="text-info">Nombre: </label><br />
                                            <input type="text" name="nombre" id="nombre" 
                                                className="form-control" 
                                                value={this.state.nombre}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="apellido" className="text-info">Apellido: </label><br />
                                            <input type="text" name="apellido" id="apellido" 
                                                className="form-control" 
                                                value={this.state.apellido}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="cedula" className="text-info">Cedula: </label><br />
                                            <input type="number" name="cedula" id="cedula" 
                                                className="form-control" 
                                                value={this.state.cedula}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="direccion" className="text-info">Dirección: </label><br />
                                            <input type="text" name="direccion" id="direccion" 
                                                className="form-control" 
                                                value={this.state.direccion}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="telefono" className="text-info">Telefono: </label><br />
                                            <input type="number" name="telefono" id="telefono" 
                                                className="form-control" 
                                                value={this.state.telefono}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="fecha" className="text-info">Fecha: </label><br />
                                            <input type="text" name="fecha" id="fecha" 
                                                className="form-control" 
                                                value={this.state.fecha}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="vendedor" className="text-info">Vendedor: </label><br />
                                            <input type="text" name="vendedor" id="vendedor" 
                                                className="form-control" 
                                                value={this.state.vendedor}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="articulo" className="text-info">Articulo: </label><br />
                                            <input type="text" name="articulo" id="articulo" 
                                                className="form-control" 
                                                value={this.state.articulo}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="precio" className="text-info">Precio: </label><br />
                                            <input type="number" name="precio" id="precio" 
                                                className="form-control" 
                                                value={this.state.precio}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="stock" className="text-info">Stock: </label><br />
                                            <input type="number" name="stock" id="stock" 
                                                className="form-control" 
                                                value={this.state.stock}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                            <label htmlFor="codigo" className="text-info">Codigo: </label><br />
                                            <input type="number" name="codigo" id="codigo" 
                                                className="form-control" 
                                                value={this.state.codigo}
                                                onChange={this.handleChange.bind(this)}
                                            />
                                        </div>

                                        <div className="form-group">
                                            <br />
                                            <button onClick={this.add.bind(this)} className="btn btn-info btn-md">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default FacturasCrear