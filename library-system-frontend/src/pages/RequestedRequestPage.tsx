
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Request } from "../models";
import * as requestService from '../service'
import * as helper from '../helper'
import { RequestStatus } from "../types";


function RequestedRequestPage() {
  const { id } = useParams();
  const requestDefault = new Request("", "", "", "", "", "");
  const [bookRequest, setRequest] = useState(requestDefault);
  const [details, setDetails] = useState("");
  const [disabled, setDisabled] = useState(false);

  useEffect(() => {
    async function getReceivedRequest() {
      const response = await requestService.getRequestByRequestId(id || "");
      if (response !== null) {
        setRequest(response);
        setDetails(response.details);
        if(response.status === "CANCELED" || response.status === "APPROVED" 
            || response.status === "REJECTED"
        ) { setDisabled(true)}
      }
    }
    getReceivedRequest();
  }, [id]);


  async function updateRequest()
  {
    bookRequest.details = details;
    const response = await requestService.updateRequest(bookRequest);
    if(response === null) {alert("Something went wrong. Please try again later"); return;}
    alert("Request has been updated.")

  }

  async function cancelRequest()
  {
    bookRequest.status = helper.transformBookStatusToRequestString(RequestStatus.CANCELED) || "";
    const response = await requestService.updateRequest(bookRequest);
    if(response === null) {alert("Something went wrong. Please try again later"); return;}
    setDisabled(true);
    alert("Request has been canceled.")
  }

  return (
    <main className="container mx-auto px-3 py-3 md:p-0">
      <div className="flex flex-col gap-y-3 gap-x-3 items-center mt-8">
        <div className="w-full bg-white rounded-lg shadow-2xl ">
          <div className="py-12 px-5 md:pl-10">
            <div className="flex flex-row gap-x-2 mb-5">
              <h1 className="text-3xl font-bold tracking-widest">
              Book Request
              </h1>
            </div>
            <div className="flex flex-row mt-1 gap-x-2 items-center">
              <label className="text-md font-medium">Status: </label>
              <p>{bookRequest.status}</p>
            </div>
            <div className="flex flex-row mt-2 gap-x-2 items-center">
              <label className="text-md font-medium">To: </label>
              <p>{bookRequest.receivingUserId}</p>
            </div>

            <div className="flex flex-row mt-2 gap-x-2 items-center">
              <label className="text-md font-medium">From: </label>
              <p>{bookRequest.requestingUserId}</p>
            </div>


            <div className="flex flex-col gap-x-2 mt-6">
              <label className="text-lg text-slate-500">Details:</label>
              <textarea
              disabled={disabled}
              value={details}
              onChange={(e) => setDetails(e.target.value)}
                id="id-l03"
                name="id-l03"
                rows={3}
                className="peer relative w-full rounded border border-slate-300 p-4 text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-green-700 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
              ></textarea>
            </div>

            <div className="flex flex-row items-center w-full justify-center md:justify-normal gap-x-5 md:w-[40%] mt-10">
              <button 
              disabled={disabled}
              onClick={updateRequest}
              className={`rounded-lg px-4 py-2 font-medium ${disabled ? "bg-green-800 text-gray-300": "bg-green-300 hover:bg-green-700 hover:text-white duration-300"} `}>
                Update
              </button>
              <button
              disabled={disabled}
              onClick={cancelRequest}
               className={`rounded-lg px-4 py-2 font-medium ${disabled ? "bg-red-800 text-gray-300": "bg-red-500 hover:bg-red-800 hover:text-white duration-300"} `}>
                Cancel
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
}

export default RequestedRequestPage;
