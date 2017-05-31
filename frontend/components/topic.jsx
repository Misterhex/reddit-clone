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
            <td>
                <div class="btn-group" role="group" aria-label="...">
                    {topic.vote}
                    &nbsp; &nbsp;
                    <button type="button" class="btn btn-default">
                        <i className="glyphicon glyphicon-chevron-up"></i>
                    </button>
                    <button type="button" class="btn btn-default">
                        <i className="glyphicon glyphicon-chevron-down"></i>
                    </button>
                </div>
            </td>
            <td>{topic.headline}</td>
        </tr>
        )
    }
}
