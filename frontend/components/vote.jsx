import React from 'react';
import ReactDOM from 'react-dom';

export default class Vote extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        const vote = this.props.vote;
        const topicId = this.props.topicId;
        const handleUpvote = this.props.handleUpvote;

        return (
                <div>
                    <span>{vote}</span>
                        &nbsp; &nbsp;
                    <div className="btn-group" role="group" aria-label="...">
                        <button type="button" className="btn btn-default" onClick={()=> handleUpvote(topicId)}>
                            <i className="glyphicon glyphicon-chevron-up"></i>
                        </button>
                        <button type="button" className="btn btn-default">
                            <i className="glyphicon glyphicon-chevron-down"></i>
                        </button>
                    </div>
                </div>
        )

    }
}