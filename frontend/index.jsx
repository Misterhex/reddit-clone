import 'jquery';
import "bootstrap/dist/js/bootstrap.min.js";
import 'bootstrap/dist/css/bootstrap.css';
import './css/starter-template.css';
import React from 'react';
import ReactDOM from 'react-dom';
import Nav from './components/nav.jsx';
import TopicListContainer from './components/topicListContainer.jsx';

ReactDOM.render(
    <div className="container">
        <Nav></Nav>
        <br/>
        <TopicListContainer></TopicListContainer>
    </div>,
  document.getElementById('root')
);