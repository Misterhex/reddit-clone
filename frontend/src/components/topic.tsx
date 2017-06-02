import React from 'react';
import ReactDOM from 'react-dom';
import Vote from './vote';

export default class TopicList extends React.Component  {

    constructor(props) {
        super(props);
    }

    render() {

        const topic = this.props.topic;
        const topicId = this.props.topic.uuid;
        const index = this.props.index + 1;
        const handleUpvote = this.props.handleUpvote;
        const handleDownvote = this.props.handleDownvote;

        return (
        <tr>
            <th scope="row">{index}</th>
            <td>
                <Vote vote={topic.vote} topicId={topicId} handleUpvote={handleUpvote} handleDownvote={handleDownvote}/>
            </td>
            <td>{topic.headline}</td>
        </tr>
        )
    }
}
