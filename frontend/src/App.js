import logo from './logo.svg';
import './App.css';
import NavbarComponent from "./NavbarComponent";
import Footer from "./Footer";
import React, { useRef } from "react";
import Formulario from './Formulario';

function App() {
  return (
    <div className="App">
      <NavbarComponent />
      <Formulario />
      <Footer />
    </div>
  );
}

export default App;
