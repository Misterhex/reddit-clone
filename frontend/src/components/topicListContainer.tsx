import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { Config } from './config';
import axios from 'axios';
import { TopicList } from './topicList';
import { AddNewTopic } from './addNewTopic';
import { NoData } from './noData';
import { TopicDto } from './topicDto';

export interface Property { }

export interface State {
    topics: TopicDto[]
}

export class TopicListContainer extends React.Component<Property, State> {

    voteEndpoint: string;
    topicsEndpoint: string;

    constructor(props: Property) {
        super(props);

        const c = new Config();
        this.topicsEndpoint = c.serverUrl + "api/topics/";
        this.voteEndpoint = c.serverUrl + "api/votes/";

        this.getTop20 = this.getTop20.bind(this);
        this.addNewTopic = this.addNewTopic.bind(this);
        this.handleUpvote = this.handleUpvote.bind(this);
        this.handleDownvote = this.handleDownvote.bind(this);

        this.state = {
            topics: []
        };
    }

    async componentDidMount() {
        await this.getTop20();
    }

    async getTop20() {
        const res = await axios.get(this.topicsEndpoint);
        this.setState({
            topics: res.data
        });
    }

    async addNewTopic(headline: string) {
        await axios.post(this.topicsEndpoint, {
            "headline": headline
        });

        await this.getTop20();
    }

    async handleUpvote(topicId: string) {
        await axios.post(this.voteEndpoint, {
            topicId: topicId,
            voteType: "up"
        });

        this.getTop20();
    }

    async handleDownvote(topicId: string) {
        await axios.post(this.voteEndpoint, {
            topicId: topicId,
            voteType: "down"
        });

        this.getTop20();
    }


    render() {

        let topicList;

        if (this.state.topics) {
            topicList = <TopicList topics={this.state.topics} handleUpvote={this.handleUpvote} handleDownvote={this.handleDownvote} />
        } else {
            topicList = <NoData />
        }

        return (
            <div>
                <AddNewTopic onAddNewTopic={this.addNewTopic} />
                <br />
                {topicList}
            </div>
        );
    }
}