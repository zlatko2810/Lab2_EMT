import axios from "../custom-axios/axios";

const AuthorService = {

    fetchBooks: () => {
        return axios.get("/authors");
    }

}

export default AuthorService