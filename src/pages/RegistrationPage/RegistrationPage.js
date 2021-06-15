import React, { Component } from 'react';
import RegistrationInputs from './RegistrationInputs';
import "../../css/registrationpage.css"

class RegistrationPage extends Component {
    render() {
        return (
            <div className="registrationpage">
                <RegistrationInputs />
            </div>
        );
    }
}

export default RegistrationPage;