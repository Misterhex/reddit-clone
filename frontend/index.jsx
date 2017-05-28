import 'jquery';
import "bootstrap/dist/js/bootstrap.min.js";

import 'bootstrap/dist/css/bootstrap.css';
import './css/starter-template.css';

import React from 'react';
import ReactDOM from 'react-dom';

import Nav from './components/nav.jsx';
import TopicList from './components/topicList.jsx';

ReactDOM.render(
    <div>
        <Nav></Nav>
        <TopicList></TopicList>
    </div>,
  document.getElementById('root')
);