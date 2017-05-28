import React from 'react';
import ReactDOM from 'react-dom';
import Topic from './topic.jsx';

export default class TopicList extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {

    const topics = [1, 2, 3, 4, 5];

    const topicList = topics.map((topic) => <Topic topic={topic}></Topic> );

    return (
<div className="container">
<table className="table table-striped">
  <thead>
    <tr>
      <th className="col-md-2">#</th>
      <th className="col-md-2">Votes</th>
      <th className="col-md-8">Headline</th>
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