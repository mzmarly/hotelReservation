import React, { Component } from 'react';
import Data from "../../services/Data"
import history from "../../history"

class RegistrationInputs extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nameSurname: "",
            login: "",
            email: "",
            password: "",
        }
        this.change = this.change.bind(this)
        this.register = this.register.bind(this)
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    register() {
        if (this.state.email !== "" && this.state.password !== "" && this.state.email !== "" && this.state.nameSurname !== "") {
            Data.signUp(this.state).then(res => {
                history.push("/")
            }).catch(err => {
                this.setState({
                    nameSurname: "",
                    login: "",
                    email: "",
                    password: "",
                })
            })
        }
    }

    render() {
        return (
            <div className="registrationdiv">
                <span className="registrationspan" style={{ fontSize: "32.5px", fontWeight: "bold", color: "#2c3a41", fontFamily: "Arial" }}>Rejestracja</span>
                <div className="regdiv">
                    <span className="regpanel">Imie i nazwisko:</span>
                    <input className="reginput" type="text" name="nameSurname" value={this.state.nameSurname} onChange={this.change} placeholder="imie" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Login:</span>
                    <input className="reginput" type="text" name="login" value={this.state.login} onChange={this.change} placeholder="nazwisko" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">E-mail:</span>
                    <input className="reginput" type="text" name="email" value={this.state.email} onChange={this.change} placeholder="e-mail" />
                </div>
                <div className="regdiv">
                    <span className="regpanel">Hasło:</span>
                    <input className="reginput" type="password" name="password" value={this.state.password} onChange={this.change} placeholder="hasło" />
                </div>
                <div className="regdiv" style={{ marginTop: "0" }}>
                    <div className="registrationbuttons" onClick={this.register} style={{ width: "50%", marginTop: "2.5%" }}>Zarejestruj</div>
                </div>
            </div>
        );
    }
}

export default RegistrationInputs;