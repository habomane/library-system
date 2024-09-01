
import { Link } from "react-router-dom";
import { useEffect, useState, useContext } from "react";
import * as bookService from '../service'


// Components
import BookListItem from "../utilities/items/BookListItem";
// import BookFavoriteItem from "../utilities/items/BookFavoriteItem";
import { UserContext } from "../App";

function LibraryPage()
{
    const context = useContext(UserContext);
    const [userOwnedBooks, setUserOwnedBooks] = useState([]);

    if(!context)
        {
          return null;
        }
    
    const [user] = context;

    useEffect(() => {
    async function getUserOwnedBooks() {
        const response = await bookService.getAllBooksUser(user.userId);
        setUserOwnedBooks(response);
    }
    if(user.userId !== "") {getUserOwnedBooks();}
    }, [user.userId])

    return (
        <main className="container mx-auto">
            <h1 className="mt-5 text-3xl font-bold">My <span className="text-green-700">Library</span></h1>

            <div className="mt-8 gap-x-3">
            <Link to="/create">
            <button className="rounded-lg px-4 py-2 bg-green-300 font-medium hover:bg-green-700 hover:text-white duration-300">Create +</button>
            </Link>
            </div>
            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">My <span className="text-green-700">Items</span></h2>
                <div className="border-t w-full mt-2 flex flex-col gap-y-3 mb-2">
                    {
                        userOwnedBooks.map((book, key) => {
                            return <BookListItem book={book} key={key}></BookListItem>
                        })
                    }
                </div>
            </div>

            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">My <span className="text-green-700">Favorites</span></h2>
                <div className="border-t w-full mt-2">

                </div>
            </div>
        </main>
    )
}

export default LibraryPage;