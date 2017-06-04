import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { Vote } from './vote';
import { TopicDto } from './topicDto';

export interface Property {
    topic: TopicDto
    index: number
    handleUpvote(topicId: string): void
    handleDownvote(topicId: string): void
}

export class Topic extends React.Component<Property, undefined> {

    constructor(props: Property) {
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
