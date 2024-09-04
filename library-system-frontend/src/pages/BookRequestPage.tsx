
import { useContext, useState, useEffect } from "react";
import { UserContext } from "../App";
import * as requestService from '../service'
import RequestRequestedListItem from "../utilities/items/RequestRequestedListItem";
import RequestReceivedListItem from "../utilities/items/RequestReceivedListItem";


function BookRequestPage()
{
    const [receivedRequests, setReceivedRequests] = useState([]);
    const [sentRequests, setSentRequests] = useState([])
    const context = useContext(UserContext);

    if(!context) { return null; }

    const [user] = context;


    // eslint-disable-next-line react-hooks/rules-of-hooks
    useEffect(() => {
        async function getRequests() 
        {
            const receivedRequestResponse = await requestService.getRequestByReceiver(user.userId);
            const requestedRequestResponse = await requestService.getRequestByRequester(user.userId);

            if(receivedRequestResponse !== null) { setReceivedRequests(receivedRequestResponse); }
            if(requestedRequestResponse !== null) { setSentRequests(requestedRequestResponse); }
        }

        if(user.userId !== "") { getRequests(); }

    }, [user])


    return (
        <main className="container py-5 px-8 md:mx-auto md:p-0">
            <h1 className="my-5 text-3xl font-bold">My <span className="text-green-700">Requests</span></h1>

            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">Requests <span className="text-green-700">Recieved</span></h2>
                <div className="border-t w-full mt-2">
                    <div className="flex flex-col gap-y-2 mt-1">
                    {
                        receivedRequests.map((item, key) => {
                            return <RequestReceivedListItem request={item} key = {key} />
                        })
                    }
                    </div>

                </div>
            </div>

            <div className="mt-10">
                <h2 className="text-2xl font-semibold ">Requests <span className="text-green-700">Sents</span></h2>
                <div className="border-t w-full mt-2">
                <div className="flex flex-col gap-y-2 mt-1">
                    {
                        sentRequests.map((item, key) => {
                            return <RequestRequestedListItem request={item} key = {key} />
                        })
                    }
                </div>
                </div>
            </div>
        </main>
    )
}

export default BookRequestPage;