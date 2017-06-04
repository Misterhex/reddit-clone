import * as React from 'react';
import * as ReactDOM from 'react-dom';

export class NoData extends React.Component<undefined, undefined> {

    render() {
        return (
            <div className="container">
                <p> No topics available </p>
            </div>
        )
    }
}