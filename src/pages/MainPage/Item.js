import React, { Component } from 'react';

class Item extends Component {

    componentDidMount(){
        console.log(this.props)
    }
    render() {
        return (
            <div style={{ display: "flex", alignItems: "center", justifyContent: "space-evenly", marginBottom: "1.5%", border: "solid black 1.5px" }}>
                <img style={{ border: "solid black 3px" }} src={this.props.resv.hotel.url} alt="error" width="200" height="200"></img>
                <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                    <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>{this.props.resv.hotel.stars}/5 stars</span>
                    <span style={{ fontFamily: "Arial", fontSize: "20px" }}>Street - {this.props.resv.hotel.street}</span>
                </div>
                <img style={{ border: "solid black 3px" }} src={this.props.resv.room.url} alt="error" width="200" height="200"></img>
                <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Check-in date: {this.props.resv.startDate}</span>
                        <span style={{ fontFamily: "Arial", fontSize: "20px", marginBottom: "10%" }}>Check-out date: {this.props.resv.endDate}</span>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Room size: {this.props.resv.size}</span>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Total price: {this.props.resv.totalPrice}</span>
                </div>
            </div>
        );
    }
}

export default Item;