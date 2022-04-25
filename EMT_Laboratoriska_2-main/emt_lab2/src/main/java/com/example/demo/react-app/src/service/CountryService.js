import axios from "../custom-axios/axios";

const CountryService = {

    fetchBooks: () => {
        return axios.get("/countries");
    }

}

export default CountryService