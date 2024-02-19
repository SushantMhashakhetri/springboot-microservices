import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {


constructor(props) {
    super(props);
    this.state = {

        employee: {},
        department: {},
        organization: {}

    }
}

componentDidMount() {
    EmployeeService.getEmployeeById().then((response)=>{
        if(response && response.data) {
            this.setState({employee: response.data.employee});
            this.setState({department: response.data.department});
            this.setState({organization: response.data.organizationDto});

            console.log(this.state)
        }
    })
}







    render() {
        return (
            <div>

                <br/>
                <div className='card col-md-6 offset-md-3'>

               <h3 className='card-header text-center'> Employee Details</h3>               
               <div className='card-header'>
                <div className='row'>
                    <p><strong>Employee First Name:</strong> {this.state.employee.firstName}</p>
                    <p><strong>Employee Last Name:</strong> {this.state.employee.lastName}</p>
                    <p><strong>Employee Email:</strong> {this.state.employee.email}</p>
                </div>
                </div>   

                </div>
                <br/>
                <div className='card col-md-6 offset-md-3'>

               <h3 className='card-header text-center'> Department Details</h3>               
               <div className='card-header'>
                <div className='row'>
                    <p><strong>Department code:</strong> {this.state.department.departmentCode}</p>
                    <p><strong>Department Name:</strong> {this.state.department.departmentName}</p>
                    <p><strong>Department Description:</strong> {this.state.department.departmentDescription}</p>
                </div>
                </div>   

                </div>
                <br/>
                <div className='card col-md-6 offset-md-3'>

               <h3 className='card-header text-center'> Organization Details</h3>               
               <div className='card-header'>
                <div className='row'>
                    <p><strong>Organization code:</strong> {this.state.organization.organizationCode}</p>
                    <p><strong>Organization Name:</strong> {this.state.organization.organizationName}</p>
                    <p><strong>Organization Description:</strong> {this.state.organization.organizationDescription}</p>
                </div>
                </div>   

                </div>
            </div>
        );
    }
}

export default EmployeeComponent;