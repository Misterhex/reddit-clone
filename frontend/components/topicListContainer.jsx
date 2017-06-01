import React from 'react';
import ReactDOM from 'react-dom';
import Config from 'Config';
import axios from 'axios';

import TopicList from './topicList.jsx';
import AddNewTopic from './addNewTopic.jsx';

export default class TopicListContainer extends React.Component {

    constructor(props) {
        super(props);
        this.topicsEndpoint = Config.serverUrl + "api/topics/";
        this.voteEndpoint = Config.serverUrl + "api/votes/";

        this.getTop20 = this.getTop20.bind(this);
        this.addNewTopic = this.addNewTopic.bind(this);
        this.handleUpvote = this.handleUpvote.bind(this);

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

    addNewTopic(headline) {
      debugger;
      axios.post(this.topicsEndpoint, {
        "headline": headline
      })
      .then(res => {
        this.getTop20();
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
        return (
            <div>
                <AddNewTopic onAddNewTopic={this.addNewTopic} />
                <br/>
                <TopicList topics={this.state.topics} handleUpvote={this.handleUpvote}/>
            </div>
        );
    }

}

