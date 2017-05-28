import 'jquery';
import 'bootstrap/dist/css/bootstrap.css';
import "bootstrap/dist/js/bootstrap.min.js";
import './css/starter-template.css';

import React from 'react';
import ReactDOM from 'react-dom';

import Nav from './components/nav.jsx';

ReactDOM.render(
    <div>
        <Nav></Nav>
        <h1 className="starter-template">Hello, world!</h1>
    </div>,
  document.getElementById('root')
);