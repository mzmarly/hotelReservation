import React, { Component } from 'react';
import history from "../../history"    
import "../../css/hotelpage.css"

class Hotel extends Component {
    constructor(props) {
        super(props);
        this.goToDeatils = this.goToDeatils.bind(this)
    }

    
    goToDeatils(){
        history.push({
            pathname: '/reserve',
            state:{hotel:this.props.hotel}
        })
    }


    render() {
        return (
            <div onClick={this.goToDeatils} className="hotel" style={{ display: "flex", alignItems: "center", justifyContent:"space-evenly", marginBottom:"7.5%", border:"solid black 1.5px", cursor:"pointer" }}>
                <img style={{border:"solid black 3px"}} src={this.props.hotel.url} alt="error" width="200" height="200"></img>
                <div style={{ display: "flex",flexDirection:"column", alignItems:"center"}}>
                    <span style={{marginBottom:"10%",fontFamily: "Arial", fontSize: "20px"}}>{this.props.hotel.stars}/5 stars</span>
                    <span style={{ fontFamily: "Arial", fontSize: "20px"}}>Street - {this.props.hotel.street}</span>
                </div>
            </div>
        );
    }
}

export default Hotel;