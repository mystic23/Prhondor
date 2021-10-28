import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import Login from './pages/Login';
import Home from './pages/Home';
import FacturasAdmin from './pages/FacturasAdmin';
import FacturasCrear from './pages/FacturasCrear';
import FacturasEditar from './pages/FacturasEditar';

class App extends React.Component {

  render() {
    return (
      <Router>
        <Switch>
          <Route path="/" exact component={Login} />
          <Route path="/home" exact component={Home} />
          <Route path="/facturas" exact component={FacturasAdmin} />
          <Route path="/facturas-crear" exact component={FacturasCrear} />
          <Route path="/facturas-editar/:facturaId" exact component={FacturasEditar} />
        </Switch>
      </Router>
    )
  }
}
export default App;