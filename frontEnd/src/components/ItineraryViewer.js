import React, { Component } from "react";
import '../index.css';
import { Route, Redirect } from "react-router-dom";

export class ItineraryViewer extends Component {

    constructor(props){
        super(props)
        this.state = {
            destination : null,
            highlights:[],
            inclusions: [],
            pace: [],
            bookme: false,
        }
    }

    componentDidMount(){
        //Write logic for fetching data of highlights, packageInclusion and pace from the backend.
        
    }
    book=()=>{
        this.setState({bookme:true});
    }

    render(){
        return (
            <React.Fragment>
                <div className="modal" style={{ display: (this.props.show) ? "block" : "none" , overflow: "scroll"}}>
                    <div className="modal-dialog modal-lg">
                        <div className="modal-content" >
                            <div className= "modal-header">
                                <h4>Itinerary</h4>
                                <span className="close" onClick={this.props.onHide}>&times;</span>
                            </div>
                            <div className="modal-body" >
                                <h5>Tour Highlights</h5>
                            
                                <h5>Package Inclusions</h5>
                                
                                <h5> Tour Pace </h5>
                                
                            </div>
                            <div className="modal-footer">
                                <button onClick={this.props.onHide}>Cancel</button>
                                <button>Book</button>
                            </div>
                        </div>
                    </div>
                </div>


            </React.Fragment>

        )
    }


}
export default ItineraryViewer;