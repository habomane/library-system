import { Link } from "react-router-dom";
import { useEffect, useState, useContext } from "react";
import * as bookService from "../service";

// Components
import BookListItem from "../utilities/items/BookListItem";
import BookFavoriteItem from "../utilities/items/BookFavoriteItem";
import { UserContext } from "../App";
import { Book } from "../models";

function LibraryPage() {
  const context = useContext(UserContext);
  const [userOwnedBooks, setUserOwnedBooks] = useState([]);
  const [userFavorites, setUserFavorites] = useState([]);
  const [userFavoriteBooks, setUserFavoriteBooks] = useState<Book[]>([]);

  if (!context) {
    return null;
  }

  const [user] = context;

  // eslint-disable-next-line react-hooks/rules-of-hooks
  useEffect(() => {
    async function getUserOwnedBooks() {
      const response = await bookService.getAllBooksUser(user.userId);
      setUserOwnedBooks(response);
    }

    async function getUserFavorites()
    {
        const response = await bookService.getFavoriteByUser(user.userId)
        setUserFavorites(response);
    }

    if (user.userId !== "") {
      getUserOwnedBooks();
      getUserFavorites();
    }

  }, [user.userId]);


  useEffect(() => {
    async function getUserFavoriteBooks()
    {
        const data = await bookService.getBookByFavorite(userFavorites);
        setUserFavoriteBooks(data);
    }
    if(userFavorites.length > 0) {getUserFavoriteBooks();}
    
  }, [userFavorites])

  return (
    <main className="container mx-auto">
      <h1 className="mt-5 text-3xl font-bold">
        My <span className="text-green-700">Library</span>
      </h1>

      <div className="mt-8 gap-x-3">
        <Link to="/create">
          <button className="rounded-lg px-4 py-2 bg-green-300 font-medium hover:bg-green-700 hover:text-white duration-300">
            Create +
          </button>
        </Link>
      </div>
      <div className="mt-10">
        <h2 className="text-2xl font-semibold ">
          My <span className="text-green-700">Items</span>
        </h2>
        <div className="border-t w-full mt-2 flex flex-col gap-y-3 mb-2">
          {userOwnedBooks.map((book, key) => {
            return <BookListItem book={book} key={key}></BookListItem>;
          })}
        </div>
      </div>

      <div className="mt-10">
        <h2 className="text-2xl font-semibold ">
          My <span className="text-green-700">Favorites</span>
        </h2>
        <div className="border-t w-full mt-2 flex flex-col gap-y-3 mb-2">
        { 
        userFavoriteBooks.map((book, key) => {
            return <BookFavoriteItem book={book} key={key}></BookFavoriteItem>;
          })}
        </div>
      </div>
    </main>
  );
}

export default LibraryPage;
