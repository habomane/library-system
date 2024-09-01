
import { useState, useEffect, useContext } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { BookRequest } from "../models";
import { BookGenre } from "../types";
import { UserContext } from "../App";
import * as bookService from '../service'
import * as helper from '../helper'


function CreateBook() {
  const navigate = useNavigate();
  const { id } = useParams();
  const context = useContext(UserContext);

  // book states
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [available, setAvailable] = useState(false);
  const [genre, setGenre] = useState("Fiction");
  const [zipcode, setZipcode] = useState("");
  const [description, setDescription] = useState("");
  const [image, setImage] = useState("");

  useEffect(() => {
  }, [id]);

  if(!context)
    {
      return null;
    }

  const [user] = context;

  const discard = () => 
    {
    alert("Modifications have been discarded.")
    navigate("/library");
  }

  async function createBook()
  {
    if(title === "" || author === "") { alert("Title and author are required."); return;}
    const transformedGenre = helper.transformGenreToRequestString(genre) || "";
    const newBook = new BookRequest(title, author, transformedGenre, image, available, zipcode, description, user.userId);
 
    const response = await bookService.createBook(newBook);
    if(response?.bookId !== null || response.bookId !== undefined) { 
      alert("Book has been created");
      setTitle("")
      setAuthor("")
      setZipcode("")
      setGenre("")
      setDescription("")
      setImage("")
      setAvailable(false)
    }
    else 
    {
      alert("Error, please try again later.")
    }
  }
  return (
    <main className="container mx-auto">
      <div className="flex flex-col gap-y-3 gap-x-3 items-center mt-8">
        <div className="w-full bg-white rounded-lg shadow-2xl ">
          <div className="py-12 px-5 md:pl-10">
            <div className="flex flex-row gap-x-2">
              <label className="text-3xl font-bold tracking-widest">
                Title:
              </label>
              <input
              value={title}
              onChange={(e) => setTitle(e.target.value)}
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-row mt-2 gap-x-2 items-center">
              <label className="text-md font-medium">Is Available: </label>
              <input
                checked={available}
                onChange={(e) => setAvailable(e.target.checked)}
                type="checkbox"
                className="border-gray-300 rounded-sm  h-6 w-6"
              />
            </div>

            <div className="flex flex-row gap-x-2 mt-8">
              <label className="text-lg text-slate-500">Author:</label>
              <input
              value={author}
              onChange={(e) => setAuthor(e.target.value)}
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-row gap-x-2 mt-2">
              <label className="text-lg text-slate-500">Genre:</label>
              <select
              value={genre}
              onChange={(e) => setGenre(e.target.value)}
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                              focus:border-green-700"
              >
                {
                  Object.values(BookGenre).map((item, key) => {
                    return <option key={key}>{item}</option>
                  })
                }
              </select>
            </div>

            <div className="flex flex-row gap-x-2 mt-2">
              <label className="text-lg text-slate-500">Zipcode:</label>
              <input
              value={zipcode}
              onChange={(e) => setZipcode(e.target.value)}
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                focus:border-green-700"
              />
            </div>

            <div className="flex flex-col gap-x-2 mt-10">
              <label className="text-lg text-slate-500">Description:</label>
              <textarea
              value={description}
              onChange={(e) => setDescription(e.target.value)}
                id="id-l03"
                name="id-l03"
                rows={3}
                placeholder="Write your message"
                className="peer relative w-full rounded border border-slate-300 p-4 text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-green-700 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
              ></textarea>
            </div>

            <div className="my-3 flex flex-row gap-x-2">
              <label className="text-lg text-slate-500">
                Attach Image URL:{" "}
              </label>
              <input
              value={image}
              onChange={(e) => setImage(e.target.value)}
                type="text"
                className="border text-slate-500 border-slate-400 rounded-sm focus:outline-none
                                focus:border-green-700"
              />
            </div>

            <div className="flex flex-row items-center w-full justify-center md:justify-normal gap-x-5 md:w-[40%] mt-10">
              <button 
              onClick={createBook}
              className="rounded-lg px-4 py-2 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">
                Save
              </button>
              <button
              onClick={discard}
               className="rounded-lg px-4 py-2 font-medium bg-red-500 hover:bg-red-800 hover:text-white duration-300">
                Discard
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
}

export default CreateBook;
