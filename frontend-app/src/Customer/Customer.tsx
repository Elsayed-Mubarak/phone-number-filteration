import React ,{Component} from "react";
import { ICustomer } from "./ICustomer";

interface IProps {
    customer: ICustomer;
}

class Customer extends Component<IProps> {

    render() {
        var customer = this.props.customer;

        return (
            <tbody>
                <tr className="table-row">
                    <td>{customer.id}</td>
                    <td>{customer.name}</td>
                    <td>{customer.countryName}</td>
                    <td>{customer.code}</td>
                    <td>{customer.number}</td>
                    <td>{((customer.state) ? "Valid" : "Not Valid")}</td>
                </tr>
            </tbody>
        );
    }
}

export default Customer;