import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';

export default class AddNewTopic extends React.Component {

    constructor(props) {
      super(props);
      this.state = {value: ''};

      this.handleChange = this.handleChange.bind(this);
      this.handleClick = this.handleClick.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }
    
    handleSubmit(event) {
      event.preventDefault();
      const headline = this.state.value;
      this.props.onAddNewTopic(headline);
    }

    handleClick(event){
      this.state = {value: ''};
    }

    render() {
        return (
          <div>
            <form className="form-inline" onSubmit={this.handleSubmit}>
              <label className="sr-only" htmlFor="inlineFormInput">Headline</label>
              <input type="text" className="form-control mb-2 mr-sm-2 mb-sm-0" id="inlineFormInput" placeholder="Headline" onChange={this.handleChange}/>
              <button type="submit" className="btn btn-primary" onClick={this.handleClick}>Add Topic</button>
            </form>
          </div>
        )
    }
}