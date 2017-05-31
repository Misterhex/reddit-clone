import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';

import Topic from './topic.jsx';
import config from './config.jsx';

export default class TopicList extends React.Component {

  constructor(props) {
    super(props);

    this.config = new config();
    this.topicsEndpoint = this.config.serverUrl + "api/topics/";
    this.voteEndpoint = this.config.serverUrl + "api/votes/";

    this.state = {
      topics: []
    };

  }

  componentDidMount() {
    this.getTop20();
  }

  getTop20() {
    axios.get(this.topicsEndpoint)
      .then(res => {
        this.setState({ 
          topics: res.data 
        });
      });
  }

  handleUpvote(topicId) {
    axios.post(this.voteEndpoint, {
      topicId: topicId,
      voteType: "up"
    })
    .then(_=> {
      this.getTop20();
    });
  }

  render() {

    const handleUpvote = this.handleUpvote.bind(this);

    const topicList = this.state.topics.map((topic,i) => 
      <Topic key={topic.uuid} index={i} topic={topic} handleUpvote={handleUpvote}></Topic> );

    return (
<div className="container">
<table className="table table-striped">
  <thead>
    <tr>
      <th className="col-md-3">#</th>
      <th className="col-md-3">Votes </th>
      <th className="col-md-6">Headline </th>
    </tr>
  </thead>
  <tbody>
    {topicList}
  </tbody>
</table>
</div>
        )
    }
}