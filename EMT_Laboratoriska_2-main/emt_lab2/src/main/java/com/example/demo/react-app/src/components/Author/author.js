import React from 'react'

const author = (props) => {

    return (
        <div>
            <table className={"table table-striped"} style={{width: 80 + '%', marginLeft: 10 + '%'}}>
                <thead><h1>Authors</h1></thead>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Country name</th>
                    <th>Country continent</th>
                </tr>
                </thead>
                <tbody>
                {props.authors.map(author =>
                    <tr>
                        <td>{props.authors.indexOf(author) + 1}</td>
                        <td>{author.name}</td>
                        <td>{author.surname}</td>
                        <td>{author.country.name}</td>
                        <td>{author.country.continent}</td>
                    </tr>
                )}
                </tbody>
            </table>
        </div>
    )

}
export default author