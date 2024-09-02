import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import { Book } from "../models";
import * as bookService from "../service";
import { getLocation } from "../service";

function BookDetailsPage() {
  const bookDefault = new Book("", "", "", "", "", false, "", "", "", "");
  const { id } = useParams();
  const [book, setBook] = useState(bookDefault);
  const [formattedAddress, setFormattedAddress] = useState("");

  useEffect(() => {
    async function getUserBook() {
      const response = await bookService.getBook(id || "");
      if (response !== null) {
        setBook(response);
      }
    }
    getUserBook();
  }, [id]);

  useEffect(() => {
    async function setLocationReadable() {
      const location = await getLocation(book.zipcode);
      setFormattedAddress(location);
    }

    if (book.zipcode !== "") {
      setLocationReadable();
    }
  }, [book]);

  return (
    <main className="container mx-auto">
      <div className="flex flex-col md:flex-row gap-y-3 gap-x-3 justify-around mt-8">
        <div className="w-screen px-5 md:px-0 md:w-[40%] ">
          <img
            src={
              book.image === ""
                ? "https://img.freepik.com/free-vector/hand-drawn-flat-design-stack-books-illustration_23-2149330605.jpg"
                : book.image
            }
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

            <p className=" mt-6 text-slate-500">Author: {book.author}</p>
            <p className=" text-slate-500">Genre: {book.genre}</p>
            <p className=" text-slate-500">Posted By: {book.ownerUserId}</p>
            <p className=" text-slate-500">Location: {formattedAddress}</p>
            <p className="text-slate-500">
              Date Posted: {book.dateCreated.toDateString()}
            </p>
            <p className="text-md mt-8 text-slate-500">{book.description}</p>

            <div className="flex flex-row items-center w-full justify-center md:justify-normal gap-x-5 md:w-[40%] mt-8">
              <Link to={`/request/create/${book.bookId}`}>
              <button 
              className="rounded-lg px-4 py-2 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">
                Request
              </button></Link>
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
