import React, { Component } from 'react';
import Data from "../../services/Data"
import history from '../../history'
import "../../css/loginpage.css"

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login: "",
            password: "",
        }
        this.change = this.change.bind(this)
        this.sendData = this.sendData.bind(this)
        this.goToRegister = this.goToRegister.bind(this)
        this.signInByGoogle = this.signInByGoogle.bind(this)
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value,
        })
    }

    sendData(e) {
        e.preventDefault()

        let data = {
            usernameOrEmail: this.state.login,
            password: this.state.password
        }

        Data.signIn(data).then(res => {
            sessionStorage.setItem('login', data.usernameOrEmail)
            history.push("/mainpage")
        }).catch(err => {
            this.setState({
                login: "",
                password: ""
            })
        })
    }

    goToRegister() {
        history.push("/registration")
    }

    signInByGoogle() {
        Data.test().then(res=>{
            sessionStorage.setItem('login', "Bandaj")
            history.push("/mainPage")
        })    
    }

    render() {
        return (
            <div className="logindiv">
                <form onSubmit={this.sendData} className="loginBox">
                    <span style={{ marginRight: "auto", fontSize: "35px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial", paddingLeft: "40px", marginBottom: "25px" }}>Sign in </span>
                    <input onChange={this.change} name="login" value={this.state.login} style={{ marginBottom: "15px", width: "50%", height: "15%", }} placeholder="login" type="text" />
                    <input onChange={this.change} name="password" value={this.state.password} style={{ marginBottom: "25px", width: "50%", height: "15%", }} type="password" placeholder="password" />
                    <button type="submit" className="loginButton">Log in</button>
                </form>
                <div className="loginButton" onClick={this.goToRegister} style={{ height: "1%", marginTop: "-16px", backgroundColor: "white", color: "black", fontSize: "10pxS" }}>Create account</div>
                <div className="loginButton" onClick={event =>  window.location.href='http://localhost:8080/oauth2/authorization/google'} style={{ height: "1%", marginTop: "-25px", backgroundColor: "white", color: "black", fontSize: "10pxS" }}>Log in by Google</div>
            </div>
        );
    }
}

export default LoginPage;