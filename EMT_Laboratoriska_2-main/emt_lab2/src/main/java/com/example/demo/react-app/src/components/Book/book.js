import React from 'react'
import {Link} from "react-router-dom";
import ReactPaginate from "react-paginate"
import {render} from "@testing-library/react";

class Books extends React.Component{

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 5
        }
    }

    render()
    {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);
        return (
            <div>
                <table className={"table table-striped"} style={{width: 90 + '%', marginLeft: 5 + '%'}}>
                    <thead><h1>Books</h1></thead>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Author Name</th>
                        <th>Author Surname</th>
                        <th>Category</th>
                        <th>Available copies</th>
                        <th><Link to={"/books/add"}>
                            <button className={"btn btn-outline-primary"}>Add new book</button>
                        </Link></th>
                        <th><ReactPaginate previousLabel={"< "}
                                           nextLabel={"  >"}
                                           breakLabel={<a href="/#">...</a>}
                                           breakClassName={"break-me"}
                                           pageClassName={"ml-1"}
                                           pageCount={pageCount}
                                           marginPagesDisplayed={2}
                                           pageRangeDisplayed={5}
                                           onPageChange={this.handlePageClick}
                                           containerClassName={"pagination m-4 justify-content-center"}
                                           activeClassName={"active"}/></th>
                    </tr>
                    </thead>
                    <tbody>
                    {books}
                    </tbody>
                </table>
                <ReactPaginate previousLabel={"< "}
                               nextLabel={"  >"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>

            </div>
        )
    }
    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((book, index) => {
            return (
                <tr>
                    <td>{this.props.books.indexOf(book) + 1}</td>
                    <td>{book.name}</td>
                    <td>{book.author.name}</td>
                    <td>{book.author.surname}</td>
                    <td>{book.category}</td>
                    <td className={"text-primary"}>{book.availableCopies}</td>
                    <td><Link to={`/books/edit/${book.id}`}>
                        <button className={"btn btn-primary"} onClick={() => this.props.getBook(book.id)}>Edit</button>
                    </Link></td>
                    <td>
                        <button className={"btn btn-danger"} onClick={() => this.props.onDelete(book.id)}>Remove
                        </button>
                    </td>
                    {book.availableCopies > 0 ?
                        <td>
                            <button className={"btn btn-success"}
                                    onClick={() => this.props.onRent(book.id, book.name, book.category, book.author.id, book.availableCopies)}>Mark
                                as taken
                            </button>
                        </td>
                        :
                        <td>
                            <button className={"btn btn-light"} disabled={true}>Not available</button>
                        </td>
                    }
                    <td>
                        <button className={"btn btn-success"}
                                onClick={() => this.props.onReturn(book.id, book.name, book.category, book.author.id, book.availableCopies)}>Return
                            book
                        </button>
                    </td>
                </tr>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })


    }

}
export default Books