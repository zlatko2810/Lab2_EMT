import axios from "../custom-axios/axios";

const BookService = {

    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchBook: (id) => {
        return axios.get(`/books/${id}`)
    },

    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },

    deleteBook: (id) => {
        return axios.delete(`/books/${id}`)
    },


    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    }

}

export default BookService