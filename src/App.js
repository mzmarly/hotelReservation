import React, { Component } from 'react';
import { Route, Switch} from "react-router-dom"
import LoginPage from './pages/LoginPage/LoginPage';
import MainPage from './pages/MainPage/MainPage';
import MyReservations from './pages/MainPage/MyReservations';
import RegistrationPage from './pages/RegistrationPage/RegistrationPage';
import ReservationPage from './pages/ReservationPage/ReservationPage';
import RoomInfo from './pages/ReservationPage/RoomInfo';



class App extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={LoginPage} />
                <Route exact path="/registration" component={RegistrationPage} />
                <Route exact path="/mainpage" component={MainPage} />
                <Route exact path="/mainPage" component={MainPage} />
                <Route exact path="/reserve" component={ReservationPage} />
                <Route exact path="/roominfo" component={RoomInfo} />
                <Route exact path="/myreservations" component={MyReservations} />
            </Switch>
        );
    }
}

export default App