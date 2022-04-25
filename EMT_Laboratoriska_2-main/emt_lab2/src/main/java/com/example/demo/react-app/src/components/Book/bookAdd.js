import React from 'react';
import {useHistory} from 'react-router-dom';

const BookAdd = (props) => {

    const categories = ['NOVEL','THRILER', 'HISTORY', 'FANTASY', 'BIOGRAPHY', 'CLASSICS', 'DRAMA']

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        category: "NOVEL",
        author: 1,
        availableCopies:0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const category = formData.category;
        const author = formData.author;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name, category, author, availableCopies);
        history.push("/books");
    }

    return(
        <div className="row mt-5" style={{marginLeft:40 + '%'}}>
            <div className="col-md-5" style={{border: 1 + 'px solid green'}}>
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="category">Book category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {
                                categories.map((category) =>
                                    <option value={category}>{category}</option>
                                )
                            }
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {
                                props.authors.map((author) =>
                                    <option value={author.id}>{author.name} {author.surname}</option>
                                )
                            }
                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="availableCopies">Book category</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="Available copies"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <button id="submit" type="submit" className="btn btn-success">Submit</button>
                </form>
                <h1></h1>
            </div>
        </div>
    )
}

export default BookAdd;
