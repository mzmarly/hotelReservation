import React, { Component } from 'react';
import Data from '../../services/Data';
import history from "../../history"

class RoomInfo extends Component {
    constructor(props) {
        super(props);
        this.reserve = this.reserve.bind(this)
    }

    componentDidMount(){
        console.log(this.props.location.state)
    }
    
    reserve(){
        let data ={
            login: sessionStorage.getItem('login'),
            idH:this.props.location.state.id,
            idR:this.props.location.state.room.roomId,
            in:this.props.location.state.in,
            out:this.props.location.state.out,
        }
        Data.reserveRoom(data).then(res=>{
           alert("Succes")
           history.push("/mainpage")
        })
    }

    render() {
        return (
            <div style={{ display: "flex", flexDirection: "column", alignItems: "center", marginTop: "3%" }}>
                 <div style={{ width: "100%", display: "flex", alignItems: "center", justifyContent: "space-evenly", marginBottom: "7.5%", }}>
                    <img style={{ border: "solid black 3px" }} src={this.props.location.state.room.url} alt="error" width="200" height="200"></img>
                    <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Check-in date: {this.props.location.state.in}</span>
                        <span style={{ fontFamily: "Arial", fontSize: "20px", marginBottom: "10%" }}>Check-out date: {this.props.location.state.out}</span>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Room size: {this.props.location.state.room.size}</span>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Price: {this.props.location.state.room.price}</span>
                    </div>
                </div>
                <div onClick={this.reserve} style={{fontFamily: "Arial", fontSize: "20px", border: "solid 1px black", padding: "0.25%", cursor: "pointer", backgroundColor: "grey" }}>Reserve</div>
            </div>
        );
    }
}

export default RoomInfo;