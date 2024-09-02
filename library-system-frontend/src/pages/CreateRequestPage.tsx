
import { useState, useEffect, useContext } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { Book, RequestRequest } from "../models";
import { UserContext } from "../App";
import * as requestService from '../service'
import * as helper from '../helper'
import { RequestStatus } from "../types";


function CreateRequestPage() {
  const navigate = useNavigate();
  const { id } = useParams();
  const context = useContext(UserContext);
  const [details, setDetails] = useState("")
  const bookDefault = new Book("", "", "", "", "", false, "", "", "", "");
  const [book, setBook] = useState(bookDefault);

  if(!context)
    {
      return null;
    }

  const [user] = context;

  useEffect(() => {
    async function getUserBook() {
      const response = await requestService.getBook(id || "");
      if (response !== null) {
        setBook(response);
        setDetails(`Request for the book ${response.title}\n`)
      }
    }
    getUserBook();
  }, [id]);

  

  const discard = () => 
    {
    alert("Request has been discarded.")
    navigate("/discover");
  }

  async function createRequest()
  {
    const request = new RequestRequest(user.userId, book.ownerUserId, helper.transformBookStatusToRequestString(RequestStatus.PENDING) || "", details);
    const response = requestService.createNewRequest(request);
    if(response === null) { alert("Something went wrong. Please try again later."); return;}
    alert("Response has been created");
    navigate('/request');
  }

  return (
    <main className="container mx-auto">
      <div className="flex flex-col gap-y-3 gap-x-3 items-center mt-8">
        <div className="w-full bg-white rounded-lg shadow-2xl ">
          <div className="py-12 px-5 md:pl-10">
            <div className="flex flex-row gap-x-2 mb-5">
              <h1 className="text-3xl font-bold tracking-widest">
              New Request
              </h1>
            </div>

            <div className="flex flex-row mt-2 gap-x-2 items-center">
              <label className="text-md font-medium">To User: </label>
              <p>{book.ownerUserId}</p>
            </div>

            <div className="flex flex-row mt-2 gap-x-2 items-center">
              <label className="text-md font-medium">From: </label>
              <p>{user.userId}</p>
            </div>


            <div className="flex flex-col gap-x-2 mt-6">
              <label className="text-lg text-slate-500">Details:</label>
              <textarea
              value={details}
              onChange={(e) => setDetails(e.target.value)}
                id="id-l03"
                name="id-l03"
                rows={3}
                placeholder="Write your message"
                className="peer relative w-full rounded border border-slate-300 p-4 text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-green-700 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
              ></textarea>
            </div>

            <div className="flex flex-row items-center w-full justify-center md:justify-normal gap-x-5 md:w-[40%] mt-10">
              <button 
              onClick={createRequest}
              className="rounded-lg px-4 py-2 font-medium bg-green-300 hover:bg-green-700 hover:text-white duration-300">
                Request
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

export default CreateRequestPage;
