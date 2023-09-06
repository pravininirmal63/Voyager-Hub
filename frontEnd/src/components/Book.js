import { Component } from 'react';
import axios from 'axios';
import { backendUrlItinerary, backendUrlBook } from '../BackendURL';
import "../custom.css";
import { Redirect } from 'react-router-dom';

export class Book extends Component {

    constructor(props) {
        super(props);
        this.state = {
            booking: [],
            destination: [],
            highlights: [],
            details: [],
            itinerary: [],
            formValue: {
                noOfPeople: "",
                checkIn: "",
                totalCost: "",
                user: {
                    "userId": sessionStorage.getItem("userId"),
                    "userName": sessionStorage.getItem("userName")

                }
            },
            formErrorMessages: {
                noOfPeople: "",
                checkIn: ""
            },
            formValid: {
                noOfPeople: false,
                checkIn: false,
                buttonActive: false
            },
            errorMessage: "",
            successMessage: "",
            totalCost: "",
            tripEnd: "",
            displayDate: "",
            flightCharge: 0,
            back: false,
            accords: {
                accordButton1: false,
                accordButton2: false,
                accordButton3: false
            }
        }
        console.log(sessionStorage);
       
    }

    componentDidMount() {
       //Write logic for fetching itinerary details from the backend.
    }

    setTripEnd = (date) => {
      //Implement this function to calculate the trip end date with the help of No. of nights

    }

    totalAmount = (name, value) => {
       //Implement this function the total amount for the booking
    }

    handleChange = (event) => {
        var name = event.target.name;
        var value = event.target.value;
        var formVal = this.state.formValue;
        this.setState({ formValue: { ...formVal, [name]: value } })
        this.validateField(name, value)
        this.totalAmount(name, value)
    }

    validateField = (fieldName, value) => {
     //Implement this function to validate the booking fields
        
    }

    handleSubmit = (event) => {
        event.preventDefault()
        this.submitBooking();

    }
    submitBooking = () => {
       //IAdd the logic to submit the booking to backend
    }

    

    closeAccord = (event) => {
        Object.keys(this.state.accords).map(k => {
            if (this.state.accords[k] === true) {
                let accordKey = this.state.accords;
                accordKey[k] = false;
                this.setState({ accords: accordKey })
            } else if (event.target.id === k) {
                let accordKey = this.state.accords;
                accordKey[k] = true;
                this.setState({ accords: accordKey })
            } else {
                let accordKey = this.state.accords;
                accordKey[k] = false;
                this.setState({ accords: accordKey })
            }
        })
    }
    render() {
        //Add the missing logic to complete the view
        return (
            <>
                <span className="text-success font-weight-bold">{this.state.successMessage}</span>
                <div className="row px- 2 py-3">
                    <div className="col-lg-6 col-md-5 col-sm-12">
                        <h3>{this.state.destination.destinationName}</h3>
                        <div className="card">
                            <div className="card-header">
                                <div className="d-flex justify-content-between">
                                    <span id="accord">Overview</span>
                                    <span id="accordButton1" className="close" style={{ transform: this.state.accords.accordButton1 ? "rotate(135deg)" : "rotate(90deg)" }} onClick={this.closeAccord}>+</span>
                                </div>
                            </div>
                        </div>
                        <div className="hiddenBox" style={{ display: this.state.accords.accordButton1 ? "block" : "none" }}>
                            <p>{this.state.details.about}</p>
                        </div>
                        <div className="card">
                            <div className="card-header">
                                <div className="d-flex justify-content-between">
                                    <span id="accord">Highlights</span>
                                    <span id="accordButton2" className="close" style={{ transform: this.state.accords.accordButton2 ? "rotate(135deg)" : "rotate(90deg)" }} onClick={this.closeAccord}>+</span>
                                </div>
                            </div>
                        </div>
                        <div className="hiddenBox" style={{ display: this.state.accords.accordButton2 ? "block" : "none" }}>
                            <p>{this.state.highlights.toString().split(",").map(h => <li key={h}>{h}</li>)}</p>
                        </div>
                        <div className="card">
                            <div className="card-header">
                                <div className="d-flex justify-content-between">
                                    <span id="accord">Tour Pace</span>
                                    <span id="accordButton3" className="close" style={{ transform: this.state.accords.accordButton3 ? "rotate(135deg)" : "rotate(90deg)" }} onClick={this.closeAccord}>+</span>
                                </div>
                            </div>
                        </div>
                        <div className="hiddenBox" style={{ display: this.state.accords.accordButton3 ? "block" : "none" }}>
                            <span>1: {this.state.itinerary.firstDay}</span><br /><br />
                            <span>2: {this.state.itinerary.restOfDays}</span><br /><br />
                            <span>3: {this.state.itinerary.lastDay}</span><br /><br />
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-7 col-sm-12">
                        <div className="card">
                            <div className="card-header">
                                <h4 className="text-center font-weight-bold text warning">Book Your Trip</h4>
                            </div>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label className="font-weight-bold d-flex justify-content-start">Number of Travellers</label>
                                    </div>
                                    <div className="form-group">
                                        <label className="font-weight-bold d-flex justify-content-start">Trip Start Date</label>
                                    </div>
                                   
                                </form>
                                <span className="font-weight-bold">Your Trip Ends on: {this.state.displayDate}</span><br /><br />
                                <h5>You Pay: ${this.state.totalCost}</h5>
                            </div>
                            <div className="card-footer d-flex justify-content-between">
                                <button type="submit" name="book" >CONFIRM BOOKING</button>
                                <button name="goBack" >GO BACK</button>
                            </div>
                        </div>
                    </div>
                </div>
            </>
        )
    }


}
