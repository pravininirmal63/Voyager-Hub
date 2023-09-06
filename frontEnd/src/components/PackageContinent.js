import {Component} from 'react';
import Axios from 'axios';
import { backendUrlHotDeal, backendUrlPackageSearch } from '../BackendURL';
import { ItineraryViewer } from './ItineraryViewer';
import { Redirect } from 'react-router-dom';

export class PackageContinent extends Component {
    constructor(props){
        super(props);
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
    componentDidMount(){
        //Implement this function to fetch package details by continent from the backend
    }

    render(){
     return null
        //Write the logic to display the packages searched by continent
    }
}