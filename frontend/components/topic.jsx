import React from 'react';
import ReactDOM from 'react-dom';

export default class TopicList extends React.Component  {

    constructor(props) {
        super(props);
    }

    render() {

        const topic = this.props.topic;
        return (
        <tr>
            <th scope="row">{this.props.index + 1}</th>
            <td>{topic.vote}</td>
            <td>{topic.headline}</td>
        </tr>
        )
    }
}
