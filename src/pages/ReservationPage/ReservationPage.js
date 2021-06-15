import React, { Component } from 'react';
import Data from "../../services/Data"
import history from "../../history"

class ReservationPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            room: "2",
            avgNote: 0,
            opinions: [],
            note: "0",
            comment: "",
            checkin: "",
            checkout: "",
        }
        this.change = this.change.bind(this)
        this.addReview = this.addReview.bind(this)
        this.reserve = this.reserve.bind(this)
    }

    componentDidMount() {
        Data.getAvgNote(this.props.location.state.hotel.hotelId).then(res => {
            this.setState({
                avgNote: res.data.toFixed(2)
            })
        })
        Data.getOpinions(this.props.location.state.hotel.hotelId).then(res => {
            console.log(res.data)
            this.setState({
                opinions: res.data
            })
        })
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value,
        })
    }



    reserve() {
        let data = {
            id: this.props.location.state.hotel.hotelId,
            in: this.state.checkin,
            out: this.state.checkout,
            a: this.state.room
        }

        Data.freeRoom(data).then(res => {
            if (res.data === -1) {
                alert("No rooms available")
            } else {
                Data.roomInfo(res.data).then(res => {
                    history.push({
                        pathname: '/roominfo',
                        state: { room: res.data, in: data.in, out: data.out,id:this.props.location.state.hotel.hotelId }
                    })
                })

            }
        })
    }

    addReview() {
        let data = {
            id: this.props.location.state.hotel.hotelId,
            note: this.state.note,
            comment: this.state.comment
        }
        Data.addReview(data).then(res => {
            this.setState({
                note: "0",
                comment: ""
            })
        })
    }

    render() {
        return (
            <div style={{ display: "flex", flexDirection: "column", alignItems: "center", marginTop: "3%" }}>
                <div style={{ width: "100%", display: "flex", alignItems: "center", justifyContent: "space-evenly", marginBottom: "7.5%", }}>
                    <img style={{ border: "solid black 3px" }} src={this.props.location.state.hotel.url} alt="error" width="200" height="200"></img>
                    <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>{this.props.location.state.hotel.stars}/5 stars</span>
                        <span style={{ fontFamily: "Arial", fontSize: "20px", marginBottom: "10%" }}>Street - {this.props.location.state.hotel.street}</span>
                        <span style={{ marginBottom: "10%", fontFamily: "Arial", fontSize: "20px" }}>Average note: {this.state.avgNote}</span>
                    </div>
                </div>

                <div style={{ width: "100%", display: "flex", height: "35px", alignItems: "flex-start", flexDirection: "column", marginLeft: "25%" }}>
                    <div style={{ width: "100%", marginBottom: "1%" }}>
                        <span style={{ fontFamily: "Arial", fontSize: "20px", marginRight: "6.5%" }}>Room size:</span>
                        <select style={{ height: "35px", fontFamily: "Arial", fontSize: "15px", }} name="room" onChange={this.change}>
                            <option>2</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div style={{ width: "100%", marginBottom: "1%" }}>
                        <span style={{ fontFamily: "Arial", fontSize: "20px", marginRight: "5.09%" }}>Check-in date:</span>
                        <input type="date" name="checkin" onChange={this.change}></input>
                    </div>
                    <div style={{ width: "100%", marginBottom: "1%" }}>
                        <span style={{ fontFamily: "Arial", fontSize: "20px", marginRight: "4.5%" }}>Check-out date:</span>
                        <input type="date" name="checkout" onChange={this.change}></input>
                    </div>
                    <div onClick={this.reserve} style={{ marginLeft: "6.8%", fontFamily: "Arial", fontSize: "20px", border: "solid 1px black", padding: "0.25%", cursor: "pointer", backgroundColor: "grey" }}>Reserve</div>
                </div>

                <div style={{ display: "flex", width: "30%", alignItems: "center", justifyContent: "space-around", marginLeft: "15%" }}>
                    <select style={{ height: "35px", fontFamily: "Arial", fontSize: "15px", }} name="note" onChange={this.change}>
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                    <textarea onChange={this.change} name="comment" rows="3" cols="50" value={this.state.comment}>{this.state.comment}</textarea>
                    <div onClick={this.addReview} style={{ fontFamily: "Arial", fontSize: "20px", border: "solid 1px black", padding: "0.25%", cursor: "pointer", backgroundColor: "grey" }}>Add review</div>
                </div>

                <div style={{ display: "flex", width: "30%", alignItems: "center", flexDirection: "column", justifyContent: "space-around", marginLeft: "15%", marginTop: "1.5%" }}>
                    {this.state.opinions.map((item, key) => (<span key={key} style={{ height: "35px", fontFamily: "Arial", fontSize: "20px", }}>{item.value}/10{" - "}{item.comment}</span>))}
                </div>
            </div>
        );
    }
}

export default ReservationPage;