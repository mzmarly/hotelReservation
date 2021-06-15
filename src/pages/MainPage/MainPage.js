import React, { Component } from 'react';
import Data from "../../services/Data"
import Hotel from "./Hotel"
import history from "../../history"

class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            city: "Cracow",
            hotels: []
        }
        this.getHotels = this.getHotels.bind(this)
        this.change = this.change.bind(this)
        this.logout = this.logout.bind(this)
        this.getMyReservations = this.getMyReservations.bind(this)
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value,
        })
    }

    getHotels() {
        Data.getHotels(this.state.city).then(res => {
            console.log(res.data)
            this.setState({
                hotels: res.data
            })
        })
    }

    getMyReservations(){
        Data.getMyReservations(sessionStorage.getItem('login')).then(res =>{
            history.push({
                pathname: '/myreservations',
                state:{resv:res.data}
            })
        })
    }

    logout(){
        sessionStorage.removeItem('login')
        history.push("/")
    }

    render() {
        return (
            <div style={{ display: "flex", flexDirection: "column", alignItems: "center", }}>
                <div style={{fontFamily: "Arial", fontSize: "20px", border: "solid 1px black", padding: "0.25%", cursor: "pointer", backgroundColor: "grey", marginTop:"1%",marginLeft:"90%" }} onClick={this.logout}>Logout</div>
                <h1 style={{ fontFamily: "Arial", fontSize: "25px", marginTop: "2%", marginBottom: "1%" }}>Search for hotel by location</h1>
                <select style={{ width: "60%", height: "40px", fontFamily: "Arial", fontSize: "15px", marginBottom: "1%" }} name="city" onChange={this.change}>
                    <option>Cracow</option>
                    <option>Sopot</option>
                    <option>London</option>
                </select>
                <div style={{ fontFamily: "Arial", fontSize: "20px", border: "solid 1px black", padding: "0.25%", cursor: "pointer", backgroundColor: "grey", marginBottom:"1%"}} onClick={this.getHotels}>GO</div>
                <div style={{ fontFamily: "Arial", fontSize: "20px", border: "solid 1px black", padding: "0.25%", cursor: "pointer", backgroundColor: "grey" }} onClick={this.getMyReservations}>My reservations</div>
                <div style={{ width: "25%", height: "auto", marginTop: "4%" }}>
                    {this.state.hotels.map((item, key) => (<Hotel key={key} hotel={item} />))}
                </div>
            </div>
        );
    }
}

export default MainPage;