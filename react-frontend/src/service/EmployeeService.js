import axios from 'axios';


const EMPLOYEE_SERVICE_BASE_URL = 'http://localhost:9191/api/employees'
const EMPLOYEE_ID = 1;
class EmployeeService {

    getEmployeeById() {
      return  axios.get(EMPLOYEE_SERVICE_BASE_URL+'/'+ EMPLOYEE_ID)
    }
}

export default  new EmployeeService