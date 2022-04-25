
import './App.css';
import React from 'react';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import BookService from './service/BookService';
import CountryService from "./service/CountryService";
import AuthorService from "./service/AuthorService";
import Header from "./components/Header/Header";
import 'bootstrap/dist/css/bootstrap.min.css';
import Book from "./components/Book/book";
import BookAdd from "./components/Book/bookAdd";
import Country from "./components/Country/country";
import Author from "./components/Author/author";
import BookEdit from "./components/Book/bookEdit";

class App extends React.Component{

  constructor(props) {
    super(props);
    this.state = {
      countries: [],
      authors: [],
      books: [],
      bookById: {}
    }
  }

  componentDidMount() {
    this.loadBooks()
    this.loadCountries()
    this.loadAuthors()
  }

  componentDidUpdate(prevProps, prevState, snapshot) {

  }

  render() {
    return (
        <Router>
            <Header/>
            <div className="App">
                <Route path={"/"} exact render={() =>
                    <Book books={this.state.books}
                          onDelete={this.deleteBook} onRent={this.rentBook}
                          onReturn={this.returnBook}
                          getBook={this.getBook}
                    />}/>
                <Route path={"/books"} exact render={() =>
                    <Book books={this.state.books}
                          onDelete={this.deleteBook} onRent={this.rentBook}
                          onReturn={this.returnBook}
                          getBook={this.getBook}
                    />}/>
                <Route path={"/books/add"} exact render={() =>
                    <BookAdd
                        countries={this.state.countries}
                        authors={this.state.authors}
                        onAddBook={this.addBook}/>}/>

                <Route path={"/books/edit/:id"} exact render={() =>
                    <BookEdit
                        countries={this.state.countries}
                        authors={this.state.authors}
                        book={this.state.bookById}
                        onEditBook={this.editBook}
                    />}
                />

                <Route path={"/countries"} exact render={() =>
                    <Country countries={this.state.countries}/>}/>
                <Route path={"/authors"} exact render={() =>
                    <Author authors={this.state.authors}/>}/>

            </div>
        </Router>
    );
  }

  loadBooks = () => {
    BookService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        })
  }
  loadCountries = () => {
    CountryService.fetchBooks()
        .then((data) => {
          this.setState({
            countries: data.data
          })
        })
  }
  loadAuthors = () => {
    AuthorService.fetchBooks()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        })
  }

  deleteBook = (id) => {
      BookService.deleteBook(id)
          .then(() => {
              this.loadBooks()
          });
  }

  addBook = (name, category, author_id, available_copies) => {
      BookService.addBook(name, category, author_id, available_copies)
          .then(() => {
              this.loadBooks();
          });
  }

  getBook = (id) => {
      BookService.fetchBook(id)
          .then((data) => {
              this.setState({
                  bookById: data.data
              })
          })
  }

  editBook = (id, name, category, author_id, available_copies) => {
      console.log(id, name, category, author_id, available_copies)

      BookService.editBook(id, name, category, author_id, available_copies)
          .then(() => {
              this.loadBooks();
          });
  }

  rentBook = (id, name, category, author_id, available_copies) => {
      BookService.editBook(id, name, category, author_id, available_copies-1)
          .then(() => {
              this.loadBooks();
          });
  }

  returnBook = (id, name, category, author_id, available_copies) => {
      BookService.editBook(id, name, category, author_id, available_copies+1)
          .then(() => {
              this.loadBooks();
          });
  }

}

export default App;
