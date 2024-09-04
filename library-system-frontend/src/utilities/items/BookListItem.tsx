import { Book } from "../../models";
import { Link, useNavigate } from "react-router-dom";
import * as bookService from '../../service'

function BookListItem({ book }: { book: Book }) {
  const navigate = useNavigate();
  async function deleteBook()
  {
    const oldBookName = book.title;
    const response = await bookService.deleteBook(book.bookId);
    if(response !== null)
    {
      alert(`Title ${oldBookName} has been deleted.`)
      navigate('/discover');
    }
    else 
    {
      alert("Error, something went wrong.")
    }
  }
  return (
    <div className="w-full">
      <div className="bg-white rounded-lg shadow-lg">
        <div className="p-4">
            <div className="flex flex-row justify-between items-center mb-2">
            <h2 className="font-bold text-xl">
            {book.title}
          </h2>
          <p className=" text-green-700 font-sm font-medium">
          {book.genre}
          </p>
            </div>
 
            <div className="flex flex-row justify-between items-center">
            <p className="">
          {book.author}
          </p>

          <div className="flex flex-row gap-x-4">
          <Link to={`/details/${book.bookId}`}>
          <button className="rounded-lg px-2 md:px-4 py-1 font-medium bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">Details</button>
        </Link>
          <Link to={`/edit/${book.bookId}`}>
          <button className="rounded-lg  px-2 md:px-4  py-1 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">Edit</button>

          </Link>

          <button 
          onClick={deleteBook}
          className="rounded-lg  px-2 md:px-4  py-1 font-medium bg-red-500 hover:bg-red-800 hover:text-white duration-300">Delete</button>

          </div>
            </div>




        </div>
      </div>
    </div>
  );
}
export default BookListItem;
