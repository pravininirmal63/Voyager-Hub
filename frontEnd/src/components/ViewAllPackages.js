import React, { Component } from "react";
import axios from "axios";
// import { backendUrlHotDeal } from "react";
import { Redirect, Route } from "react-router-dom";
import { backendUrlHotDeal } from "../BackendURL";
import ItineraryViewer from "./ItineraryViewer";


export class ViewAllPackages extends Component {

    constructor(props) {
        super(props)
        this.state = {
            destinations: [],
            itineraryButton: false,
            bookButton: false,
            errorMessage: "",
            itinerary: [],
            destForPackage: "",
            destForBook: "",
            bookme: false,
        }
    }
    componentDidMount() {
        //Write logic to fetch the hotdeal data from the backend
    }


    render() {
        //Write logic to display package details
        return null
    }

}
export default ViewAllPackages;