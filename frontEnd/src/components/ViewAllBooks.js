import { Component } from 'react';
import axios from 'axios';
import { backendUrlDeleteBook, backendUrlViewBook } from '../BackendURL';
import { Redirect } from 'react-router-dom';

export class ViewAllBooks extends Component {

    constructor(props) {
        super(props);
        this.state = {
            successMessage: "",
            errorMessage: "",
            bookings: {},
            bookLogged: true,
            bookDelete: false,
            bookingId:0
        }
        this.res = []
    }

    delete=(id)=>{
        //Implement this function to delete the booking.
    }

    componentDidMount() {
        if (sessionStorage.getItem("userId") == null) {
            return this.setState({ bookLogged: false })
        }
        let url = backendUrlViewBook + sessionStorage.getItem("userId")
        console.log(sessionStorage.getItem("userId"))
        axios.get(url).then(response => {
            this.setState({ bookings: response.data })
        })
            .catch(error => {
                if (error.response) {
                    this.setState({ errorMessage: error.response.data.errorMessage });
                    console.log(error.response.data)
                } else {
                    this.setState({ errorMessage: "Please run the backend" })
                }
            })
    }

    cardMaker = (book) => {
        //Implement the logic to create a card with booking details and cancel booking button
    }

    render() {
        if (this.state.bookLogged === false) {
            alert("Please Login to view your plans")
            return <Redirect to={"/"}></Redirect>
        } if (this.state.errorMessage !== "") {
            return <h3>{this.state.errorMessage}</h3>
        }
    }
    //Write the remaining logic
}