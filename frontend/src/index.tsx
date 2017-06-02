import 'jquery';
import "bootstrap/dist/js/bootstrap.min.js";
import 'bootstrap/dist/css/bootstrap.css';
import './css/starter-template.css';
import * as React from 'react';
import * as ReactDOM from 'react-dom';
import * as Nav from './components/nav';
import * as TopicListContainer from './components/topicListContainer';

ReactDOM.render(
    <div className="container">
        <Nav></Nav>
        <br/>
        <TopicListContainer></TopicListContainer>
    </div>,
  document.getElementById('root')
);