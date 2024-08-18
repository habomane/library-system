import { allBooksMock } from "../mock";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Book } from "../models";
import { findBook } from "../helper";
import { getLocation } from "../service";

function BookDetailsPage() {
  const bookDefault = new Book(0, "", "", "", "", false, "", "", "");
  const { id } = useParams();
  const [book, setBook] = useState(bookDefault);
  const [formattedAddress, setFormattedAddress] = useState("");

  useEffect(() => {
    const book = findBook(parseInt(id || "0"), allBooksMock) || bookDefault;

    setBook(book);

    async function setLocationReadable() {
      const location = await getLocation(book.zipcode);
      setFormattedAddress(location);
    }

    setLocationReadable();
  }, [id]);

  return (
    <main className="container mx-auto">
      <div className="flex flex-col md:flex-row gap-y-3 gap-x-3 justify-around mt-8">
        <div className="w-screen px-5 md:px-0 md:w-[40%] ">
          <img
            src={book.image}
            alt={book.title + " book cover."}
            className="w-screen h-[70vh]"
          />
        </div>
        <div className="w-full bg-white rounded-lg shadow-xl ">
          <div className="py-12 md:py-0 px-5 md:pl-10">
            <h1 className="text-3xl font-bold tracking-widest">{book.title}</h1>
            <div className="flex flex-row mt-2 gap-x-2 items-center ">
              <div
                className={`h-5 w-5 ${
                  book.available === true ? "bg-green-500" : "bg-red-500"
                } rounded-xl`}
              ></div>
              <p className="text-md font-medium">
                {book.available === true ? "Available" : "Not Available"}
              </p>
            </div>

            <p className="text-lg mt-8 text-slate-500">Author: {book.author}</p>
            <p className="text-lg text-slate-500">Genre: {book.genre}</p>
            <p className="text-lg text-slate-500">
              Posted By: {book.ownerUserName}
            </p>
            <p className="text-lg text-slate-500">
              Location: {formattedAddress}
            </p>
            <p className="text-md mt-10 text-slate-500">
              {book.description} Lorem ipsum dolor sit amet, consectetur
              adipiscing elit, sed do eiusmod tempor incididunt ut labore et
              dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
              exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate
              velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
              occaecat cupidatat non proident, sunt in culpa qui officia
              deserunt mollit anim id est laborum.
            </p>

            <div className="flex flex-row items-center w-full justify-center md:justify-normal gap-x-5 md:w-[40%] mt-10">
              <button className="rounded-lg px-4 py-2 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">
                Request
              </button>
              <button className="rounded-lg px-4 py-2 font-medium bg-yellow-500 hover:bg-yellow-800 hover:text-white duration-300">
                Favorite
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
}

export default BookDetailsPage;
