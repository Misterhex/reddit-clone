import * as React from 'react';
import * as ReactDOM from 'react-dom';
import axios from 'axios';

interface State {
  value: string
}

interface Property {
  onAddNewTopic(headline: string): void
}

export class AddNewTopic extends React.Component<Property, State> {

  constructor(props: Property) {
    super(props);
    this.state = { value: '' };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    const ele = event.target as HTMLInputElement;
    this.setState({ value: ele.value });
  }

  handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    if (this.state.value) {
      const headline = this.state.value;
      this.setState({ value: '' });
      this.props.onAddNewTopic(headline);
    }
  }

  render() {
    return (
      <div>
        <form className="form-inline" onSubmit={this.handleSubmit}>

          <label className="sr-only" htmlFor="inlineFormInput">Headline</label>

          <input type="text" className="form-control mb-2 mr-sm-2 mb-sm-0" id="inlineFormInput"
            placeholder="Headline" value={this.state.value} onChange={this.handleChange} />

          <button type="submit" className="btn btn-primary">Add Topic</button>
        </form>
      </div>
    )
  }
}