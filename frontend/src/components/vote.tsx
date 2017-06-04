import * as React from 'react';
import * as ReactDOM from 'react-dom';

export interface Property {
    vote: number
    topicId: string
    handleUpvote(topicId: string) : void
    handleDownvote(topicId: string) : void
}

export class Vote extends React.Component<Property, undefined> {

    constructor(props: Property) {
        super(props);
    }

    render() {
        const vote = this.props.vote;
        const topicId = this.props.topicId;
        const handleUpvote = this.props.handleUpvote;
        const handleDownvote = this.props.handleDownvote;

        return (
                <div>
                    <span>{vote}</span>
                        &nbsp; &nbsp;
                    <div className="btn-group" role="group" aria-label="...">
                        <button type="button" className="btn btn-default" onClick={()=> handleUpvote(topicId)}>
                            <i className="glyphicon glyphicon-chevron-up"></i>
                        </button>
                        <button type="button" className="btn btn-default" onClick={()=> handleDownvote(topicId)}>
                            <i className="glyphicon glyphicon-chevron-down"></i>
                        </button>
                    </div>
                </div>
        )
    }
}