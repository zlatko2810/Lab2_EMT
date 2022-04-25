import React from 'react'
import CountryService from "../../service/CountryService";

const country = (props) => {

    return (
        <div>
            <table className={"table table-striped"} style={{width: 80 + '%', marginLeft: 10 + '%'}}>
                <thead><h1>Countries</h1></thead>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Continent</th>
                </tr>
                </thead>
                <tbody>
                {props.countries.map(country =>
                    <tr>
                        <td>{props.countries.indexOf(country) + 1}</td>
                        <td>{country.name}</td>
                        <td>{country.continent}</td>
                    </tr>
                )}
                </tbody>
            </table>
        </div>
    )

}
export default country