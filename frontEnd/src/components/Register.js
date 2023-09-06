import React from "react";
import { InputText } from "primereact/inputtext";
import { Message } from "primereact/message";
import Axios from "axios";
import { backendUrlRegister } from "../BackendURL";

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      formValue: {
        userName: "",
        emailId: "",
        password: "",
        contactNumber: ""
      },
      formErrorMessage: {
        userName: "",
        emailId: "",
        password: "",
        contactNumber: ""
      },
      formValid: {
        userName: false,
        emailId: false,
        password: false,
        contactNumber: false,
        buttonActive: false
      },
      successMessage: "",
      errorMessage: ""
    }
  }

  handleChange = (event) => {
    var name = event.target.name
    var value = event.target.value
    var formVal2 = this.state.formValue
    this.setState({ formValue: { ...formVal2, [name]: value } })
    this.validate(name, value)
  }

  validate = (fieldName, value) => {    
     //Implement this function to validate the form fields
  }

  handleSubmit = (event) => {
    event.preventDefault()
    this.register()
  }

  register = () => {  
    //Implement this function to send the form data to the backend
  }

  render() {
    //Implement this function to create a registration form
    return null
  }
}

export default Register;
