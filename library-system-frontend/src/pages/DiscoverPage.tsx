
import { useState, useEffect } from "react";
import { Book } from "../models";
import { queryBooks } from "../helper";
import * as bookService from '../service'

// Components 
import BookCard from "../utilities/items/BookCard";
import SearchBar from "../utilities/search/SearchBar";

function DiscoverPage()
{
    const blankBooks: Book[] =[]
    const [allBooksGeneral, setAllBooksGeneral] = useState(blankBooks);
    const [allBooks, setAllBooks] = useState(blankBooks);
    const [query, setQuery] = useState("");

    useEffect(() => {
       async function getAllBooks() {
        const response = await bookService.getAllBooks();
        if(response !== null) {
            setAllBooksGeneral(response);
            setAllBooks(response);
        }
       }

       getAllBooks();
    }, [])

    useEffect(() => {
        if(query === "") { setAllBooks(allBooksGeneral)}
        else 
        {
            const filteredBooks = queryBooks(query, allBooksGeneral);
            setAllBooks(filteredBooks);
        }
    }, [query])

    return (
        <main className="container  mx-auto">
            <SearchBar setQuery={setQuery}></SearchBar>
            <div className={allBooks.length === 0 ? "hidden" : ""}>

            <div className="flex flex-wrap justify-center items-center gap-y-5 gap-x-5 py-5">
                {
                    allBooks.map((book, index) => {
                        return <BookCard key={index} book={book} />
                    })
                }
            </div>
            </div>

            <div className={allBooks.length === 0 ? "flex justify-center flex-col h-[80%] gap-y-2 items-center" : "hidden"}>
                <h1 className="text-2xl font-bold">No Items Found</h1>
                <p className="text-md font-medium text-gray-500">Please Try Again</p>
            </div>

        </main>
    )
}

export default DiscoverPage;