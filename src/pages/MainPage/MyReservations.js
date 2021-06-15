import React, { Component } from 'react';
import Item from './Item';

class MyReservations extends Component {
    constructor(props) {
        super(props);
        
    }
    
    componentDidMount(){
        console.log(this.props.location.state.resv)
    }

    render() {
        return (
            <div style={{ width: "100%", height: "auto", marginTop: "4%" }}>
                {this.props.location.state.resv.map((item, key) => (<Item key={key} resv={item} />))}
            </div>
        );
    }
}

export default MyReservations;