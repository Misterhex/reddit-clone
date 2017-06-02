import * as React from 'react';
import * as ReactDOM from 'react-dom';

const title = "Reddit Clone";

interface MyProps {}
interface MyState {}

export default class Nav extends React.Component<MyProps, MyState> {
  render() {
    return (
  <nav className="navbar navbar-inverse navbar-fixed-top">
    <div className="container">
      <div className="navbar-header">
        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
          aria-controls="navbar">
            <span className="sr-only">Toggle navigation</span>
            <span className="icon-bar"></span>
            <span className="icon-bar"></span>
            <span className="icon-bar"></span>
          </button>
        <a className="navbar-brand" href="#">{title}</a>
      </div>
      <div id="navbar" className="collapse navbar-collapse">
      </div>
    </div>
  </nav>
        )
    }
}