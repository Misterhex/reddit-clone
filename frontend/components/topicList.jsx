import React from 'react';
import ReactDOM from 'react-dom';

import Topic from './topic.jsx';
import NoData from './noData.jsx';

export default class TopicList extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {

    const topicList = this.props.topics.map((topic,i) => 
      <Topic key={topic.uuid} index={i} topic={topic} handleUpvote={this.props.handleUpvote} handleDownvote={this.props.handleDownvote}></Topic> 
    );

      return (
        <div>
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
      );
    }
}